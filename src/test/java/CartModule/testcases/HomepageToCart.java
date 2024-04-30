package CartModule.testcases;

import CartModule.base.BaseClass;
import CartModule.pages.FromPagesToCart;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomepageToCart extends BaseClass {



    FromPagesToCart fromPagesToCart;


    @BeforeClass
    public void initialization() {

        fromPagesToCart = new FromPagesToCart(driver);
    }



    @Test
    public void homepageTOCart() throws IOException, ParseException, InterruptedException {
        fromPagesToCart.homepageToCart();
    }
}
