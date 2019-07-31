package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasicPage;
import pages.subpages.AuthenticationPage;

public class CartSummary extends BasicPage {

    private WebDriverWait wait = new WebDriverWait(driver, 5);

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    WebElement alerEmptyShoppingCart;

    @FindBy(className = "cart_quantity_delete")
    WebElement deleteProductButton;


    public CartSummary(WebDriver driver) {
        super(driver);
    }

    public AuthenticationPage goToSignInPage() {
        proceedToCheckoutButton.click();
        return new AuthenticationPage(driver);
    }

    public String getTextAlertEmptyShoppingCart() {
        return alerEmptyShoppingCart.getText();
    }

    public CartSummary clickDeleteProductButton() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteProductButton)).click();
        wait.until(ExpectedConditions.visibilityOf(alerEmptyShoppingCart));
        return this;
    }

}
