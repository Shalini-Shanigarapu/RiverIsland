package Tests;

import POM.CreateAccountPage;
import POM.HomePage;
import POM.MyAccountPage;
import org.testng.annotations.Test;

public class ConfirmationMail extends BaseTest{
    @Test
    public void successfulRegister() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccept();
        homePage.clickAccount();
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.VerifyMyAccountpage();
        myAccountPage.setEmail();
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
