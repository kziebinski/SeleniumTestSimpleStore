package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.homePage.HomePage;

public abstract class BasicPage {

    protected WebDriver driver;

    @FindBy(id = "header_logo")
    WebElement logoImage;

    public BasicPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage clickLogoImageAndGoToHomePage(){
        logoImage.click();
        return new HomePage(driver);
    }
}
