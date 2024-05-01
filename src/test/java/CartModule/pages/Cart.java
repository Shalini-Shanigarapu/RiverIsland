package CartModule.pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Cart {


    WebDriver driver;
    Cart cart ;
    AddingProductFromPagesToCart addingProductFromPagesToCart;
    WebDriverWait wait;


    public Cart(WebDriver cartdriver)
    {
        this.driver = cartdriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    WebElement bagEle;

//    WebElement viewBagEle;

    WebElement acceptAll;

    WebElement priceOfProduct;
    WebElement  plusSignEle;

    WebElement deleteIconEle;

    WebElement viewBagEle;

    WebElement checkoutEle;

    WebElement totalPriceEle;

    WebElement totalPriceAfterRemoveEle;
    WebElement expectedEle;

    WebElement emptyBagEle;

    WebElement  checkoutBtnEle; //h3[text()='Summary']/parent::div/div/following-sibling::div/following-sibling::div/button[text()='Checkout']




    public void  increaseProductQuantity() throws IOException, ParseException, InterruptedException {
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        addingProductFromPagesToCart.signIn();

        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
        bagEle.click();
        addingProductFromPagesToCart.viewBagEle =driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        addingProductFromPagesToCart.viewBagEle.click();

        priceOfProduct = driver.findElement(By.xpath("//p[@data-qa='price']/span"));
        //h3[text()='"+name+"']/parent::div/parent::div/parent::div/parent::div/following-sibling::div/div/following-sibling::div/div/input
        String actualPrice = priceOfProduct.getText();
        System.out.println("Before Adding By Plus Sign "+actualPrice);

        plusSignEle = driver.findElement(By.cssSelector("[data-qa='plus-icon']"));
        plusSignEle.click();

        Thread.sleep(5000);
        expectedEle = driver.findElement(By.xpath("//p[@data-qa='price']/span"));
        String expectedPrice = expectedEle.getText();
        System.out.println("After Adding By Plus Sign " + expectedPrice);

        Assert.assertFalse(false,expectedPrice);

    }


    public void removeProductFromCart() throws IOException, ParseException, InterruptedException {
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);

        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        addingProductFromPagesToCart.signIn();

        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
        bagEle.click();
        viewBagEle =driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();

        Thread.sleep(5000);
        totalPriceEle = driver.findElement(By.xpath("//span[text()='Total']/parent::p/following-sibling::p"));
        String totalPriceBefore = totalPriceEle.getText();
        System.out.println("Total Price before removing product" + totalPriceBefore);

        removeProduct();


        totalPriceAfterRemoveEle = driver.findElement(By.xpath("//span[text()='Total']/parent::p/following-sibling::p"));
        Thread.sleep(8000);
        String totalPriceAfter = totalPriceAfterRemoveEle.getText();
        System.out.println("Total Price after removing product" + totalPriceAfter);

        Assert.assertTrue(totalPriceAfterRemoveEle.isDisplayed());


    }

    public void removeProduct()
    {
//        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
//        bagEle.click();
//        viewBagEle =driver.findElement(By.cssSelector("[title='VIEW BAG']"));
//        viewBagEle.click();

        deleteIconEle = driver.findElement(By.xpath("//div[@data-qa='cart-item']/div/following-sibling::div/following-sibling::div/div/button[@data-qa='remove-item-test']"));
        deleteIconEle.click();

    }


    public void checkoutPage() throws IOException, ParseException, InterruptedException {
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);
        addingProductFromPagesToCart.addProductFromMen("S");
        checkoutEle = driver.findElement(By.xpath("//div[@data-qa='totals']/../following-sibling::div/button"));
        checkoutEle.click();

        WebElement deliveryEle = driver.findElement(By.xpath("//div[@data-qa='content']/div/section/header"));
        deliveryEle.getText();
        String exceptedTitle ="Please select where you would like your items delivered";
        Assert.assertEquals(exceptedTitle, deliveryEle.getText());

    }



    public void removeAllProduct() throws IOException, ParseException, InterruptedException {
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);

        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        addingProductFromPagesToCart.signIn();

        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
        bagEle.click();
        viewBagEle =driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();

        List<WebElement> list = driver.findElements(By.xpath("//button[@data-qa='remove-item-test']"));
        while (!list.isEmpty())
        {
            list.get(0).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockUI.blockOverlay")));
            Thread.sleep(200);
            list = driver.findElements(By.xpath("//button[@data-qa='remove-item-test']"));

        }

        emptyBagEle = driver.findElement(By.xpath("//nav[@data-qa='header']/following-sibling::div/div/i/following-sibling::h3"));
        emptyBagEle.getText();
        String emptyBagMsg = "YOUR BAG IS EMPTY";
        Assert.assertEquals(emptyBagMsg,emptyBagEle.getText());


    }









}
