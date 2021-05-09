package org.examples.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchToMethods {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Alert message is: " + alertMessage);
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Hello Testers");
        driver.switchTo().alert().accept();


    }
}
