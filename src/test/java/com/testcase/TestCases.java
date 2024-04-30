package com.testcase;

import CartModule.base.BaseClass;
import CartModule.pages.*;
import CartModule.testcases.AccurateDetailsTestCase;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCases extends BaseClass {



    Cart cart;
    AddingProductFromPagesToCart addingProductFromPagesToCart;

    AccurateDetails accurateDetails;

    FromPagesToCart fromPagesToCart;
    LogoutAndLogin logoutAndLogin;


    @BeforeClass
    public void initialization()
    {
        cart = new Cart(driver);
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);
        accurateDetails = new AccurateDetails(driver);
        fromPagesToCart = new FromPagesToCart(driver);
        logoutAndLogin = new LogoutAndLogin(driver);
    }


//
//    @Test(priority = 1)
//    public void addProductFromWomenPage() throws IOException, ParseException, InterruptedException {
//        addingProductFromPagesToCart.addProductFromWomen();
//
//    }


//    @Test(priority = 2)
//    public void addProductFromMenPage() throws IOException, ParseException, InterruptedException {
//
//        addingProductFromPagesToCart.addProductFromMen();

    }


//    @Test(priority = 3)
//    public void addProductFromGirlsPage() throws IOException, ParseException, InterruptedException {
//        addingProductFromPagesToCart.addProductFromGirls();
//    }
//
//    @Test(priority = 4)
//    public void addProductFromBoysPage() throws IOException, ParseException, InterruptedException {
//        addingProductFromPagesToCart.addProductFromBoys();
//    }
//
//
//    @Test(priority = 5)
//    public void addProductFromHolidaysPage() throws IOException, ParseException, InterruptedException {
//        addingProductFromPagesToCart.addProductFromHolidayShop("Womens");
//    }
//
//    @Test(priority = 6)
//    public void addProductFromJeansPage() throws IOException, ParseException, InterruptedException {
//        addingProductFromPagesToCart.addProductFromJeans("Shop Mens");
//    }
//    @Test(priority = 7)
//    public void accurateDetails() throws IOException, ParseException, InterruptedException {
//        accurateDetails.accurateDetailsMethod();
//    }
//    @Test(priority = 8)
//    public void homepageTOCart() throws IOException, ParseException, InterruptedException {
//        fromPagesToCart.homepageToCart();
//    }
//    @Test(priority = 9)
//    public void womenPageToCart() throws IOException, ParseException, InterruptedException {
//        fromPagesToCart.womenPageToCart();
//    }
//
//
//
//    @Test(priority = 13)
//    public void holidayShopPageToCart() throws IOException, ParseException, InterruptedException {
//        fromPagesToCart.holidayShopPageToCart("Mens");
//    }
//
//    @Test(priority = 14)
//    public void jeansPageToCart() throws IOException, ParseException, InterruptedException {
//        fromPagesToCart.jeansPageToCart("Shop Girls");
//    }
//    @Test(priority = 15)
//    public void increaseProductQuantity() throws IOException, ParseException, InterruptedException {
//        cart.increaseProductQuantity();
//    }
//    @Test(priority = 16)
//    public void removeProductFromCart() throws IOException, ParseException, InterruptedException {
//        cart.removeProductFromCart();
//    }
//    @Test(priority = 17)
//    public void logoutAndLogInMethod() throws IOException, ParseException, InterruptedException {
//        logoutAndLogin.logoutAndLogInMethod();
//    }
//    @Test(priority = 18)
//    public void checkoutPage() throws IOException, ParseException, InterruptedException {
//        cart.checkoutPage();
//    }
//    @Test(priority = 19)
//    public void testcaseNineteen()
//    {
//
//    }



//}
