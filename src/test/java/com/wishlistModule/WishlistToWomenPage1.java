package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistToWomenPage1 {

    WebDriver driver;






    @Test
    public void womenPage () throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.riverisland.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[name='accept-all']")).click();
        driver.findElement(By.cssSelector("[title='My account']")).click();


        driver.findElement(By.cssSelector("[id='email']")).sendKeys("qatester1177@gmail.com");
        driver.findElement(By.cssSelector("[data-testid='email-login-button']")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys("Test@1234");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(10000);
        driver.findElement(By.xpath(" //button[@type='submit']")).click();

        WebElement womenTitle=driver.findElement(By.xpath("//span[text()='women']"));
        Actions act=new Actions(driver);
        act.moveToElement(womenTitle).build().perform();
        driver.findElement(By.linkText("Bags, Purses & Luggage")).click();
        //  WebElement productsW=driver.findElement(By.cssSelector("[data-qa='topBar']"));
        // act.scrollToElement(productsW).build().perform();


        WebElement womenProduct= driver.findElement(By.xpath("//div[@class='attributes']/h5[text()='Brown beaded shoulder bag']"));

        act.scrollToElement(womenProduct).build().perform();
        womenProduct.click();

        // driver.findElement(By.xpath("//div[@class='attributes']/h5[text()='Brown beaded shoulder bag']/preceding-sibling::button")).click();

        WebElement womenWishlistBtn= driver.findElement(By.xpath("//button[@class='button__p9ABR wishlist-btn__o9UWA product-details__wishlist-button__T_K4C product-details__three_point_two__kVHfD']"));

        act.scrollToElement(womenWishlistBtn).build().perform();
        womenWishlistBtn.click();

        driver.findElement(By.xpath(" //span[normalize-space()='Wishlist']")).click();

        //  #header-wishlist-container
        //span[normalize-space()='Wishlist']
        //Wishlist button  //div[@class='attributes']/h5[text()='Brown beaded shoulder bag']/preceding-sibling::button
                /*

                //[class='button__p9ABR wishlist-btn__o9UWA product-details__wishlist-button__T_K4C product-details__three_point_two__kVHfD']
                  ////div[@class='attributes']//child::h5[text()='Brown beaded shoulder bag']
                 */


    }
}
