package Tests;


import POM.CreateAccountPage;
import POM.HomePage;
import POM.MyAccountPage;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;


public class CreateValidCredentials extends BaseTest{
    @Test
    public void CreateAccountValid() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccept();
        homePage.clickAccount();
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.VerifyMyAccountpage();
        myAccountPage.setEnterEmail();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.selectTitle();
        createAccountPage.setFnameLname();
        createAccountPage.enterPassword();
        createAccountPage.enterDOB();
     Thread.sleep(30000);
        createAccountPage.clickCreatebtn();
     Thread.sleep(10000);
        createAccountPage.VerifyHomepage();

    }
}
