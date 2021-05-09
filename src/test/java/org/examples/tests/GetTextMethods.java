package org.examples.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextMethods {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String text = driver.findElement(By.xpath("//span[@class='title']")).getText();
        if(text.equals("PRODUCTS")){
            System.out.println("Text is matching");
        }
        else{
            System.out.println("Text is not matching");
        }
        String tag = driver.findElement(By.id("item_4_img_link")).getTagName();
        if(tag.equals("a")){
            System.out.println("Tag name is correct");
        }
        else{
            System.out.println("Tag name is incorrect");
        }
    }
}
