package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistToBoysPage4 {
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

        WebElement boysTitle = driver.findElement(By.xpath("//span[normalize-space()='boys']"));
        Actions act = new Actions(driver);
        act.moveToElement(boysTitle).build().perform();

        driver.findElement(By.xpath("//li[@id='boys-miniboys0-5years']//a[contains(text(),'Coats & Jackets')]")).click();
        //  WebElement productsW=driver.findElement(By.cssSelector("[data-qa='topBar']"));
        // act.scrollToElement(productsW).build().perform();


        WebElement boysProduct = driver.findElement(By.xpath("//h5[normalize-space()='Mini boys navy bomber jacket']"));

        act.scrollToElement(boysProduct).build().perform();
        boysProduct.click();

        // driver.findElement(By.xpath("//div[@class='attributes']/h5[text()='Brown beaded shoulder bag']/preceding-sibling::button")).click();

        WebElement boysWishlistBtn = driver.findElement(By.xpath("//button[@aria-label='Add to Wishlist']"));

        act.scrollToElement(boysWishlistBtn).build().perform();
        boysWishlistBtn.click();

        driver.findElement(By.xpath(" //span[normalize-space()='Wishlist']")).click();
    }

}
