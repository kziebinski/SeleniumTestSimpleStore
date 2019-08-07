package pages.subpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;
import pages.HookProperties;
import pages.paymentFlow.AddressesPage;
import test.BasicSetupTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AuthenticationPage extends BasicPage {

    private final Logger log = LogManager.getLogger(BasicSetupTest.class.getName());
    private HookProperties hookProperties = new HookProperties();
    private final Properties properties = loginProperties();

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
    public AuthenticationPage complementEmailPasswordAndClickConfirm(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitLoginButton.click();
        return this;
    }

    public String checkDisplayInvalidErrorText() {
        return invalidErrorText.getText();
    }

    public MyAccountPage properLoginAndGoToMyAccountPage() {
        complementEmailPasswordAndClickConfirm(properties.getProperty("login.emailMain"), properties.getProperty("login.passwordMain"));
        return new MyAccountPage(driver);
    }

    public AddressesPage properLoginAndGoToAddressesPage() {
        complementEmailPasswordAndClickConfirm(properties.getProperty("login.emailMain"), properties.getProperty("login.passwordMain"));
        return new AddressesPage(driver);
    }

    public MyAccountPage properLoginWithTemperaryEmailAndLogin() {
        complementEmailPasswordAndClickConfirm(properties.getProperty("login.emailTemp"), properties.getProperty("login.passwordTemp"));
        return new MyAccountPage(driver);
    }

    public MyAccountPage properLoginWithRandomGenerateEmailAndLogin() throws IOException {
        complementEmailPasswordAndClickConfirm(hookProperties.loginLoadFakeProperties().getProperty("login.fakeEmail"), hookProperties.loginLoadFakeProperties().getProperty("login.fakePassword"));
        return new MyAccountPage(driver);
    }

    private Properties loginProperties() {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/properties/login.properties")) {
            prop.load(input);
            return prop;
        } catch (IOException e) {
            log.error("Cannot load properties", e);
            return prop;
        }
    }
}
