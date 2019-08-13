package pages.subpages;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasicPage;

public class CompareProductPage extends BasicPage {

    private Product selectedProduct;

    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[1]/td[2]/h5/a")
    WebElement currentProductName;

    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[1]/td[2]/div[3]/span")
    WebElement currentProductValue;

    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[1]/td[2]/div[1]/a")
    WebElement deleteCompareProduct;

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

    public Float getCurrentProductValue() {
        return Float.parseFloat(currentProductValue.getText().substring(1));
    }

    public CompareProductPage clickDeleteCompareProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteCompareProduct)).click();
        return this;
    }

    public Integer getProdcutComparison(){
        return driver.findElements(By.xpath("//*[@id=\"product_comparison\"]/tbody/tr[1]")).size();
    }
}
