package Day03;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class _4_Exercise4 extends BaseDriver {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Click on Address Book
     * Add a new address
     * Edit the address
     * Delete the address
     **/
    @Test
    public void addAddressTest () {
        login();

        WebElement addressBook = driver.findElement(By.xpath("//a[.='Address Book']"));
        addressBook.click();

        WebElement newAddress =driver.findElement(By.xpath("//a[.='New Address']"));
        newAddress.click();

        WebElement firstname = driver.findElement(By.id("input-firstname"));
        firstname.sendKeys("mila");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("lim");

        WebElement company =driver.findElement(By.id("input-company"));
        company.sendKeys("aaa");

        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.sendKeys("5874 John St.");

        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("LA");

        WebElement postCode = driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("58941");

        WebElement selectCountry = driver.findElement(By.id("input-country"));
        Select countrySelect = new Select(selectCountry);
        countrySelect.selectByVisibleText("United States");

        WebElement selectRegion = driver.findElement(By.id("input-zone"));
        Select regionSelect = new Select(selectRegion);
        regionSelect.selectByVisibleText("California");

        WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit']"));
        continueButton.click();

       }
    @Test(priority = 1,dependsOnMethods = "addAddressTest")
    void editAddressTest(){
        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement editButton = driver.findElement(By.xpath("//a[text()='Edit']"));
        editButton.click();

        WebElement city = driver.findElement(By.id("input-city"));
        city.clear();
        city.sendKeys("NYC");

        WebElement selectRegion = driver.findElement(By.id("input-zone"));
        Select regionSelect = new Select(selectRegion);
        regionSelect.selectByVisibleText("New York");

        WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit']"));
        continueButton.click();
    }
    @Test(priority = 2,dependsOnMethods = "addAddressTest")
    void deleteAddressTest(){
        WebElement addressBook = driver.findElement(By.linkText("Delete"));
        addressBook.click();
    }
}
