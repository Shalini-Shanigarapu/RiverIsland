package Tests;

import POM.CreateAccountPage;
import POM.HomePage;
import POM.MyAccountPage;
import POM.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginwithValidCredentials extends BaseTest {
    @Test(dataProvider = "Email", dataProviderClass = ExcelTestData.class)
    public void login(String Email,String pwd) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccept();
        homePage.clickAccount();
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.existEmail(Email);
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPassword(pwd);
        Thread.sleep(5000);
        signInPage.clickSignIn();
        CreateAccountPage createAccountPage=new CreateAccountPage(driver);
        createAccountPage.VerifyHomepage();



    }
}
