package POM;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.swing.plaf.PanelUI;

public class MyAccountPage {
    private WebDriver driver;
    public MyAccountPage(WebDriver driver){
        this.driver=driver;
    }
    public static String myAccountpage = "//h1[text()='MY ACCOUNT']";
    public static String enterEmail="email";
    public static String continuebtn="//button[@data-testid='email-login-button']";
    public static String errMsg="//label[@class='label email']//following-sibling::div[@data-testid='input-error-email']";
    public static String FPlINK = "[data-testid='forgot-password-link']";
    public static String forgeetenConbtn ="[data-testid='forgotten-password-button']";


    public void VerifyMyAccountpage() {

        driver.findElement(By.xpath(myAccountpage)).isDisplayed();
    }
    public void setEnterEmail() {
        String randomMail = RandomString.make();
        String email = randomMail+"@gmail.com";
        driver.findElement(By.id(enterEmail)).sendKeys(email);
        driver.findElement(By.xpath(continuebtn)).click();
    }
    public void EnterEmail() {
        String randomMail = RandomString.make();
        String email = randomMail;
        driver.findElement(By.id(enterEmail)).sendKeys(email);
        driver.findElement(By.xpath(continuebtn)).click();
    }
    public void existEmail(String mail){
        driver.findElement(By.id(enterEmail)).sendKeys(mail);
        driver.findElement(By.xpath(continuebtn)).click();
    }
    public void verifyErrormsg(){
        WebElement errmsg = driver.findElement(By.xpath(errMsg));
        String actualErrorMsg = errmsg.getText();
        String exceptedErrorMsg ="Enter a valid email address, e.g. in the format user@domain.com";
        Assert.assertEquals(actualErrorMsg,exceptedErrorMsg,"Error message misMatch");

    }
    public void loginmail(){
        driver.findElement(By.id(enterEmail)).sendKeys("shanigarapushalini1@gmail.com");
        driver.findElement(By.xpath(continuebtn)).click();
    }
    public void Enterforgetmail(){
        driver.findElement(By.id(enterEmail)).sendKeys("shalini.shanigarapu99@gmail.com");
        driver.findElement(By.xpath(continuebtn)).click();
    }
    public void forgetpwdLink(){
        driver.findElement(By.cssSelector(FPlINK)).click();

    }
    public void EnterwhatsyourMail(){
        driver.findElement(By.id(enterEmail)).clear();
        driver.findElement(By.id(enterEmail)).sendKeys("shalini.shanigarapu99@gmail.com");
    }
    public void clickForgettenContinuebtn(){
        driver.findElement(By.cssSelector(forgeetenConbtn)).click();
    }


}


