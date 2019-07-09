package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    WebElement proceedToCheckoutButton;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ShippingPage clickProceedToCheckoutButtonAndGoToShippingPage(){
        proceedToCheckoutButton.click();
        return new ShippingPage(driver);
    }
}
