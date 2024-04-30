package CartModule.testcases;

import CartModule.base.BaseClass;
import CartModule.pages.AddingProductFromPagesToCart;
import CartModule.pages.Cart;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddProductFromBoysPage extends BaseClass {


    AddingProductFromPagesToCart addingProductFromPagesToCart;


    public void initialization() {
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);
    }

    @Test
    public void addProductFromBoysPage() throws IOException, ParseException, InterruptedException {
        addingProductFromPagesToCart.addProductFromBoys();
    }

}
