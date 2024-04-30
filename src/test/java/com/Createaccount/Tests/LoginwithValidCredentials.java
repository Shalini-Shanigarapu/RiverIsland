package com.Createaccount.Tests;

import com.Createaccount.PageObjectModel.CreateAccountPage;
import com.Createaccount.PageObjectModel.HomePage;
import com.Createaccount.PageObjectModel.MyAccountPage;
import com.Createaccount.PageObjectModel.SignInPage;
import org.testng.annotations.Test;

public class LoginwithValidCredentials extends BaseTest {
    @Test(dataProvider = "Email", dataProviderClass = ExcelTestData.class)
    public void login(String Email,String pwd) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccept();
        homePage.clickAccount();
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.existEmail(Email);
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPassword(pwd);
        Thread.sleep(30000);
        signInPage.clickSignIn();
        CreateAccountPage createAccountPage=new CreateAccountPage(driver);
        createAccountPage.VerifyHomepage();



    }
}
