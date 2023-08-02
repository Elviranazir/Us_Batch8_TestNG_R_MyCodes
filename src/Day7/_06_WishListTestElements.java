package Day7;

import Utilities.ParameterDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _06_WishListTestElements {
    public _06_WishListTestElements() {
        PageFactory.initElements(ParameterDriver.driver,this);
    }
    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
    public List<WebElement> wishListButtons;

    @FindBy(xpath = "//div[@class='caption']//a")
    public List<WebElement> productTitles;

    @FindBy(xpath = "//span[contains(text(),\"Wish List\")]")
    public WebElement wishListIcon;

    @FindBy(xpath = "//td[@class='text-left']//a")
    public WebElement productNameOnWishList;
}
