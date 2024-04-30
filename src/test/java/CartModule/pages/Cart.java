package CartModule.pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class Cart {


    WebDriver driver;
    Cart cart ;
    AddingProductFromPagesToCart addingProductFromPagesToCart;


    public Cart(WebDriver cartdriver)
    {
        this.driver = cartdriver;

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
    WebElement expectedEle;

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


        expectedEle = driver.findElement(By.xpath("//p[@data-qa='price']/span"));
        String expectedPrice = expectedEle.getText();
        System.out.println("After Adding By Plus Sign " + expectedPrice);

        Assert.assertEquals(actualPrice,expectedPrice);

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

        totalPriceEle = driver.findElement(By.xpath("//span[text()='Total']/parent::p/following-sibling::p"));
        String totalPriceBefore =totalPriceEle.getText();
        System.out.println("Total Price before removing product" + totalPriceBefore);

        removeProduct();

        totalPriceEle = driver.findElement(By.xpath("//span[text()='Total']/parent::p/following-sibling::p"));
        String totalPriceAfter = totalPriceEle.getText();

        System.out.println("Total Price After removing product" + totalPriceAfter);


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
        addingProductFromPagesToCart.addProductFromMen();
        checkoutEle = driver.findElement(By.xpath("//div[@data-qa='totals']/../following-sibling::div/button"));
        checkoutEle.click();


    }



}
