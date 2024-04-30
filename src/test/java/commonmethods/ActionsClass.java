package commonmethods;

import CartModule.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClass extends BaseClass {

    WebDriver driver;
    Actions actions ;
    public ActionsClass(WebDriver actiondriver)
    {
        this.driver= actiondriver;
        actions = new Actions(driver);

    }


    public void moveToElement(WebElement element)
    {

        actions.moveToElement(element).build().perform();
    }

    public void waitToElement(WebDriverWait wait){

    }

    public void scrollToElement(WebElement element)
    {
        actions.scrollToElement(element).build().perform();
    }



}
