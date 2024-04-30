package CartModule.testcases;

import CartModule.base.BaseClass;
import CartModule.pages.Cart;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class IncreaseProductQuantity extends BaseClass {


    Cart cart;

    @BeforeClass
    public void initialization() {
        cart = new Cart(driver);
    }


    @Test
    public void increaseProductQuantity() throws IOException, ParseException, InterruptedException {
        cart.increaseProductQuantity();
    }

}
