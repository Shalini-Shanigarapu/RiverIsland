package CartModule.testcases;

import CartModule.base.BaseClass;
import CartModule.pages.AddingProductFromPagesToCart;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddProductFromWomenPage extends BaseClass {

    AddingProductFromPagesToCart addingProductFromPagesToCart;

    @BeforeMethod
    public void initialization()
    {
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);
    }



    @Test
    public void addProductFromWomenPage() throws IOException, ParseException, InterruptedException {

        addingProductFromPagesToCart.addProductFromWomen("8");

    }
}
