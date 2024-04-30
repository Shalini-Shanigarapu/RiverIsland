package com.Createaccount.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class HomePage {
    private WebDriver driver;
    private By acceptall=By.name("accept-all");
    private  By account=By.xpath("//a[@title='My account']");
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void clickAccept(){
        driver.findElement(acceptall).click();
    }
    public void clickAccount(){

        driver.findElement(account).click();
    }


}
