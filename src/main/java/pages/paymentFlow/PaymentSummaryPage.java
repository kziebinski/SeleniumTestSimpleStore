package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;

public class PaymentSummaryPage extends BasicPage {

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    WebElement confirmButton;

    public PaymentSummaryPage(WebDriver driver) {
        super(driver);
    }

    public OrderConfirmationPage clickConfirmButton() {
        confirmButton.click();
        return new OrderConfirmationPage(driver);
    }

}
