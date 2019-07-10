package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;

public class PaymentPage extends BasicPage {

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    WebElement payByBankWireButton;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
    WebElement payByCheckButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    public PaymentSummaryPage clickPayByBankWireButton(){
        payByBankWireButton.click();
        return new PaymentSummaryPage(driver);
    }
}
