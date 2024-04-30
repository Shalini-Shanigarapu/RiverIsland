package com.Createaccount.Tests;

import com.Createaccount.PageObjectModel.CreateAccountPage;
import com.Createaccount.PageObjectModel.HomePage;
import com.Createaccount.PageObjectModel.MyAccountPage;
import org.testng.annotations.Test;

public class CreationWeakPassword extends BaseTest{
    @Test
            public void weakPassword() throws InterruptedException {
    HomePage homePage = new HomePage(driver);
    homePage.clickAccept();
    homePage.clickAccount();
    MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.VerifyMyAccountpage();
        myAccountPage.setEnterEmail();
    CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.selectTitle();
        createAccountPage.setFnameLname();
        createAccountPage.enterweakPassword();
        createAccountPage.enterDOB();
     Thread.sleep(30000);
        createAccountPage.clickCreatebtn();
        createAccountPage.verifyPasswordErrorMsg();

}
}
