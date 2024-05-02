package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistToHolidayShop6 {



    WebDriver driver;

    @Test
    public void holidayPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.riverisland.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[name='accept-all']")).click();
        driver.findElement(By.cssSelector("[title='My account']")).click();

        driver.findElement(By.cssSelector("[id='email']")).sendKeys("qatester1177@gmail.com");
        driver.findElement(By.cssSelector("[data-testid='email-login-button']")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys("Test@1234");

        Thread.sleep(20000);


        driver.findElement(By.xpath(" //button[@type='submit']")).click();

        WebElement holiGirlsTitle = driver.findElement(By.xpath(" //span[normalize-space()='holiday shop']"));
        Actions act = new Actions(driver);
        act.moveToElement(holiGirlsTitle).build().perform();

        driver.findElement(By.xpath("//a[@data-menu-hierarchy='Holiday shop: Girls: Dresses & Playsuits']")).click();

        WebElement holiGirlProduct = driver.findElement(By.xpath("//h5[normalize-space()='Mini girls pink taped knit dress']"));

        act.scrollToElement(holiGirlProduct).build().perform();
        holiGirlProduct.click();

        WebElement holiGirlWishlistBtn = driver.findElement(By.xpath("//button[@aria-label='Add to Wishlist']"));

        act.scrollToElement(holiGirlWishlistBtn).build().perform();
        holiGirlWishlistBtn.click();

        driver.findElement(By.cssSelector("[title='Wishlist']")).click();
        String expectedTitle="Your Wishlist - River Island";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        driver.quit();
    }

}
