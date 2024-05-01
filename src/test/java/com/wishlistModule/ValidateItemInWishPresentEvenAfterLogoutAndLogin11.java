package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateItemInWishPresentEvenAfterLogoutAndLogin11 {

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


        WebElement womenProduct= driver.findElement(By.xpath("//div[@data-qa='product-listing']/a"));

        act.scrollToElement(womenProduct).build().perform();
        womenProduct.click();

        WebElement actualProductElement= driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/h1"));
        String actualProductName=actualProductElement.getText();

        WebElement actualPriceElement = driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/div/p/span"));
        String actualPrice=actualPriceElement.getText();

        WebElement womenWishlistBtn= driver.findElement(By.xpath("//span[text()='Add to bag']/parent::span/parent::button/parent::div/following-sibling::button/*[name()='svg']"));

        act.scrollToElement(womenWishlistBtn).build().perform();
        womenWishlistBtn.click();

        driver.findElement(By.xpath(" //span[normalize-space()='Wishlist']")).click();

        driver.findElement(By.cssSelector("[title='My account']")).click();

        driver.findElement(By.xpath("//nav[@data-qa='menu']/following-sibling::div/following-sibling::div/div/button[text()='Sign out']")).click();


        /**********Re-Login*******************/


        driver.findElement(By.cssSelector("[title='My account']")).click();
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("qatester1177@gmail.com");
        driver.findElement(By.cssSelector("[data-testid='email-login-button']")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys("Test@1234");
        Thread.sleep(25000);
        driver.findElement(By.xpath(" //button[@type='submit']")).click();

        driver.findElement(By.cssSelector("[title='My account']")).click();

        driver.findElement(By.cssSelector("[title='Wishlist']")).click();
        String expectedTitle="Your Wishlist - River Island";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);


        WebElement expectedProductElement=driver.findElement(By.xpath("//h1[contains(text(),'Your wishlist')]/parent::div/following-sibling::div/following-sibling::ul/li/form/following-sibling::form/div/following-sibling::div/following-sibling::div/div/div/p"));
        expectedProductElement.getText();
        String expectedProductName=expectedProductElement.getText();

        WebElement expectedPriceElement = driver.findElement(By.xpath("//h1[contains(text(),'Your wishlist')]/parent::div/following-sibling::div/following-sibling::ul/li/form/following-sibling::form/div/following-sibling::div/following-sibling::div/div/following-sibling::div/div/span"));
        String expectedPrice = expectedPriceElement.getText();


        System.out.println("Before Product Name" + actualProductName);
        System.out.println("After Product Name" + expectedProductName);
        System.out.println("Before Product Name" + actualPrice);
        System.out.println("After Product Name" + expectedPrice);
        Assert.assertEquals(actualProductName,expectedProductName);
        Assert.assertEquals(actualPrice,expectedPrice);
    }

}
