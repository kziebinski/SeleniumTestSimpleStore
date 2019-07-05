package pages.socialMediaPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwitterPage {

    private WebDriver driver;

    public TwitterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"page-container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/h1/a")
    WebElement profileNameText;

    public String twitterNameProfileText(){
        return profileNameText.getText();
    }

    public String urlTwitterPage(){
        return driver.getCurrentUrl();
    }
}
