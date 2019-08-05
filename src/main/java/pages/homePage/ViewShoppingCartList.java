package pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasicPage;

public class ViewShoppingCartList extends BasicPage {

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt/span/a")
    WebElement deleteProductButton;

    public ViewShoppingCartList(WebDriver driver){
        super(driver);
    }

    public HomePage clickDeleteProdcutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteProductButton)).click();
        return new HomePage(driver);
    }
}
