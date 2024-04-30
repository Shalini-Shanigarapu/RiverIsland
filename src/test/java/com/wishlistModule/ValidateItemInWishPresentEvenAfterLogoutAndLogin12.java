package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateItemInWishPresentEvenAfterLogoutAndLogin12 {

    WebDriver driver;
    @Test
    public void validateItemInWishPresentEvenAfterLogoutAndLogin12() throws InterruptedException {
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

        driver.findElement(By.cssSelector("[title='My account']")).click();

        WebElement womenTitle=driver.findElement(By.xpath("//span[text()='women']"));
        Actions act=new Actions(driver);
        act.moveToElement(womenTitle).build().perform();
        driver.findElement(By.linkText("Bags, Purses & Luggage")).click();


        WebElement womenProduct= driver.findElement(By.xpath("//div[@class='attributes']/h5[text()='Brown beaded shoulder bag']"));

        act.scrollToElement(womenProduct).build().perform();
        womenProduct.click();

        WebElement womenWishlistBtn= driver.findElement(By.xpath("//button[@class='button__p9ABR wishlist-btn__o9UWA product-details__wishlist-button__T_K4C product-details__three_point_two__kVHfD']"));

        act.scrollToElement(womenWishlistBtn).build().perform();
        womenWishlistBtn.click();

        driver.findElement(By.xpath(" //span[normalize-space()='Wishlist']")).click();

        driver.findElement(By.cssSelector("[title='My account']")).click();

        driver.findElement(By.xpath("//div[@class='App__sign-out-button-desktop___e7sKW']//button[@type='button'][normalize-space()='Sign out']")).click();


        /**********Re-Login*******************/


        driver.findElement(By.cssSelector("[title='My account']")).click();
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("qatester1177@gmail.com");
        driver.findElement(By.cssSelector("[data-testid='email-login-button']")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys("Test@1234");
        Thread.sleep(25000);
        driver.findElement(By.xpath(" //button[@type='submit']")).click();

        driver.findElement(By.cssSelector("[title='My account']")).click();

        driver.findElement(By.xpath(" //span[normalize-space()='Wishlist']")).click();

        String expectedTitle="Your Wishlist - River Island";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        driver.quit();




    }

}
