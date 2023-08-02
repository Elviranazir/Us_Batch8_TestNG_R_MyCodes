package Day7;

import Utilities.BaseDriver;
import Utilities.ParameterDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _02_PlaceOrderElements {
    public _02_PlaceOrderElements() {

        PageFactory.initElements(ParameterDriver.driver, this);
    }

    @FindBy(name = "search")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    public WebElement searchButton;

    @FindBy(xpath = "(//div[@class='button-group']//button)[1]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    public WebElement cartButton;

    @FindBy(linkText = "Checkout")
    public WebElement checkoutButton;

    @FindBy(id = "button-payment-address")
    public WebElement continue1;

    @FindBy(id = "button-shipping-address")
    public WebElement continue2;

    @FindBy(id = "button-shipping-method")
    public WebElement continue3;

    @FindBy(id = "button-payment-method")
    public WebElement continue4;

    @FindBy(id = "button-confirm")
    public WebElement confirm;

    @FindBy(name = "agree")
    public WebElement terms;

    @FindBy(xpath = "(//div[@id='content']//p)[1]")
    public WebElement successMessage;
}
