package com.Createaccount.Tests;

import com.Createaccount.PageObjectModel.HomePage;
import com.Createaccount.PageObjectModel.MyAccountPage;
import org.testng.annotations.Test;

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

