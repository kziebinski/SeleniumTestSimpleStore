package pages.subpages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;
import pages.HookProperties;

import java.io.IOException;
import java.util.Properties;

public class PersonalInfromationPage extends BasicPage {

    private Faker faker = new Faker();
    private HookProperties hookProperties = new HookProperties();

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

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p")
    WebElement alertSuccessfullyUpdate;


    public PersonalInfromationPage(WebDriver driver){
        super(driver);
    }

    public PersonalInfromationPage fillNewEmailAndNewPasswordThenSave(){
        Properties prop = hookProperties.loginWriteProperties();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();
        prop.setProperty("login.fakeEmail", fakeEmail);
        prop.setProperty("login.fakePassword", fakePassword);
        try {
            prop.store(hookProperties.outputStream(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(prop);
        emailInput.clear();
        emailInput.sendKeys(fakeEmail);
        oldPasswordInput.sendKeys(hookProperties.loginLoadProperties().getProperty("login.passwordTemp"));
        newPasswordInput.sendKeys(fakePassword);
        confirmNewPasswordInput.sendKeys(fakePassword);
        saveButton.click();
        return this;
    }
    public PersonalInfromationPage fillNTempEmailAndTempPasswordThenSave(){
        emailInput.clear();
        emailInput.sendKeys(hookProperties.loginLoadProperties().getProperty("login.emailTemp"));
        oldPasswordInput.sendKeys(hookProperties.loginLoadFakeProperties().getProperty("login.fakePassword"));
        newPasswordInput.sendKeys(hookProperties.loginLoadProperties().getProperty("login.passwordTemp"));
        confirmNewPasswordInput.sendKeys(hookProperties.loginLoadProperties().getProperty("login.passwordTemp"));
        saveButton.click();
        return this;
    }
}
