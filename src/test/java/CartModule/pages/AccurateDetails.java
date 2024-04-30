package CartModule.pages;

import commonmethods.ActionsClass;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AccurateDetails
{

    WebDriver driver;
    ActionsClass actionsClass;
    AddingProductFromPagesToCart addingProductFromPagesToCart;
    Cart cart;
    WebDriverWait wait;
    public AccurateDetails(WebDriver detailsdriver)
    {
        this.driver = detailsdriver;
        actionsClass =new ActionsClass(driver);
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);
        cart =new Cart(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

;    }



    WebElement acceptAll;
    WebElement menEle ;
    WebElement popularCategoriesEle  ;
    WebElement shirtEle ;
    WebElement productsTopBar ;
    WebElement productEle;
    WebElement productNameEle;
    WebElement productPriceEle;
    WebElement productNameInCartEle;
    WebElement productPriceInCartEle;
    WebElement newArrivalsEle;
    WebElement bagEle;
    WebElement viewBagEle;


    String productName ;
    String productPrice;
    String productNameInCart;
    String productPriceInCart;





    public void accurateDetailsMethod() throws InterruptedException, IOException, ParseException {
        actionsClass = new ActionsClass(driver);
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

        newArrivalsEle = driver.findElement(By.linkText("New Arrivals"));
        newArrivalsEle.click();

        menEle = driver.findElement(By.xpath("//span[text()='men']"));
        menEle.click();

        popularCategoriesEle = driver.findElement(By.xpath("//h2[text()='Popular Categories']"));
        actionsClass.scrollToElement(popularCategoriesEle);

        shirtEle = driver.findElement(By.cssSelector("[data-promo-name='Shirts']"));
        actionsClass.scrollToElement(shirtEle);
        Thread.sleep(2000);
        shirtEle.click();

        productsTopBar = driver.findElement(By.cssSelector("[data-qa='topBar']"));
        actionsClass.scrollToElement(productsTopBar);


        productEle = driver.findElement(By.xpath("//div[@data-qa='topBar']/following-sibling::div/div/following-sibling::div/a"));
        productEle.click();

        productNameEle = driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/parent::div/div/h1"));
        productName = productNameEle.getText();
        System.out.println("Product Name in Product Page : " + productName);

        productPriceEle = driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/parent::div/div/div/p/span"));
        productPrice = productPriceEle.getText();
        System.out.println("Product Price in Product Page : " + productPrice);
        addingProductFromPagesToCart.addToCartMethod("S");

        System.out.println("******************************");
        productNameInCartEle = driver.findElement(By.xpath("//div[@data-qa='cart-item']/div/following-sibling::div/a/following-sibling::div/div/div/h3"));
        productNameInCart = productNameInCartEle.getText();
        System.out.println("Product Name in cart Page : " + productNameInCart);




        productPriceInCartEle = driver.findElement(By.xpath("//div[@data-qa='cart-item']/div/following-sibling::div/a/following-sibling::div/div/div/following-sibling::div/p/span"));
        productPriceInCart = productPriceInCartEle.getText();
        System.out.println("Product Name in Cart Page : " + productPriceInCart);

    }






}
