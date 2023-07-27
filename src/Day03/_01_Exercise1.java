package Day03;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Exercise1 extends BaseDriver {
    @Test
    public void Test1() {
/** Go to "https://opencart.abstracta.us/index.php?route=account/login"
 * Login
 * Click on Edit Account
 * Update name
 * Click on Continue
 * Verify the success message
 * Then update the name with the old name
 **/
        login();
        editName("Ela");
        editName("mila");
    }
    void editName(String name){
        WebElement editAccount = driver.findElement(By.xpath("//a[.='Edit Account']"));
        editAccount.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys(name);

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value=\"Continue\"]"));
        continueBtn.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[.=' Success: Your account has been successfully updated.']"));
        Assert.assertTrue(successMessage.getText().contains("successfully updated."));
    }
}
