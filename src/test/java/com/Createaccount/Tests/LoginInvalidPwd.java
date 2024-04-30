package com.Createaccount.Tests;

import com.Createaccount.PageObjectModel.CreateAccountPage;
import com.Createaccount.PageObjectModel.HomePage;
import com.Createaccount.PageObjectModel.MyAccountPage;
import com.Createaccount.PageObjectModel.SignInPage;
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
        Thread.sleep(30000);
        signInPage.clickSignIn();
        signInPage.verifyinvalidPwderrorMsg();

    }

}
