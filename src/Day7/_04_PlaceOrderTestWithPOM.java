package Day7;

import Utilities.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class _04_PlaceOrderTestWithPOM extends BaseDriver {

    @Test
    void placeOrderTest(){
        login();

        _02_PlaceOrderElements elements = new _02_PlaceOrderElements();

        elements.searchBox.sendKeys("ipod");
        elements.searchButton.click();
        elements.addToCartButton.click();
        elements.cartButton.click();
        elements.checkoutButton.click();
        elements.continue1.click();
        elements.continue2.click();
        elements.continue3.click();
        elements.terms.click();
        elements.continue4.click();
        elements.confirm.click();
        System.out.println("elements.successMessage.getText() before wait ----> " + elements.successMessage.getText());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(elements.successMessage));
        System.out.println("elements.successMessage.getText() after wait ----> " + elements.successMessage.getText());
        Assert.assertTrue(elements.successMessage.getText().contains("successfully processed"));
    }
}