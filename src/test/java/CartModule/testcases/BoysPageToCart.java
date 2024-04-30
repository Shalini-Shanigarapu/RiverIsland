package CartModule.testcases;

import CartModule.base.BaseClass;
import CartModule.pages.AddingProductFromPagesToCart;
import CartModule.pages.Cart;
import CartModule.pages.FromPagesToCart;
import CartModule.pages.LogoutAndLogin;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class BoysPageToCart extends BaseClass {


    FromPagesToCart fromPagesToCart;

    @BeforeClass
    public void initialization()
    {
        fromPagesToCart = new FromPagesToCart(driver);
    }

    @Test
    public void boysPageToCart() throws IOException, ParseException, InterruptedException {
    fromPagesToCart.boysPageToCart();


    }
}
