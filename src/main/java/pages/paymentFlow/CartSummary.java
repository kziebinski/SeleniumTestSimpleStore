package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.subpages.AuthenticationPage;

public class CartSummary {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement proceedToCheckoutButton;

    public CartSummary(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AuthenticationPage goToSignInPage() {
        proceedToCheckoutButton.click();
        return new AuthenticationPage(driver);
    }
}
