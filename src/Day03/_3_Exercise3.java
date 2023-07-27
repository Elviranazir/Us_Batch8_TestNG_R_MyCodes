package Day03;

import Utilities.BaseDriver;
import Utilities.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _3_Exercise3 extends BaseDriver {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login
     * Log in
     * Click on News Letter
     * Click on Yes
     * Click on Continue
     *
     * in a different test
     * Click on News Letter
     * Click on No
     * Click on Continue
     *
     *
     * in a different test
     * Click on News Letter
     * Make it Yes if it is No or make it No if it os Yes
     * **/
    @Test
    public void subscribeNewLetterText () {
       login();

       WebElement newsLetter= driver.findElement(By.xpath("//a[.='Newsletter']"));
       newsLetter.click();

       WebElement yes = driver.findElement(By.xpath("//input[@value=\"1\"]"));
       yes.click();

       WebElement continueButton = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
       continueButton.click();

        Tools.successMessageValidation();
    }
    @Test (priority = 1, dependsOnMethods = "subscribeNewLetterText" )
    public void unSubscribeNewLetterText () {

        WebElement newsLetter= driver.findElement(By.xpath("//a[.='Newsletter']"));
        newsLetter.click();

        WebElement no = driver.findElement(By.xpath("//input[@value='0']\n"));
        no.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        continueButton.click();

       Tools.successMessageValidation();
    }
    @Test(priority = 2, dependsOnMethods = "subscribeNewLetterText")
    public void switchNewsletterSubscription(){

        WebElement newsLetter= driver.findElement(By.xpath("//a[.='Newsletter']"));
        newsLetter.click();
        WebElement no = driver.findElement(By.xpath("//input[@value='0']"));
        WebElement yes = driver.findElement(By.xpath("//input[@value='1']"));

        if(no.isSelected()){
            yes.click();
        }else {
            no.click();
        }

    }
}
