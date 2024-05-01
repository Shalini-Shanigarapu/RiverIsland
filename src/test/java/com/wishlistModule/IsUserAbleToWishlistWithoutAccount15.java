package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class IsUserAbleToWishlistWithoutAccount15 {

    WebDriver driver;

    @Test
    public void isUserAbleToWishlistWithoutAccount15() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.riverisland.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("[name='accept-all']")).click();
        WebElement womenTitle=driver.findElement(By.xpath("//span[text()='women']"));
        Actions act=new Actions(driver);
        act.moveToElement(womenTitle).build().perform();
        driver.findElement(By.linkText("Bags, Purses & Luggage")).click();

        WebElement womenProduct= driver.findElement(By.xpath("//h5[normalize-space()='Brown beaded shoulder bag']"));

        act.scrollToElement(womenProduct).build().perform();
        womenProduct.click();

        WebElement womenWishlistBtn= driver.findElement(By.xpath("//button[@class='button__p9ABR wishlist-btn__o9UWA product-details__wishlist-button__T_K4C product-details__three_point_two__kVHfD']"));

        act.scrollToElement(womenWishlistBtn).build().perform();
        womenWishlistBtn.click();

        driver.findElement(By.xpath(" //span[normalize-space()='Wishlist']")).click();

        driver.quit();
    }

    }
