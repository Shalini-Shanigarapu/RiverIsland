package CartModule.pages;

import CartModule.pages.AddingProductFromPagesToCart;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LogoutAndLogin
{
    WebDriver driver;
    AddingProductFromPagesToCart addingProductFromPagesToCart;

    JavascriptExecutor jse;


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

    WebElement emailEle;
    WebElement continueBtnEle;
    WebElement passwordEle;
    WebElement signInBtnEle;
    WebElement exceptedPageTextEle;




    public void logoutAndLogInMethod() throws IOException, ParseException, InterruptedException {
        addingProductFromPagesToCart.addProductFromWomen("8");

        continueShoppingEle = driver.findElement(By.linkText("Continue shopping"));
        continueShoppingEle.click();

        accountEle = driver.findElement(By.linkText("Account"));
        accountEle.click();

        signOutEle = driver.findElement(By.xpath("//nav[@data-type='my-account']/following-sibling::div/following-sibling::div/div/button[text()='Sign out']"));
        signOutEle.click();

        accountEle = driver.findElement(By.linkText("Account"));
        accountEle.click();

        exceptedPageTextEle =driver.findElement(By.xpath("//div[@id='login']/div/div/div/div/h1"));
        System.out.println(exceptedPageTextEle.getText());
        String exceptedPageText = "MY ACCOUNT";
        Assert.assertEquals(exceptedPageText,exceptedPageTextEle.getText());

         reSignIn();

        bagEle = driver.findElement(By.cssSelector("[title='Bag']"));
        bagEle.click();

        viewBagEle =driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();



         WebElement ele = driver.findElement(By.cssSelector("[data-qa='cart-item']"));
         Assert.assertTrue(ele.isDisplayed());



    }

    public void reSignIn() throws IOException, ParseException, InterruptedException {
        jse = (JavascriptExecutor)driver;



        emailEle = driver.findElement(By.cssSelector("#email"));
        emailEle.click();

        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/test/TestData/ file.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject)obj;

        String email = jsonObject.get("Email").toString();
        String password = jsonObject.get("Password").toString();

        emailEle.sendKeys(email);
        continueBtnEle = driver.findElement(By.cssSelector("[type='submit']"));
        continueBtnEle.click();
        passwordEle = driver.findElement(By.cssSelector("#password"));
        passwordEle.click();
        passwordEle.sendKeys(password);
        Thread.sleep(10000);

        signInBtnEle = driver.findElement(By.xpath("//button[text()='Sign in']"));
        jse.executeScript("arguments[0].click();",signInBtnEle);
    }



}
