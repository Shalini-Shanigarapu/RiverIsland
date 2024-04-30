package CartModule.testcases;

import CartModule.base.BaseClass;
import CartModule.pages.AccurateDetails;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccurateDetailsTestCase extends BaseClass {


    AccurateDetails accurateDetails;

    @BeforeClass
    public void initialization() {
        accurateDetails = new AccurateDetails(driver);
    }
    @Test
    public void accurateDetails() throws IOException, ParseException, InterruptedException {
        accurateDetails.accurateDetailsMethod();
    }
}
