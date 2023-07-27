package Day03;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _02_Exercise2 extends BaseDriver {
    @Test
    public void validateMenu() {
        /**
         * Go to "https://opencart.abstracta.us/index.php?route=account/login"
         * Login
         * Validate that you see all menu options
         * */
        login();
        List<WebElement> menuOptions = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li"));
        List<String> menuText = new ArrayList<>(List.of("Desktops", "Laptops & Notebooks", "Components", "Tablets", "Software", "Phones & PDAs", "Cameras", "MP3 Players"));

        for (WebElement m : menuOptions){
            Assert.assertTrue(menuText.contains(m.getText()));
            Assert.assertTrue(m.isDisplayed());
        }

    }
}
