package pages.subpages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;
import pages.HookProperties;

import java.io.IOException;
import java.util.Properties;

public class PersonalInformationPage extends BasicPage {

    private final static Logger log = LogManager.getLogger(PersonalInformationPage.class.getName());
    private Faker faker = new Faker();
    private HookProperties hookProperties = new HookProperties();
    private Properties properties;
    private Properties fakeProperties;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "old_passwd")
    WebElement oldPasswordInput;

    @FindBy(id = "passwd")
    WebElement newPasswordInput;

    @FindBy(id = "confirmation")
    WebElement confirmNewPasswordInput;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button")
    WebElement saveButton;

    PersonalInformationPage(WebDriver driver) throws IOException {
        super(driver);
        properties = hookProperties.loginLoadProperties();
        fakeProperties = hookProperties.loginLoadFakeProperties();
    }

    public PersonalInformationPage fillNewEmailAndNewPasswordThenSave() {
        Properties prop = hookProperties.loginWriteProperties();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();
        prop.setProperty("login.fakeEmail", fakeEmail);
        prop.setProperty("login.fakePassword", fakePassword);
        try {
            prop.store(hookProperties.outputStream(), null);
        } catch (IOException e) {
            log.error(e);
        }
        log.info(prop);
        emailInput.clear();
        emailInput.sendKeys(fakeEmail);
        oldPasswordInput.sendKeys(properties.getProperty("login.passwordTemp"));
        newPasswordInput.sendKeys(fakePassword);
        confirmNewPasswordInput.sendKeys(fakePassword);
        saveButton.click();
        return this;
    }

    public PersonalInformationPage fillNTempEmailAndTempPasswordThenSave() {
        emailInput.clear();
        emailInput.sendKeys(properties.getProperty("login.emailTemp"));
        oldPasswordInput.sendKeys(fakeProperties.getProperty("login.fakePassword"));
        newPasswordInput.sendKeys(properties.getProperty("login.passwordTemp"));
        confirmNewPasswordInput.sendKeys(properties.getProperty("login.passwordTemp"));
        saveButton.click();
        return this;
    }
}
