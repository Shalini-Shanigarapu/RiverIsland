package CartModule.testcases;

import CartModule.base.BaseClass;
import CartModule.pages.LogoutAndLogin;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogoutAndLogInTestCase extends BaseClass {



    LogoutAndLogin logoutAndLogin;

    @BeforeMethod
    public void initialization() {
        logoutAndLogin = new LogoutAndLogin(driver);
    }



    @Test
    public void logoutAndLogInMethod() throws IOException, ParseException, InterruptedException {
        logoutAndLogin.logoutAndLogInMethod();
    }


}
