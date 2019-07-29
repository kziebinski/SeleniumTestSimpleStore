package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;
import pages.subpages.AuthenticationPage;

public class CartSummary extends BasicPage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    WebElement alerEmptyShoppingCart;

    public CartSummary(WebDriver driver) {
        super(driver);
    }

    public AuthenticationPage goToSignInPage() {
        proceedToCheckoutButton.click();
        return new AuthenticationPage(driver);
    }

    public String getTextAlertEmptyShoppingCart(){
        return alerEmptyShoppingCart.getText();
    }
}
