package Tests;

import POM.CreateAccountPage;
import POM.HomePage;
import POM.MyAccountPage;
import org.testng.annotations.Test;

public class ValidEmailFormat extends BaseTest{
    @Test
    public void checkmailFormat(){
        HomePage homePage = new HomePage(driver);
        homePage.clickAccept();
        homePage.clickAccount();
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.setEnterEmail();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.verifyCreateAccountPage();
    }
}
