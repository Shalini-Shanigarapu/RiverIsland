package CartModule.testcases;

import CartModule.base.BaseClass;
import CartModule.pages.AddingProductFromPagesToCart;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddProductFromGirlsPage extends BaseClass {



    AddingProductFromPagesToCart addingProductFromPagesToCart;

    @BeforeClass
    public void initialization()
    {
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);
    }



    @Test
    public void addProductFromGirlsPage() throws IOException, ParseException, InterruptedException {

        addingProductFromPagesToCart.addProductFromGirls();

    }
}
