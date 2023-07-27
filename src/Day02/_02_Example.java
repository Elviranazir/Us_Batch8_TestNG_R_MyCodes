package Day02;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Example extends BaseDriver {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login" page
     * login
     * email:  testngusbatch@gmail.com
     * password: usbatch1234
     * verify that you see My Account
     * */

    @Test
    void loginTest(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("testngusbatch@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("usbatch1234");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        WebElement myAccountText = driver.findElement(By.xpath("//h2[.='My Account']"));

        Assert.assertTrue(myAccountText.isDisplayed());
        Assert.assertEquals(myAccountText.getText(),"My Account");
    }

}