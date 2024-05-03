package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistToMenPage3 {
        WebDriver driver;

        @Test
        public void menPage () throws InterruptedException {
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

            WebElement menTitle = driver.findElement(By.xpath("//span[text()='men']"));
            Actions act = new Actions(driver);
            act.moveToElement(menTitle).build().perform();

            driver.findElement(By.xpath("//ul[@class='mega-menu__column mega-menu__column-multi-layer mega-menu__column-desktop only mega-menu--desktop-only']//a[@data-menu-hierarchy='Men: Accessories: Hats'][normalize-space()='Hats']")).click();
            WebElement menProduct = driver.findElement(By.xpath("//h5[normalize-space()='Blue suedette cap']"));

            act.scrollToElement(menProduct).build().perform();
            menProduct.click();

            WebElement actualProductElement = driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/h1"));
            String actualProductName = actualProductElement.getText();


            WebElement menWishlistBtn = driver.findElement(By.xpath("//span[text()='Add to bag']/parent::span/parent::button/parent::div/following-sibling::button/*[name()='svg']"));

            act.scrollToElement(menWishlistBtn).build().perform();
            menWishlistBtn.click();

            WebElement wishlistPageBtn = driver.findElement(By.cssSelector("[title='Wishlist']"));
            wishlistPageBtn.click();


            WebElement expectedProductElement = driver.findElement(By.xpath("//h1[contains(text(),'Your wishlist')]/parent::div/following-sibling::div/following-sibling::ul/li/form/following-sibling::form/div/following-sibling::div/following-sibling::div/div/div/p"));
            expectedProductElement.getText();
            String expectedProductName = expectedProductElement.getText();
            System.out.println("Before Product Name" + actualProductName);
            System.out.println("After Product Name" + expectedProductName);

            Assert.assertEquals(actualProductName, expectedProductName);

            driver.quit();
        }
}
