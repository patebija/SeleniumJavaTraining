package org.examples.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathSelectorContainsMethod {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("(//a[contains(@href,'contact')])[1]")).click();

        if(driver.findElement(By.xpath("//textarea[@id='input-enquiry']")).isDisplayed()){
            System.out.println("Contact Us Page is displayed");
        }
        else{
            System.out.println("Contact Us Page is not displayed");
        }
    }
}
