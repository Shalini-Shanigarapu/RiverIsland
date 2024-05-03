package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidatedUserCanAccessThroughMyAccount10 {

    WebDriver driver;

    @Test
    public void itemAddedPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.riverisland.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("[name='accept-all']")).click();
        driver.findElement(By.cssSelector("[title='My account']")).click();

        driver.findElement(By.cssSelector("[id='email']")).sendKeys("qatester1177@gmail.com");
        driver.findElement(By.cssSelector("[data-testid='email-login-button']")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys("Test@1234");
        Thread.sleep(20000);
        driver.findElement(By.xpath(" //button[@type='submit']")).click();

        driver.findElement(By.cssSelector("[title='My account']")).click();

        driver.findElement(By.cssSelector("[title='Wishlist']")).click();

        WebElement expectedProductElement=driver.findElement(By.xpath("//h1[contains(text(),'Your wishlist')]/parent::div/following-sibling::div/following-sibling::ul/li/form/following-sibling::form/div/following-sibling::div/following-sibling::div/div/div/p"));
        expectedProductElement.getText();
        String expectedProductName=expectedProductElement.getText();
        System.out.println(expectedProductName);

        Assert.assertEquals(true,expectedProductElement.isDisplayed());

    }
}
