package pages.paymentFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasicPage;

public class AddedToCartPopup extends BasicPage {

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[1]/span")
    WebElement totalProductValue;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[2]/span")
    WebElement totalSnippingValue;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[3]/span")
    WebElement totalValue;

    @FindBy(id = "layer_cart_product_quantity")
    WebElement quantityLayerCartValue;

    @FindBy(id = "layer_cart_product_price")
    WebElement totalLayerCartValue;

    public AddedToCartPopup(WebDriver driver){
        super(driver);
    }

    public float getValueTotalProductValue() {
        wait.until(ExpectedConditions.visibilityOfAllElements(totalProductValue));
        return Float.parseFloat(totalProductValue.getText().substring(1));
    }
    public float getValueShipping(){
        wait.until(ExpectedConditions.visibilityOf(totalSnippingValue));
        return Float.parseFloat((totalSnippingValue.getText().substring(1)));
    }
    public float getTotalValue(){
        wait.until(ExpectedConditions.visibilityOf(totalValue));
        return Float.parseFloat(totalValue.getText().substring(1));
    }
    public float getQuantityValueLayerCart(){
        wait.until(ExpectedConditions.visibilityOf(quantityLayerCartValue));
        return Float.parseFloat(quantityLayerCartValue.getText());
    }
    public float getTotalValueLayerCart(){
        wait.until(ExpectedConditions.visibilityOf(totalLayerCartValue));
        return Float.parseFloat(totalLayerCartValue.getText().substring(1));
    }
}
