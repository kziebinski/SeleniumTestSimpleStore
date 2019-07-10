package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;

public class AddressesPage extends BasicPage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    WebElement proceedToCheckoutButton;

    public AddressesPage(WebDriver driver) {
        super(driver);
    }

    public ShippingPage clickProceedToCheckoutButtonAndGoToShippingPage() {
        proceedToCheckoutButton.click();
        return new ShippingPage(driver);
    }
}
