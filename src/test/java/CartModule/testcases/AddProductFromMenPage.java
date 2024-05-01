package CartModule.testcases;

import CartModule.base.BaseClass;
import CartModule.pages.AddingProductFromPagesToCart;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class AddProductFromMenPage extends BaseClass {
    AddingProductFromPagesToCart addingProductFromPagesToCart;


    @BeforeMethod
    public void initialization() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        addingProductFromPagesToCart = new AddingProductFromPagesToCart(driver);

    }

    @Test
    public void addProductFromMenPage() throws IOException, ParseException, InterruptedException {

        addingProductFromPagesToCart.addProductFromMen("S");
    }

}
