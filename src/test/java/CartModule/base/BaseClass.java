package CartModule.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {

    public WebDriver driver;



    @BeforeClass
    public void launchApplication()
    {

            driver = new ChromeDriver();
            driver.get("https://www.riverisland.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
