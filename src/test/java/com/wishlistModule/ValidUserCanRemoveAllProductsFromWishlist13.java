package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidUserCanRemoveAllProductsFromWishlist13 {


    WebDriver driver;
@Test
    public void validUserCanRemoveAllProductsFromWishlist13() throws InterruptedException {


        driver = new ChromeDriver();

        driver.get("https://www.riverisland.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("[name='accept-all']")).click();
        driver.findElement(By.cssSelector("[title='My account']")).click();
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("qatester1177@gmail.com");
        driver.findElement(By.cssSelector("[data-testid='email-login-button']")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys("Test@1234");
        Thread.sleep(20000);
        driver.findElement(By.xpath(" //button[@type='submit']")).click();

         WebElement wishlistBtn = driver.findElement(By.cssSelector("[title='Wishlist']"));
         wishlistBtn.click();

        driver.findElement(By.xpath("//button[@name='DeleteAllItemsFromWishlist']")).click();

    WebElement noItemInWishlistText =driver.findElement(By.xpath("//div[@data-page-id='wishlist']/div/div/h1/following-sibling::h2"));
    String actualText=noItemInWishlistText.getText();
    String expectedText="You currently have no item(s) in your wishlist.";
    Assert.assertEquals(actualText,expectedText);
         driver.quit();

    }

}
