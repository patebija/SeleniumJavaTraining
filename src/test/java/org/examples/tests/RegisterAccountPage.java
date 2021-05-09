package org.examples.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegisterAccountPage {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        driver.findElement(By.id("input-firstname")).sendKeys("John");
        driver.findElement(By.id("input-lastname")).sendKeys("Smith");
        driver.findElement(By.id("input-email")).sendKeys("john.smith@test.com");
        driver.findElement(By.id("input-telephone")).sendKeys("111-222-3333");
        driver.findElement(By.name("password")).sendKeys("test@123");
        driver.findElement(By.name("confirm")).sendKeys("test@123");
        driver.findElement(By.linkText("login page")).click();
        if(driver.findElement(By.linkText("Login")).isDisplayed()){
            System.out.println("Login link is displayed");
        }
        else{
            System.out.println("Login link is not displayed");
        }
        driver.navigate().back();
        driver.findElement(By.partialLinkText("login")).click();
        if(driver.findElement(By.partialLinkText("Log")).isDisplayed()){
            System.out.println("Login link is displayed");
        }
        else{
            System.out.println("Login link is not displayed");
        }
        driver.navigate().back();
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for(WebElement button: buttons){
            System.out.println(button.getText());
        }
    }
}
