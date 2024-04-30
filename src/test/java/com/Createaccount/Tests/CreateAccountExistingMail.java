package com.Createaccount.Tests;

import com.Createaccount.PageObjectModel.HomePage;
import com.Createaccount.PageObjectModel.MyAccountPage;
import com.Createaccount.PageObjectModel.SignInPage;
import org.testng.annotations.Test;

public class CreateAccountExistingMail extends BaseTest{

    @Test()
    public void existingEmail() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccept();
        homePage.clickAccount();
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.loginmail();
        SignInPage signInPage=new SignInPage(driver);
        signInPage.verifySignInPage();


    }


    }
