package org.examples.tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class NavigateMethods {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://google.com");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().to("https://gmail.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


    }
}
