package Tests;

import POM.CreateAccountPage;
import POM.HomePage;
import POM.MyAccountPage;
import POM.SignInPage;
import org.testng.annotations.Test;

public class LoginInvalidPwd extends BaseTest{
    @Test()
    public void invalidPwd() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        homePage.clickAccept();
        homePage.clickAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.loginmail();
        createAccountPage.enterweakPassword();
        Thread.sleep(10000);
        signInPage.clickSignIn();
        signInPage.verifyinvalidPwderrorMsg();

    }

}
