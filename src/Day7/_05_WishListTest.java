package Day7;

import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class _05_WishListTest extends ParameterDriver {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * search for ipod (send "ipod" from xml file)
     * add one of the elements to the wish list randomly
     * Click on Wish List button
     * Check if the name of the element is the same with the name of the element you added.
     * Use POM and ParameterDriver
     * Perform non-parallel cross browser test
     * */

    @Test
    @Parameters("searchKeyword")
    void wishListTest(String searchKeyword){
        login();

        _02_PlaceOrderElements plc = new _02_PlaceOrderElements();

        plc.searchBox.sendKeys(searchKeyword);
        plc.searchButton.click();

        _06_WishListTestElements wishList = new _06_WishListTestElements();

        int randomIndex = (int)(Math.random()*wishList.wishListButtons.size());

        wishList.wishListButtons.get(randomIndex).click();

        String productName = wishList.productTitles.get(randomIndex).getText();

        wishList.wishListIcon.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='text-left']//a)[2]")));

        Assert.assertEquals(wishList.productNameOnWishList.getText(),productName);

        //TODO create the xml file for this test
    }
}