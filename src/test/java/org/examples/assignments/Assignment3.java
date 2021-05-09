package org.examples.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        driver.manage().window().maximize();
        String id_FirstName = "input-firstname";
        String id_LastName = "input-lastname";
        String id_Email = "input-email";
        String id_Telephone = "input-telephone";
        String id_Password = "input-password";
        String id_ConfirmPwd = "input-confirm";
        String xpath_Newsletter = "(//input[@name='newsletter'])[1]";
        String name_Agree = "agree";
        String xpath_Continue = "//input[@value='Continue']";
        String xpath_Text = "//div[@id='content']//p";

        driver.findElement(By.id(id_FirstName)).sendKeys("Jack");
        driver.findElement(By.id(id_LastName)).sendKeys("Williams");
        driver.findElement(By.id(id_Email)).sendKeys("jack.williams2@test.com");
        driver.findElement(By.id(id_Telephone)).sendKeys("0987654321");
        driver.findElement(By.id(id_Password)).sendKeys("test123");
        driver.findElement(By.id(id_ConfirmPwd)).sendKeys("test123");

        driver.findElement(By.xpath(xpath_Newsletter)).click();
        driver.findElement(By.name(name_Agree)).click();
        driver.findElement(By.xpath(xpath_Continue)).click();

        String actualText = driver.findElement(By.xpath(xpath_Text)).getText();

        if(actualText.equals("Congratulations! Your new account has been successfully created!")){
            System.out.println("Expected Text matches with actual text");
        }
        else{
            System.out.println("Expected Text doesn't match with actual text");
        }

    }
}
