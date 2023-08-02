package Day6.xmlFiles;

import Utilities.BaseDriver;
import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _05_SearchFunctionWithDataProviderParallelTest extends ParameterDriver {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * search for mac, samsung, ipod by using data provider
     * Check all results contains these keywords
     * Use ParameterDriver class and run the tests for different browsers parallel
     * */
    @Test (dataProvider = "searchKeyword", dataProviderClass = _04_SearchFunctionWithDataProvider.class)
    void Test1(String searchKeyword ){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        if (searchKeyword.equalsIgnoreCase("mac")){
            login();
        }
        WebElement search = driver.findElement(By.xpath("//input[@class=\"form-control input-lg\"]"));
        search.sendKeys(searchKeyword);
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();
        List<WebElement> results = driver.findElements(By.cssSelector("div[class='caption'] a"));
        for (WebElement element : results) {
            Assert.assertTrue(element.getText().toLowerCase().contains(searchKeyword));
        }
    }
}
