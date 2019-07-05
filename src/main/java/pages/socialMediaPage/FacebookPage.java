package pages.socialMediaPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    private WebDriver driver;

    public FacebookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"blueBarDOMInspector\"]/div/div[1]/div/div[1]/h1/a/i")
    WebElement facebookText;

    public String facebookPageText(){
        return facebookText.getText();
    }

    public String urlFacebookPage(){
        return driver.getCurrentUrl();
    }

}
