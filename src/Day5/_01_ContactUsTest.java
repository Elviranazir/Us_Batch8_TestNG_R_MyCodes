package Day5;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_ContactUsTest extends BaseDriver{
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * login
     * click on Contact Us
     * send a message from xml file
     * check if the url has "success" key word
     * */
    @Test
    @Parameters("message")
    public void contactUsTest1(String message1){
        login();
        WebElement contactUs = driver.findElement(By.xpath("//a[.='Contact Us']"));
        contactUs.click();
        WebElement contactUsMessage = driver.findElement(By.id("input-enquiry"));
        contactUsMessage.sendKeys(message1);

        WebElement submit = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        submit.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }

    @Test
    @Parameters({"message","username","password"})
    public void contactUsTest2(String message1, String username, String password){
        login(username, password);
        WebElement contactUs = driver.findElement(By.xpath("//a[.='Contact Us']"));
        contactUs.click();
        WebElement contactUsMessage = driver.findElement(By.id("input-enquiry"));
        contactUsMessage.sendKeys(message1);

        WebElement submit = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        submit.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }
}
