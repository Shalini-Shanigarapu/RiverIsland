package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistToJeansPage6 {



    WebDriver driver;

    @Test
    public void menPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.riverisland.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[name='accept-all']")).click();
        driver.findElement(By.cssSelector("[title='My account']")).click();


        //   driver.findElement(By.xpath("//a[@href='/myaccount']//child::span[text()='Account']")).click();
        //  driver.findElement(By.xpath("//li[@id='header-my-account']")).click();

        driver.findElement(By.cssSelector("[id='email']")).sendKeys("qatester1177@gmail.com");
        driver.findElement(By.cssSelector("[data-testid='email-login-button']")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys("Test@1234");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(10000);


        driver.findElement(By.xpath(" //button[@type='submit']")).click();

        WebElement jeansTitle = driver.findElement(By.xpath("//span[normalize-space()='jeans']"));
        Actions act = new Actions(driver);
        act.moveToElement(jeansTitle).build().perform();

        driver.findElement(By.xpath("//a[@data-menu-hierarchy='Jeans: Girls: All Jeans']")).click();

        WebElement jeansGirlProduct = driver.findElement(By.xpath("//h5[normalize-space()='Girls blue wide leg jeans']"));

        act.scrollToElement(jeansGirlProduct).build().perform();
        jeansGirlProduct.click();


        WebElement jeanGirlWishlistBtn = driver.findElement(By.xpath("//button[@aria-label='Add to Wishlist']"));

        act.scrollToElement(jeanGirlWishlistBtn).build().perform();
        jeanGirlWishlistBtn.click();

        driver.findElement(By.xpath(" //span[normalize-space()='Wishlist']")).click();
    }


}
