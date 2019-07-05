package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {

    WebDriver driver;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "passwd")
    WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    WebElement submitLoginButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol/li")
    WebElement invalidErrorText;


    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String checkDisplayInvalidErrorText() {
        return invalidErrorText.getText();
    }

    public MyAccountPage properLoginAndGoToMyAccountPage() {
        complementEmailPasswordAndClickConfirm("konrad.ziebinski@globallogic.com", "zaq1!QAZ");
        return new MyAccountPage(driver);
    }

    public AuthenticationPage complementEmailPasswordAndClickConfirm(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitLoginButton.click();
        return this;
    }
}
