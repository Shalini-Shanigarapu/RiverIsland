package CartModule.pages;

import CartModule.pages.AddingProductFromPagesToCart;
import CartModule.pages.Cart;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class FromPagesToCart {


    WebDriver driver;
    AddingProductFromPagesToCart addingProductFromPagesToCart;
    Cart cart ;

    public  FromPagesToCart(WebDriver pageDriver)
    {
        this.driver = pageDriver;
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);
        cart = new Cart(driver);
    }


    WebElement womenEle ;
    WebElement acceptAll;
    WebElement menEle;
    WebElement girlsEle;
    WebElement boysEle;
    WebElement holidayShopEle;
    WebElement jeansEle ;
    WebElement bagEle ;
    WebElement viewBagEle ;
    WebElement homePageEle;






    public void homepageToCart() throws IOException, ParseException, InterruptedException {
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        addingProductFromPagesToCart.signIn();

        homePageEle = driver.findElement(By.cssSelector("[data-item-name='logo']"));
        homePageEle.click();

        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
        bagEle.click();

        viewBagEle = driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();

        String exceptedTitle ="Cart";
        Assert.assertEquals(exceptedTitle,driver.getTitle());

    }


    public void womenPageToCart() throws IOException, ParseException, InterruptedException {
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        addingProductFromPagesToCart.signIn();

        womenEle = driver.findElement(By.xpath("//span[text()='women']"));
        womenEle.click();

        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
        bagEle.click();

        viewBagEle = driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();

        String exceptedTitle ="Cart";
        Assert.assertEquals(exceptedTitle,driver.getTitle());

    }



    public void menPageToCart() throws IOException, ParseException, InterruptedException {
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        addingProductFromPagesToCart.signIn();

        menEle = driver.findElement(By.xpath("//span[text()='men']"));
        menEle.click();

        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
        bagEle.click();

        viewBagEle = driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();

        String exceptedTitle ="Cart";
        Assert.assertEquals(exceptedTitle,driver.getTitle());

    }


    public void girlsPageToCart() throws IOException, ParseException, InterruptedException {
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        addingProductFromPagesToCart.signIn();

        girlsEle = driver.findElement(By.xpath("//span[text()='girls']"));
        girlsEle.click();

        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
        bagEle.click();

        viewBagEle = driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();

        String exceptedTitle ="Cart";
        Assert.assertEquals(exceptedTitle,driver.getTitle());

    }

    public void boysPageToCart() throws IOException, ParseException, InterruptedException {
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        addingProductFromPagesToCart.signIn();

        boysEle = driver.findElement(By.xpath("//span[text()='boys']"));
        boysEle.click();

        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
        bagEle.click();

        viewBagEle = driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();

        String exceptedTitle ="Cart";
        Assert.assertEquals(exceptedTitle,driver.getTitle());

    }


    public void holidayShopPageToCart(String subCategory) throws IOException, ParseException, InterruptedException {
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        addingProductFromPagesToCart.signIn();

        holidayShopEle = driver.findElement(By.cssSelector("[data-menu-hierarchy='Holiday shop']"));
        holidayShopEle.click();

        WebElement element = driver.findElement(By.linkText(subCategory));
        element.click();

        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
        bagEle.click();

        viewBagEle = driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();

        String exceptedTitle ="Cart";
        Assert.assertEquals(exceptedTitle,driver.getTitle());
    }


    public void jeansPageToCart(String subCategory) throws IOException, ParseException, InterruptedException {
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        addingProductFromPagesToCart.signIn();

        holidayShopEle = driver.findElement(By.cssSelector("[data-menu-hierarchy='Jeans']"));
        holidayShopEle.click();

        WebElement element = driver.findElement(By.linkText(subCategory));
        element.click();

        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
        bagEle.click();

        viewBagEle = driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();

        String exceptedTitle ="Cart";
        Assert.assertEquals(exceptedTitle,driver.getTitle());

    }



}
