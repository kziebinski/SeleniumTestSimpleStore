package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p/strong")
    WebElement textConfirmOrderComplete;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextConfirmOderComplete(){
        return textConfirmOrderComplete.getText();
    }
}
