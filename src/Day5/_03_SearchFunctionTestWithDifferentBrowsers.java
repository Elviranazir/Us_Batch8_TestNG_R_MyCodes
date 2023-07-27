package Day5;

import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _03_SearchFunctionTestWithDifferentBrowsers extends ParameterDriver {
    @Test
    @Parameters({"message"})
    public void SearchFunctionTest(String message) {
        login();
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
