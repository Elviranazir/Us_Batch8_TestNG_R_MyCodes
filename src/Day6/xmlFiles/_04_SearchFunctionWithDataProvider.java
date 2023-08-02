package Day6.xmlFiles;

import Utilities.BaseDriver;
import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _04_SearchFunctionWithDataProvider extends ParameterDriver {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * search for mac, samsung, ipod by using data provider
     * Check all results contains these keywords
     * Use BaseDriver class
     * */
    @Test (dataProvider = "searchKeyword")
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
    @DataProvider (name = "searchKeyword")
    public Object[][] KeywordList (){
        Object[][] list = {
                {"mac"},
                {"samsung"},
                {"ipod"},
        };
        return list;
    }

}
