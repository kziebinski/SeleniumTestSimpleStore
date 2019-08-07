package pages.subpages.product;

import model.Product;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasicPage;
import pages.paymentFlow.AddedToCartPopup;
import pages.paymentFlow.CartSummary;

import java.util.Random;

public class ProductPage extends BasicPage {
    private static final Random rnd = new Random();

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    WebElement addQuantityProductInput;

    @FindBy(id = "our_price_display")
    WebElement priceProduct;

    @FindBy(id = "wishlist_button")
    WebElement addToWishlistButton;

    @FindBy(xpath = "//*[@id=\"product\"]/div[2]/div/div/div/div/p")
    WebElement addedToYourWishlistPopup;

    @FindBy(xpath = "//*[@id=\"usefull_link_block\"]/li[2]/a")
    WebElement printButton;

    @FindBy(xpath = "//*[@id=\"product_comments_block_extra\"]/ul/li/a")
    WebElement writeReviewButton;

    @FindBy(id = "send_friend_button")
    WebElement sendFriendButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public CartSummary clickAddToCartAndConfirmPopup() {
        addToCartButton.click();
        proceedToCheckoutButton.click();
        return new CartSummary(driver);
    }

    private Product addQuantity() {
        int tempRnd = rnd.nextInt(10) + 2;
        Product product = new Product(Float.parseFloat(priceProduct.getText().substring(1)), tempRnd);
        addQuantityProductInput.clear();
        addQuantityProductInput.sendKeys(String.valueOf(tempRnd));
        return product;
    }

    public AddedToCartPopup addQuantityAndClickCartButton() {
        Product product = addQuantity();
        addToCartButton.click();
        return new AddedToCartPopup(driver, product);
    }

    public ProductPage clickAddToWishlistButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToWishlistButton)).click();
        return this;
    }

    public String textAddedToYourWishlistPopup() {
        return addedToYourWishlistPopup.getText();
    }

    public PrintPage clickPrintButton() {
        wait.until(ExpectedConditions.elementToBeClickable(printButton)).click();
        for (String printTab : driver.getWindowHandles()) {
            driver.switchTo().window(printTab);
        }
        return new PrintPage(driver);
    }

    public WriteReviewPage clickWriteReviewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(writeReviewButton)).click();
        return new WriteReviewPage(driver);
    }

    public boolean writeReviewButtonNotExist() {
        try {
            return writeReviewButton.isDisplayed();
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public SendToFriendPage clickAndGoTOSendFriendPage() {
        wait.until(ExpectedConditions.elementToBeClickable(sendFriendButton)).click();
        return new SendToFriendPage(driver);
    }

}
