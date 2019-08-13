package pages.subpages;

import model.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;

public class CompareProductPage extends BasicPage {

    private Product selectedProduct;

    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[1]/td[2]/h5/a")
    WebElement currentProductName;

    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[1]/td[2]/div[3]/span")
    WebElement currentProductValue;

    CompareProductPage(WebDriver driver, Product product) {
        super(driver);
        this.selectedProduct = product;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public String getCurrentProductName() {
        return currentProductName.getText();
    }

    public Float getCurrentProductValue(){
        return Float.parseFloat(currentProductValue.getText().substring(1));
    }
}
