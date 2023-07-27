package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

  public static WebDriver driver;

    @BeforeClass
    public void createDriver() {
        closePreviousDrivers();

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        Duration duration = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(duration);
        driver.manage().timeouts().implicitlyWait(duration);

    }

    @AfterClass
    public void quitDriver() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public void closePreviousDrivers() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void login(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("milalim@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
    }
}
