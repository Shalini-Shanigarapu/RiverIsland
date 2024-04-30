package Tests;

import POM.CreateAccountPage;
import POM.HomePage;
import POM.MyAccountPage;
import POM.SignInPage;
import org.testng.annotations.Test;

public class ForgetPassword extends BaseTest {
    @Test()
    public void forgetpwd() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        homePage.clickAccept();
        homePage.clickAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.Enterforgetmail();
        myAccountPage.forgetpwdLink();
        myAccountPage.EnterwhatsyourMail();
        Thread.sleep(30000);
        myAccountPage.clickForgettenContinuebtn();
        signInPage.Verifymailtxt();


    }
}
