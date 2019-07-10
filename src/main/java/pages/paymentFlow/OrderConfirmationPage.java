package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;

public class OrderConfirmationPage extends BasicPage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p/strong")
    WebElement textConfirmOrderComplete;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getTextConfirmOderComplete(){
        return textConfirmOrderComplete.getText();
    }
}
