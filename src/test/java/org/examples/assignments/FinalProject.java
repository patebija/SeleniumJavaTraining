package org.examples.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FinalProject {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.id("input-email")).sendKeys("patebij@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("test@123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebElement LaptopsMenu = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement AllLaptopsLink = driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(LaptopsMenu).click(AllLaptopsLink).build().perform();

        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]")).click();
        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[4]")).click();

        driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
        String product1Text = driver.findElement(By.xpath("(//a[contains(@href,'product_id=44')])[4]")).getText();
        String product2Text = driver.findElement(By.xpath("(//a[contains(@href,'product_id=45')])[4]")).getText();

        if(product1Text.equals("MacBook Air")){
            System.out.println("Product Name for MacBook Air is correct");
        }
        else{
            System.out.println("Product Name for MacBook Air is not correct");
        }
        if(product2Text.equals("MacBook Pro")){
            System.out.println("Product Name for MacBook Pro is correct");
        }
        else{
            System.out.println("Product Name for MacBook Pro is not correct");
        }

        if(driver.findElement(By.xpath("(//table[@class='table table-bordered'])[3]//tr[2]//td[2]")).getText().equals("$3,000.00")){
            System.out.println("Total amount of products is correct");
        }
        else{
            System.out.println("Total amount of products is not correct");
        }

        driver.findElement(By.xpath("//a[text()='Checkout']")).click();

        driver.findElement(By.xpath("(//input[@name='payment_address'])[2]")).click();

        driver.findElement(By.id("input-payment-firstname")).sendKeys("John");
        driver.findElement(By.id("input-payment-lastname")).sendKeys("Smith");
        driver.findElement(By.id("input-payment-address-1")).sendKeys("555");
        driver.findElement(By.id("input-payment-address-2")).sendKeys("10th Ave");
        driver.findElement(By.id("input-payment-city")).sendKeys("New York");
        driver.findElement(By.id("input-payment-postcode")).sendKeys("NY 10018");

        WebElement selectCountry = driver.findElement(By.id("input-payment-country"));
        Select country = new Select(selectCountry);
        country.selectByVisibleText("United States");

        WebElement selectState = driver.findElement(By.id("input-payment-zone"));
        Select state = new Select(selectState);
        state.selectByVisibleText("New York");

        driver.findElement(By.id("button-payment-address")).click();
        driver.findElement(By.id("button-shipping-address")).click();
        driver.findElement(By.id("button-shipping-method")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.id("button-payment-method")).click();

        driver.findElement(By.id("button-confirm")).click();

        WebElement successLink = driver.findElement(By.xpath("//a[contains(@href,'success')]"));
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(successLink));

        String message = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        if(message.equals("Your order has been placed!")){
            System.out.println("Order is confirmed");
        }
        else{
            System.out.println("Order is not confirmed");
        }

        driver.findElement(By.xpath("//a[text()='Continue']"));

        driver.quit();

    }
}
