package CartModule.pages;

import commonmethods.ActionsClass;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class AddingProductFromPagesToCart {



    WebDriver driver;
    ActionsClass actionsClass;
    Cart cart;

    JavascriptExecutor jse;



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

    WebElement exceptedPageTextEle;
    WebElement productNameInWomen ;
    WebElement productNameInMen;
    WebElement productNameInGirls;
    WebElement productNameInBoys;
    WebElement productNameInHolidayShop;
    WebElement productNameInJeans;


    boolean flag;
    String verifyProduct;







    public void addProductFromWomen(String size) throws IOException, ParseException, InterruptedException
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

        productEle = driver.findElement(By.xpath("//div[@data-qa='topBar']/following-sibling::div/div/following-sibling::div/a"));
        productEle.click();


        productNameInWomen = driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/h1"));
        System.out.println(productNameInWomen.getText());
        String productNameInStr = productNameInWomen.getText();

        sizeEle= driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/following-sibling::div/following-sibling::ul/li/div[text()='"+size+"']"));
        sizeEle.click();

        addToCart = driver.findElement(By.xpath("//div[@id='add-to-bag--observer']/button[@aria-label='Add to bag']"));
        addToCart.click();

        viewBagEle = driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();



        List<WebElement>cartItems= driver.findElements(By.xpath("//div[@data-qa='cart-header']/following-sibling::div/div"));
       flag = false;
        for (WebElement item : cartItems) {
            if (item.getText().contains(productNameInStr))
            {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);

    }

    public void signIn() throws IOException, ParseException, InterruptedException {

        jse = (JavascriptExecutor)driver;

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
        Thread.sleep(10000);

        signInBtnEle = driver.findElement(By.xpath("//button[text()='Sign in']"));
        jse.executeScript("arguments[0].click();",signInBtnEle);
//        signInBtnEle.click();

    }




    public void withoutSignIn() throws IOException, ParseException, InterruptedException {

        jse = (JavascriptExecutor)driver;


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
        Thread.sleep(10000);

        signInBtnEle = driver.findElement(By.xpath("//button[text()='Sign in']"));
        jse.executeScript("arguments[0].click();",signInBtnEle);
//        signInBtnEle.click();

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






    public void addProductFromMen(String size) throws InterruptedException, IOException, ParseException
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

        productNameInMen = driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/h1"));
        System.out.println(productNameInMen.getText());
        String productNameInStr = productNameInMen.getText();

        sizeEle= driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/following-sibling::ul/li/following-sibling::li/div[text()='"+size+"']"));
        sizeEle.click();

        addToCart = driver.findElement(By.xpath("//div[@id='add-to-bag--observer']/button[@aria-label='Add to bag']"));
        addToCart.click();

        viewBagEle = driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();


        List<WebElement>cartItems= driver.findElements(By.xpath("//div[@data-qa='cart-header']/following-sibling::div/div"));
        flag = false;
        for (WebElement item : cartItems) {
            if (item.getText().contains(productNameInStr))
            {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);



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
        Thread.sleep(5000);
        allGirlsWearEle.click();

        productsTopBar = driver.findElement(By.cssSelector("[data-qa='topBar']"));
        actionsClass.scrollToElement(productsTopBar);


        productEle = driver.findElement(By.xpath("//div[@data-qa='topBar']/following-sibling::div/div/following-sibling::div/a"));
        productEle.click();

        productNameInGirls = driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/h1"));
        System.out.println(productNameInGirls.getText());
        String productNameInStr = productNameInGirls.getText();

        selectSizeEle= driver.findElement(By.xpath("//div[@data-cs-override-id='size-selector']/button"));
        selectSizeEle.click();


        addToCartMethod("12-18 Mths (UK)");

        List<WebElement>cartItems= driver.findElements(By.xpath("//div[@data-qa='cart-header']/following-sibling::div/div"));
        flag = false;
        for (WebElement item : cartItems) {
            if (item.getText().contains(productNameInStr))
            {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);

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

        productNameInBoys = driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/h1"));
        System.out.println(productNameInBoys.getText());
        String productNameInStr = productNameInBoys.getText();


        selectSizeEle= driver.findElement(By.xpath("//div[@data-cs-override-id='size-selector']/button"));
        selectSizeEle.click();

        addToCartMethod("3-6 Mths (UK)");

        List<WebElement>cartItems= driver.findElements(By.xpath("//div[@data-qa='cart-header']/following-sibling::div/div"));
        flag = false;
        for (WebElement item : cartItems) {
            if (item.getText().contains(productNameInStr))
            {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);

    }

    public void addProductFromHolidayShop(String subCategory , String size) throws IOException, ParseException, InterruptedException
    {
        actionsClass = new ActionsClass(driver);
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();


        signIn();

        holidayShopEle = driver.findElement(By.cssSelector("[data-menu-hierarchy='Holiday shop']"));
        holidayShopEle.click();

        WebElement element = driver.findElement(By.linkText(subCategory));
        element.click();

        System.out.println(driver.getTitle());
        String exceptedPageTitle = "Men's Holiday Shop | River Island";
        Assert.assertEquals(exceptedPageTitle,driver.getTitle());

        productsTopBar = driver.findElement(By.cssSelector("[data-qa='topBar']"));
        actionsClass.scrollToElement(productsTopBar);

        productEle = driver.findElement(By.xpath("//div[@data-qa='topBar']/following-sibling::div/div/following-sibling::div/a"));
        productEle.click();

        productNameInHolidayShop = driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/h1"));
        System.out.println(productNameInHolidayShop.getText());
        String productNameInStr = productNameInHolidayShop.getText();

        sizeEle= driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/following-sibling::div/following-sibling::ul/li/div[text()='"+size+"']"));
        sizeEle.click();

        addToCart = driver.findElement(By.xpath("//div[@id='add-to-bag--observer']/button[@aria-label='Add to bag']"));
        addToCart.click();

        viewBagEle = driver.findElement(By.cssSelector("[title='VIEW BAG']"));
        viewBagEle.click();

        List<WebElement>cartItems= driver.findElements(By.xpath("//div[@data-qa='cart-header']/following-sibling::div/div"));
        flag = false;
        for (WebElement item : cartItems) {
            if (item.getText().contains(productNameInStr))
            {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);

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

        productNameInJeans = driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/h1"));
        System.out.println(productNameInJeans.getText());
        String productNameInStr = productNameInJeans.getText();

        selectSizeEle= driver.findElement(By.xpath("//div[@data-cs-override-id='size-selector']/button"));
        selectSizeEle.click();

        addToCartMethod("32 short (UK)");

        List<WebElement>cartItems= driver.findElements(By.xpath("//div[@data-qa='cart-header']/following-sibling::div/div"));
        flag = false;
        for (WebElement item : cartItems) {
            if (item.getText().contains(productNameInStr))
            {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);


    }


    public void     addProductFromGirlsWithoutSignIn() throws InterruptedException, IOException, ParseException
    {
        actionsClass = new ActionsClass(driver);
        acceptAll = driver.findElement(By.cssSelector("[name='accept-all']"));
        acceptAll.click();



        girlsEle = driver.findElement(By.xpath("//span[text()='girls']"));
        girlsEle.click();

        popularCategoriesEle = driver.findElement(By.xpath("//h2[text()='Popular Categories']"));
        actionsClass.scrollToElement(popularCategoriesEle);

        allGirlsWearEle = driver.findElement(By.cssSelector("[data-promo-name='All Girlswear']"));
        actionsClass.scrollToElement(allGirlsWearEle);
        Thread.sleep(5000);
        allGirlsWearEle.click();

        productsTopBar = driver.findElement(By.cssSelector("[data-qa='topBar']"));
        actionsClass.scrollToElement(productsTopBar);


        productEle = driver.findElement(By.xpath("//div[@data-qa='topBar']/following-sibling::div/div/following-sibling::div/a"));
        productEle.click();

        selectSizeEle= driver.findElement(By.xpath("//div[@data-cs-override-id='size-selector']/button"));
        selectSizeEle.click();


        addToCartMethod("12-18 Mths (UK)");

        checkoutEle = driver.findElement(By.xpath("//div[@data-qa='totals']/../following-sibling::div/button"));
        checkoutEle.click();

        exceptedPageTextEle =driver.findElement(By.xpath("//div[@id='login']/div/div/div/div/h1"));
        System.out.println(exceptedPageTextEle.getText());
        String exceptedPageText = "CHECKOUT";
        Assert.assertEquals(exceptedPageText,exceptedPageTextEle.getText());

        withoutSignIn();

        WebElement deliveryEle = driver.findElement(By.xpath("//div[@data-qa='content']/div/section/header"));
        deliveryEle.getText();

        String exceptedTitle ="Please select where you would like your items delivered";
        Assert.assertEquals(exceptedTitle,deliveryEle.getText());

    }





}
