package CartModule.testcases;

import CartModule.base.BaseClass;
import CartModule.pages.AddingProductFromPagesToCart;
import CartModule.pages.Cart;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddProductFromJeansPage extends BaseClass {


    AddingProductFromPagesToCart addingProductFromPagesToCart;
    @BeforeClass
    public void initialization() {
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);
    }
    @Test
    public void addProductFromJeansPage() throws IOException, ParseException, InterruptedException {
        addingProductFromPagesToCart.addProductFromJeans("Shop Mens");
    }


}
