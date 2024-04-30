package CartModule.pages;

import CartModule.pages.AddingProductFromPagesToCart;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class LogoutAndLogin
{
    WebDriver driver;
    AddingProductFromPagesToCart addingProductFromPagesToCart;


    public LogoutAndLogin(WebDriver logoutdriver)
    {
        this.driver= logoutdriver;
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);

    }


    WebElement continueShoppingEle;
    WebElement accountEle;
    WebElement signOutEle;
    WebElement bagEle;
    WebElement viewBagEle;


    public void logoutAndLogInMethod() throws IOException, ParseException, InterruptedException {
        addingProductFromPagesToCart.addProductFromWomen();

        continueShoppingEle = driver.findElement(By.linkText("Continue shopping"));
        continueShoppingEle.click();

        accountEle = driver.findElement(By.linkText("Account"));
        accountEle.click();

        signOutEle = driver.findElement(By.xpath("//nav[@data-type='my-account']/following-sibling::div/following-sibling::div/div/button[text()='Sign out']"));
        signOutEle.click();

        addingProductFromPagesToCart.signIn();

        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
        bagEle.click();

        viewBagEle =driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();

         List<WebElement>cartSizeEle = driver.findElements(By.cssSelector("[data-qa='cart-item']"));
         int cartSize = cartSizeEle.size();

         WebElement ele = driver.findElement(By.cssSelector("[data-qa='cart-item']"));
         String size = ele.getSize().toString();

         Assert.assertTrue(true);
        Assert.assertEquals(size,1);

    }


}
