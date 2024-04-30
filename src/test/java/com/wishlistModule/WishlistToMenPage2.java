package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistToMenPage2 {
        WebDriver driver;

        @Test
        public void menPage () throws InterruptedException {
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

            WebElement menTitle = driver.findElement(By.xpath("//span[text()='men']"));
            Actions act = new Actions(driver);
            act.moveToElement(menTitle).build().perform();

            driver.findElement(By.xpath("//ul[@class='mega-menu__column mega-menu__column-multi-layer mega-menu__column-desktop only mega-menu--desktop-only']//a[@data-menu-hierarchy='Men: Accessories: Hats'][normalize-space()='Hats']")).click();
            //  WebElement productsW=driver.findElement(By.cssSelector("[data-qa='topBar']"));
            // act.scrollToElement(productsW).build().perform();

            ////h5[normalize-space()='Blue suedette cap']
            WebElement menProduct = driver.findElement(By.xpath("//h5[normalize-space()='Blue suedette cap']"));

            act.scrollToElement(menProduct).build().perform();
            menProduct.click();

            // driver.findElement(By.xpath("//div[@class='attributes']/h5[text()='Brown beaded shoulder bag']/preceding-sibling::button")).click();

            WebElement menWishlistBtn = driver.findElement(By.xpath("//button[@aria-label='Add to Wishlist']"));

            act.scrollToElement(menWishlistBtn).build().perform();
            menWishlistBtn.click();

            driver.findElement(By.xpath(" //span[normalize-space()='Wishlist']")).click();

        }
}
