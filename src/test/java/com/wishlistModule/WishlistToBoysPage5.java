package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class WishlistToBoysPage5 {
    WebDriver driver;

    @Test
    public void BoysPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.riverisland.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[name='accept-all']")).click();
        driver.findElement(By.cssSelector("[title='My account']")).click();
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("qatester1177@gmail.com");
        driver.findElement(By.cssSelector("[data-testid='email-login-button']")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys("Test@1234");
        Thread.sleep(10000);
        driver.findElement(By.xpath(" //button[@type='submit']")).click();

        WebElement boysTitle = driver.findElement(By.xpath("//span[normalize-space()='boys']"));
        Actions act = new Actions(driver);
        act.moveToElement(boysTitle).build().perform();

        driver.findElement(By.xpath("//li[@id='boys-miniboys0-5years']//a[contains(text(),'Coats & Jackets')]")).click();
        WebElement boysProduct = driver.findElement(By.xpath("//h5[normalize-space()='Mini boys navy bomber jacket']"));

        act.scrollToElement(boysProduct).build().perform();
        boysProduct.click();

        WebElement actualProductElement = driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/h1"));
        String actualProductName = actualProductElement.getText();

        WebElement boysWishlistBtn = driver.findElement(By.xpath("//button[@aria-label='Add to Wishlist']"));

        act.scrollToElement(boysWishlistBtn).build().perform();
        boysWishlistBtn.click();

        driver.findElement(By.cssSelector("[title='Wishlist']")).click();

        WebElement expectedProductElement = driver.findElement(By.xpath("//h1[contains(text(),'Your wishlist')]/parent::div/following-sibling::div/following-sibling::ul/li/form/following-sibling::form/div/following-sibling::div/following-sibling::div/div/div/p"));
        expectedProductElement.getText();
        String expectedProductName = expectedProductElement.getText();
        System.out.println("Before Product Name" + actualProductName);
        System.out.println("After Product Name" + expectedProductName);

        Assert.assertEquals(actualProductName, expectedProductName);

        driver.quit();
    }

}
