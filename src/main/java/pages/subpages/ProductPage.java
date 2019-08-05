package pages.subpages;

import model.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasicPage;
import pages.paymentFlow.AddedToCartPopup;
import pages.paymentFlow.CartSummary;

import java.util.Random;

public class ProductPage extends BasicPage {

    private Product product = new Product();
    private WebDriverWait wait = new WebDriverWait(driver, 3);

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    WebElement addQuantityProductInput;

    @FindBy(id = "our_price_display" )
    WebElement priceProduct;

    @FindBy(id = "wishlist_button")
    WebElement addToWishlistButton;

    @FindBy(xpath = "//*[@id=\"product\"]/div[2]/div/div/div/div/p")
    WebElement addedToYourWishlistPopup;

    public ProductPage(WebDriver driver){ super(driver); }

    public CartSummary clickAddToCartAndConfirmPopup(){
        addToCartButton.click();
        proceedToCheckoutButton.click();
        return new CartSummary(driver);
    }
    public void addQuantity(){
        Random rnd = new Random();
        int tempRnd = rnd.nextInt(10) + 2;
        product.setQuantity(tempRnd);
        product.setValue(Float.parseFloat(priceProduct.getText().substring(1)));
        addQuantityProductInput.clear();
        addQuantityProductInput.sendKeys(String.valueOf(tempRnd));
    }
    public AddedToCartPopup addQuantityAndClickCartButton(){
        addQuantity();
        addToCartButton.click();
        return new AddedToCartPopup(driver);
    }
    public ProductPage clickAddToWishlistButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addToWishlistButton)).click();
        return this;
    }
    public String textAddedToYourWishlistPopup(){
        return addedToYourWishlistPopup.getText();
    }

}
