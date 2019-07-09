package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    WebElement proceedToCheckoutButton;

    @FindBy(id = "cgv")
    WebElement agreeCheckbox;

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public ShippingPage clickAgreeCheckbox(){
        agreeCheckbox.click();
        return this;
    }

    public PaymentPage clickProceedToCheckoutButtonAndGoToPaymentPage(){
        proceedToCheckoutButton.click();
        return new PaymentPage(driver);
    }
}
