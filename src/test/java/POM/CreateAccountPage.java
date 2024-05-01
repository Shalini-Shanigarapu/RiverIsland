package POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

public class CreateAccountPage {
    private WebDriver driver;
    public CreateAccountPage(WebDriver driver){
        this.driver=driver;
    }
    public static String titleDD = "title";
    public static String getFname = "#firstName";
    public static String getLname = "lastName";
    public static String getpassword = "password";
    public static String getdate = "dayOfBirth";
    public static String getMonth = "monthOfBirth";
    public static String getYear = "yearOfBirth";
    public static String creteBtn = "[data-testid='account-signup-button']";
    public static String homePagetxt = "//span[text()='Account overview']";
    public static String creteAccpage= "//h1[text()='CREATE AN ACCOUNT']";
    public static String passwordErrmsg = "//div[@data-testid='password-container']//following-sibling::div[@data-testid='input-error-password']";

    public void selectTitle() {
        WebElement title = driver.findElement(By.id(titleDD));
        ;
        Select sel = new Select(title);
        sel.selectByVisibleText("Miss.");

    }

    public void setFnameLname() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        WebElement fN = driver.findElement(By.cssSelector(getFname));
        fN.sendKeys(firstName);



        driver.findElement(By.id(getLname)).sendKeys(lastName);


    }

    public void enterPassword() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String splCharacters = "<>~!@#$%^&*)=_+-}]{[/?.,(";
        String combination = upper + lower + numbers + splCharacters;
        int length = 10;
        char[] password = new char[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            password[i] = combination.charAt(random.nextInt(combination.length()));
        }
        System.out.println("Random Generated Password: " + new String(password));
        WebElement RandomPassword = driver.findElement(By.id(getpassword));
        RandomPassword.sendKeys(new String(password));
        System.out.println(new String(password));



    }
    public void enterweakPassword() {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String splCharacters = "<>~!@#$%^&*)=_+-}]{[/?.,(";
        String combination = upper + lower + numbers + splCharacters;
        int length = 5;
        char[] password = new char[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            password[i] = combination.charAt(random.nextInt(combination.length()));
        }
        System.out.println("Random Generated Password: " + new String(password));
        WebElement RandomPassword = driver.findElement(By.id(getpassword));
        RandomPassword.sendKeys(new String(password));


    }

    public void enterDOB() {
        WebElement date = driver.findElement(By.id(getdate));
        Select sel1 = new Select(date);
        sel1.selectByValue("4");

        WebElement month = driver.findElement(By.id(getMonth));
        Select sel2 = new Select(month);
        sel2.selectByValue("08");
        WebElement year = driver.findElement(By.id(getYear));
        Select sel3 = new Select(year);
        sel3.selectByValue("2005");
    }

    public void clickCreatebtn() {

        driver.findElement(By.cssSelector(creteBtn)).click();
    }


    public void VerifyHomepage() {
        driver.findElement(By.xpath(homePagetxt)).isDisplayed();

    }
    public void verifyCreateAccountPage(){
        boolean isCreateAccountPageDispalyed=driver.findElement(By.xpath(creteAccpage)).isDisplayed();
        if(isCreateAccountPageDispalyed){
            System.out.println("Successfully navigated to the Create an Account page");

        }else {
            System.out.println("Filed to navigate to the Create an Account page");
        }
    }
    public void verifyPasswordErrorMsg(){

        WebElement errormsg = driver.findElement(By.xpath(passwordErrmsg));
        String actualErrorMsg = errormsg.getText();
        String exceptedErrorMsg ="For extra security your password must fit criteria";
        Assert.assertEquals(actualErrorMsg,exceptedErrorMsg,"Error message misMatch");


    }



}

