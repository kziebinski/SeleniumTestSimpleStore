package pages.subpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;
import pages.paymentFlow.CartSummary;

public class ProductPage extends BasicPage {

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement proceedToCheckoutButton;

    public ProductPage(WebDriver driver){ super(driver); }

    public CartSummary clickAddToCartAndConfirmPopup(){
        addToCartButton.click();
        proceedToCheckoutButton.click();
        return new CartSummary(driver);
    }

}
