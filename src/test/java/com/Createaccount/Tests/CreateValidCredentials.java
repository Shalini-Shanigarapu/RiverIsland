package com.Createaccount.Tests;


import com.Createaccount.PageObjectModel.CreateAccountPage;
import com.Createaccount.PageObjectModel.HomePage;
import com.Createaccount.PageObjectModel.MyAccountPage;
import org.testng.annotations.Test;


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
