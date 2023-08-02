package Day7;

import Utilities.BaseDriver;
import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class _01_PlaceOrderTest extends ParameterDriver {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * Search for ipod
     * Add the first result to cart
     * Click on cart icon
     * Click on Check Out
     * Fill the form
     * Click on Confirm and verify that your order is successful
     */
    @Test(dataProvider = "keywordGenerator")
    public void placeOrder(String keyword) {
//        if (keyword.equalsIgnoreCase("ipod")){
//            login();
//        }
        login();

        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys(keyword);

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();

        WebElement addToCartButton = driver.findElement(By.xpath("(//div[@class='button-group']//button)[1]"));
        addToCartButton.click();

        WebElement cartButton = driver.findElement(By.xpath("//span[text()='Shopping Cart']"));
        cartButton.click();

        WebElement checkoutButton = driver.findElement(By.linkText("Checkout"));
        checkoutButton.click();

        WebElement continue1 = driver.findElement(By.id("button-payment-address"));
        continue1.click();

        WebElement continue2 = driver.findElement(By.id("button-shipping-address"));
        continue2.click();

        WebElement continue3 = driver.findElement(By.id("button-shipping-method"));
        continue3.click();


        WebElement terms = driver.findElement(By.name("agree"));
        terms.click();

        WebElement continue4 = driver.findElement(By.id("button-payment-method"));
        continue4.click();

        WebElement confirm = driver.findElement(By.id("button-confirm"));
        confirm.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='content']//p)[1]")));

        WebElement successMessage = driver.findElement(By.xpath("(//div[@id='content']//p)[1]"));
        System.out.println("Success text = " + successMessage.getText());

        Assert.assertTrue(successMessage.getText().contains("successfully processed"));


    } @DataProvider(name = "keywordGenerator")
    public Object[][] searchKeyword () {

        Object[][] keyword = {
                {"ipod"}//,
              //  {"mac"}
        };
        return keyword;
    }
}