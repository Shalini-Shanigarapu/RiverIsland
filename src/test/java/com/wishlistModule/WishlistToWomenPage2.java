package com.wishlistModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
public class WishlistToWomenPage2 {
    WebDriver driver;
    @Test
    public void womenPage () throws InterruptedException {
        driver = new EdgeDriver();
        driver.get("https://www.riverisland.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //driver.findElement(By.cssSelector("[name='accept-all']")).click();
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

        WebElement womenProduct= driver.findElement(By.xpath("//h5[text()='Brown raffia circle handle tote bag']"));

        act.scrollToElement(womenProduct).build().perform();
        womenProduct.click();


        WebElement actualProductElement= driver.findElement(By.xpath("//ol[@data-cs-override-id='breadcrumbs']/following-sibling::div/h1"));
        actualProductElement.getText();



        WebElement womenWishlistBtn= driver.findElement(By.cssSelector("[data-qa='wishlist-btn']"));

        act.scrollToElement(womenWishlistBtn).build().perform();
        womenWishlistBtn.click();


        driver.findElement(By.xpath(" //span[normalize-space()='Wishlist']")).click();

        String expectedTitle="Your Wishlist - River Island";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement expectedProductElement=driver.findElement(By.xpath("//h1[contains(text(),'Your wishlist')]/parent::div/following-sibling::div/following-sibling::ul/li/form/following-sibling::form/div/following-sibling::div/following-sibling::div/div/div/p"));
        expectedProductElement.getText();
        String actualProductName=actualProductElement.getText();
        String expectedProductName=expectedProductElement.getText();
        System.out.println("Before Product Name" + actualProductName);
        System.out.println("After Product Name" + expectedProductName);

        Assert.assertEquals(actualProductName,expectedProductName);


       // driver.quit();



    }
}
