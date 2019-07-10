package pages.subpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasicPage;
import pages.paymentFlow.AddressesPage;

public class AuthenticationPage extends BasicPage {

    private final String email = "konrad.ziebinski@globallogic.com";
    private final String password = "zaq1!QAZ";

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "passwd")
    WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    WebElement submitLoginButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol/li")
    WebElement invalidErrorText;


    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public String checkDisplayInvalidErrorText() {
        return invalidErrorText.getText();
    }

    public MyAccountPage properLoginAndGoToMyAccountPage() {
        complementEmailPasswordAndClickConfirm(email, password);
        return new MyAccountPage(driver);
    }
    public AddressesPage properLoginAndGoToAddressesPage(){
        complementEmailPasswordAndClickConfirm(email, password);
        return new AddressesPage(driver);
    }

    public AuthenticationPage complementEmailPasswordAndClickConfirm(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitLoginButton.click();
        return this;
    }
}
