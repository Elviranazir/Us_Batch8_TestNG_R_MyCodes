package Day5;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _02_SearchFunctionTest extends BaseDriver {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in with parameters
     * Search for "mac" (use xml to send "mac" keyword)
     * Check if all results contains mac key word
     */
    @Test
    @Parameters ({"username","password","message"})
    public void SearchFunctionTest(String username, String password,String message) {
        login(username, password);
        WebElement search = driver.findElement(By.xpath("//input[@class=\"form-control input-lg\"]"));
        search.sendKeys(message);

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> results = driver.findElements(By.cssSelector("div[class='caption'] a"));
        for (WebElement element : results) {

            Assert.assertTrue(element.getText().toLowerCase().contains(message));
        }

    }
}
