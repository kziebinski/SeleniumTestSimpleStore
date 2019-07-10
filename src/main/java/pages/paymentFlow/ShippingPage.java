package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;

public class ShippingPage extends BasicPage {

    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    WebElement proceedToCheckoutButton;

    @FindBy(id = "cgv")
    WebElement agreeCheckbox;

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public ShippingPage clickAgreeCheckbox() {
        agreeCheckbox.click();
        return this;
    }

    public PaymentPage clickProceedToCheckoutButtonAndGoToPaymentPage() {
        proceedToCheckoutButton.click();
        return new PaymentPage(driver);
    }
}
