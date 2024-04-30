package CartModule.testcases;

import CartModule.base.BaseClass;
import CartModule.pages.Cart;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutPage extends BaseClass {


    Cart cart;

    public void initialization()
    {
        cart = new Cart(driver);
    }


    @Test
    public void checkoutPage() throws IOException, ParseException, InterruptedException {
        cart.checkoutPage();
    }



}
