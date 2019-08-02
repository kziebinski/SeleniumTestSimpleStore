package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.homePage.HomePage;
import pages.subpages.AuthenticationPage;

public abstract class BasicPage {

    protected WebDriver driver;

    @FindBy(id = "header_logo")
    WebElement logoImage;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    WebElement signOutButton;

    public BasicPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage clickLogoImageAndGoToHomePage(){
        logoImage.click();
        return new HomePage(driver);
    }
    public AuthenticationPage clickSignOutButton(){
        signOutButton.click();
        return new AuthenticationPage(driver);
    }
}
