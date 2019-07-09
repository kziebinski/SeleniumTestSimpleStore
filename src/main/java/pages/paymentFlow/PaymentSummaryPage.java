package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentSummaryPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    WebElement confirmButton;

    public PaymentSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OrderConfirmationPage clickConfirmButton() {
        confirmButton.click();
        return new OrderConfirmationPage(driver);
    }

}
