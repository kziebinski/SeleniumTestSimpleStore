package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.socialMediaPage.FacebookPage;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"social_block\"]/ul/li[1]/a")
    WebElement facebookButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AuthenticationPage goToAuthenticationPage() {
        signInButton.click();
        return new AuthenticationPage(driver);
    }

    public FacebookPage goToFacebookPage(){
        facebookButton.click();
        for(String facebookTab:driver.getWindowHandles()){
            driver.switchTo().window(facebookTab);
        }
        return new FacebookPage(driver);
    }
}
