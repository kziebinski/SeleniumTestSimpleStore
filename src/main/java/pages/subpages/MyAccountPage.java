package pages.subpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;
import pages.paymentFlow.CartSummary;

public class MyAccountPage extends BasicPage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    WebElement myAccountText;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement customerAccountName;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    WebElement shoppingCartButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a")
    WebElement myPersonalInformationButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public String myAccountNameText(){
        return customerAccountName.getText();
    }
    public String myAccountText(){
        return myAccountText.getText();
    }

    public CartSummary goToCartSummaryPage(){
        shoppingCartButton.click();
        return new CartSummary(driver);
    }
    public PersonalInfromationPage clickMyPersonalInfromationButtonAndGoToPersonalInformationPage(){
        myPersonalInformationButton.click();
        return new PersonalInfromationPage(driver);
    }
}
