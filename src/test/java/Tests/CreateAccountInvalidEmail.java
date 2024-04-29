package Tests;

import POM.HomePage;
import POM.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountInvalidEmail extends BaseTest{
    @Test
    public void InvalidEmail(){

        HomePage homePage = new HomePage(driver);
        homePage.clickAccept();
        homePage.clickAccount();
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.EnterEmail();
        myAccountPage.verifyErrormsg();
    }
}

