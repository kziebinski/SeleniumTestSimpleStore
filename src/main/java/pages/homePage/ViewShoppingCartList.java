package pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasicPage;

public class ViewShoppingCartList extends BasicPage {

    private WebDriverWait wait = new WebDriverWait(driver, 3);

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
