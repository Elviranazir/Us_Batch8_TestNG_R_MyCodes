package Day02;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_SignUpTest extends BaseDriver {

    /** Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Click on My Account
     * Click on Register
     * Fill in the form with valid informations
     * Accept the agreement
     * Click on Continue button
     * Verify that you are signed up
     */

    @Test
    void signUpTest(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccount.click();

        WebElement register = driver.findElement(By.xpath("//a[.='Register']"));
        register.click();

        WebElement name = driver.findElement(By.id("input-firstname"));
        name.sendKeys("Michael");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Jordan");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("jordan3@gmail.com");

        WebElement phone = driver.findElement(By.id("input-telephone"));
        phone.sendKeys("5865214586");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Jordan12345");

        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
        confirmPassword.sendKeys("Jordan12345");

        WebElement agreement = driver.findElement(By.xpath("//input[@name='agree']"));
        agreement.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//*[@id='content']/p[1]"));

        //Assert.assertTrue(successMessage.getText().contains("successfully"),"Test failed");
        Assert.assertEquals(successMessage.getText(),"Congratulations! Your new account has been successfully created!");
    }

}