package com.Createaccount.Tests;

import com.Createaccount.PageObjectModel.CreateAccountPage;
import com.Createaccount.PageObjectModel.HomePage;
import com.Createaccount.PageObjectModel.MyAccountPage;
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
