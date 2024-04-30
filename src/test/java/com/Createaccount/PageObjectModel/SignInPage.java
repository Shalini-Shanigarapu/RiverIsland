package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static POM.MyAccountPage.enterEmail;

public class SignInPage {
    private WebDriver driver;
    public SignInPage(WebDriver driver){

        this.driver=driver;
    }
    public static String SignIn = "[data-testid='password-validation-page-heading']";
    public static String enterPassword= "password";
    public static String signInbtn = "[data-testid='sign-in-button']";
    public static String invalidpwderr="[data-testid='error-message']";
    public static String txtEmail="[data-testid='forgotten-password-success-message']";
    public void verifySignInPage(){
        boolean isSignInPage=driver.findElement(By.cssSelector(SignIn)).isDisplayed();
        if(isSignInPage){
            System.out.println("Successfully navigated to the SignIn Page");

        }else {
            System.out.println("Navigated to the Create an Account Page");
        }


    }
    public void enterPassword(String pwd){
        driver.findElement(By.id(enterPassword)).sendKeys(pwd);

    }
    public void clickSignIn(){
        driver.findElement(By.cssSelector(signInbtn)).click();
    }
    public void verifyinvalidPwderrorMsg(){
        WebElement pwdError = driver.findElement(By.cssSelector(invalidpwderr));
        String actualErrorMsg = pwdError.getText();
        String exceptedErrorMsg ="Unable to find a match for your email or password. Please check your details and try again.";
        Assert.assertEquals(actualErrorMsg,exceptedErrorMsg,"Error message misMatch");


    }
    public void Verifymailtxt(){
        WebElement txtmsg = driver.findElement(By.cssSelector(txtEmail));
        String actualtxt = txtmsg.getText();
        String exceptedtxt ="We've sent an email with a link to create a new password. If you cannot find it in your inbox, try checking your junk folder as well.";
        Assert.assertEquals(actualtxt,exceptedtxt,"text mismatch");

    }


}
