package CartModule.pages;

import commonmethods.ActionsClass;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.io.FileReader;
import java.io.IOException;

public class AddingProductFromPagesToCart {



    WebDriver driver;
    ActionsClass actionsClass;
    Cart cart;




    public AddingProductFromPagesToCart(WebDriver pagedriver)
    {
        this.driver = pagedriver;
        actionsClass = new ActionsClass(driver);
        cart = new Cart( driver);
    }



    WebElement acceptAll;
    WebElement accountEle;

    WebElement emailEle;
    WebElement continueBtnEle;
    WebElement passwordEle;

    WebElement signInBtnEle;

    WebElement womenEle;
    WebElement popularCategoriesEle;

    WebElement topEle;

    WebElement productsTopBar;

    WebElement productEle;

    WebElement sizeEle;

    WebElement addToCart;

   WebElement viewBagEle;

    WebElement checkoutEle;

    WebElement menEle;

    WebElement shirtEle;

    WebElement girlsEle;

    WebElement allGirlsWearEle;

    WebElement selectSizeEle;

    WebElement boysEle;

    WebElement allBoysWearEle;


    WebElement holidayShopEle;

    WebElement jeansEle;

    WebElement holidayShopWomenEle;

    WebElement holidayShopMensEle;

    WebElement holidayShopGirlsEle;

    WebElement holidayShopBoysEle;






    public void addProductFromWomen() throws IOException, ParseException, InterruptedException
    {
        actionsClass = new ActionsClass(driver);
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        signIn();

        womenEle = driver.findElement(By.xpath("//span[text()='women']"));
        womenEle.click();

        popularCategoriesEle = driver.findElement(By.xpath("//h2[text()='Popular Categories']"));
        actionsClass.scrollToElement(popularCategoriesEle);

        topEle = driver.findElement(By.cssSelector("[data-promo-name='Tops']"));
        actionsClass.scrollToElement(topEle);
        topEle.click();

        productsTopBar = driver.findElement(By.cssSelector("[data-qa='topBar']"));
        actionsClass.scrollToElement(productsTopBar);

        //h5[text()='Green crochet panel oversized shirt']/preceding-sibling::button/preceding-sibling::div/../..

        productEle = driver.findElement(By.xpath("//div[@data-qa='topBar']/following-sibling::div/div/following-sibling::div/a"));
        productEle.click();

        addToCartMethod("8");

    }

    public void signIn() throws IOException, ParseException, InterruptedException {
        accountEle = driver.findElement(By.linkText("Account"));
        accountEle.click();

        emailEle = driver.findElement(By.cssSelector("#email"));
        emailEle.click();

        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/test/TestData/ file.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject)obj;

        String email = jsonObject.get("Email").toString();
        String password = jsonObject.get("Password").toString();

        emailEle.sendKeys(email);
        continueBtnEle = driver.findElement(By.cssSelector("[type='submit']"));
        continueBtnEle.click();
        passwordEle = driver.findElement(By.cssSelector("#password"));
        passwordEle.click();
        passwordEle.sendKeys(password);
        Thread.sleep(20000);

        signInBtnEle = driver.findElement(By.cssSelector("[type='submit']"));
        signInBtnEle.click();

    }




    public void addToCartMethod(String size)
    {
        sizeEle= driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/following-sibling::div/div/ul/li/span[text()='"+size+"']"));
        sizeEle.click();

        addToCart = driver.findElement(By.xpath("//div[@id='add-to-bag--observer']/button[@aria-label='Add to bag']"));
        addToCart.click();

        viewBagEle = driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();


    }






    public void addProductFromMen() throws InterruptedException, IOException, ParseException
    {
        actionsClass = new ActionsClass(driver);
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();


        signIn();

        menEle = driver.findElement(By.xpath("//span[text()='men']"));
        menEle.click();

        popularCategoriesEle = driver.findElement(By.xpath("//h2[text()='Popular Categories']"));
        actionsClass.scrollToElement(popularCategoriesEle);

        shirtEle = driver.findElement(By.cssSelector("[data-promo-name='Shirts']"));
        actionsClass.scrollToElement(shirtEle);
        Thread.sleep(2000);
        shirtEle.click();

        productsTopBar = driver.findElement(By.cssSelector("[data-qa='topBar']"));
        actionsClass.scrollToElement(productsTopBar);


        productEle = driver.findElement(By.xpath("//div[@data-qa='topBar']/following-sibling::div/div/following-sibling::div/a"));
        productEle.click();

        addToCartMethod("S");

    }



    public void addProductFromGirls() throws InterruptedException, IOException, ParseException
    {
        actionsClass = new ActionsClass(driver);
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        signIn();

        girlsEle = driver.findElement(By.xpath("//span[text()='girls']"));
        girlsEle.click();

        popularCategoriesEle = driver.findElement(By.xpath("//h2[text()='Popular Categories']"));
        actionsClass.scrollToElement(popularCategoriesEle);

        allGirlsWearEle = driver.findElement(By.cssSelector("[data-promo-name='All Girlswear']"));
        actionsClass.scrollToElement(allGirlsWearEle);
        Thread.sleep(10000);
        allGirlsWearEle.click();

        productsTopBar = driver.findElement(By.cssSelector("[data-qa='topBar']"));
        actionsClass.scrollToElement(productsTopBar);


        productEle = driver.findElement(By.xpath("//div[@data-qa='topBar']/following-sibling::div/div/following-sibling::div/a"));
        productEle.click();

        selectSizeEle= driver.findElement(By.xpath("//div[@data-cs-override-id='size-selector']/button"));
        selectSizeEle.click();


        addToCartMethod("5-6 Yrs (UK)");


    }



    public void addProductFromBoys() throws InterruptedException, IOException, ParseException
    {
        actionsClass = new ActionsClass(driver);
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();

        signIn();

        boysEle = driver.findElement(By.xpath("//span[text()='boys']"));
        boysEle.click();

        popularCategoriesEle = driver.findElement(By.xpath("//h2[text()='Popular Categories']"));
        actionsClass.scrollToElement(popularCategoriesEle);

        allBoysWearEle = driver.findElement(By.cssSelector("[data-promo-name='All Boyswear']"));
        actionsClass.scrollToElement(allBoysWearEle);
        Thread.sleep(2000);
        allBoysWearEle.click();

        productsTopBar = driver.findElement(By.cssSelector("[data-qa='topBar']"));
        actionsClass.scrollToElement(productsTopBar);


        productEle = driver.findElement(By.xpath("//div[@data-qa='topBar']/following-sibling::div/div/following-sibling::div/a"));
        productEle.click();

        selectSizeEle= driver.findElement(By.xpath("//div[@data-cs-override-id='size-selector']/button"));
        selectSizeEle.click();


        sizeEle= driver.findElement(By.xpath("//ul[@role='menu']/li/span[text()='3-6 Mths (UK)']"));
        sizeEle.click();

        addToCart = driver.findElement(By.xpath("//div[@id='add-to-bag--observer']/button[@aria-label='Add to bag']"));
        addToCart.click();

        viewBagEle = driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();

        checkoutEle = driver.findElement(By.xpath("//div[@data-qa='totals']/../following-sibling::div/button"));
        checkoutEle.click();


    }

    public void addProductFromHolidayShop(String subCategory) throws IOException, ParseException, InterruptedException
    {
        actionsClass = new ActionsClass(driver);
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();


        signIn();

        holidayShopEle = driver.findElement(By.linkText("holiday shop"));
        holidayShopEle.click();

        WebElement element = driver.findElement(By.linkText(subCategory));
        element.click();


        productsTopBar = driver.findElement(By.cssSelector("[data-qa='topBar']"));
        actionsClass.scrollToElement(productsTopBar);

        productEle = driver.findElement(By.xpath("//div[@data-qa='topBar']/following-sibling::div/div/following-sibling::div/a"));
        productEle.click();


        selectSizeEle= driver.findElement(By.xpath("//div[@data-cs-override-id='size-selector']/button"));
        selectSizeEle.click();

        addToCartMethod("8");

    }




    public void addProductFromJeans(String subCategory) throws IOException, ParseException, InterruptedException
    {
        actionsClass = new ActionsClass(driver);
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();


        signIn();

        jeansEle = driver.findElement(By.cssSelector("[data-menu-hierarchy='Jeans']"));
        jeansEle.click();

        WebElement element = driver.findElement(By.linkText(subCategory));
        element.click();

        productsTopBar = driver.findElement(By.cssSelector("[data-qa='topBar']"));
        actionsClass.scrollToElement(productsTopBar);

        productEle = driver.findElement(By.xpath("//div[@data-qa='topBar']/following-sibling::div/div/following-sibling::div/a"));
        productEle.click();

        selectSizeEle= driver.findElement(By.xpath("//div[@data-cs-override-id='size-selector']/button"));
        selectSizeEle.click();

        addToCartMethod("8");


    }



}
