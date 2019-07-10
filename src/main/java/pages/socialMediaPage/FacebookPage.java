package pages.socialMediaPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;

public class FacebookPage extends BasicPage {

    public FacebookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"blueBarDOMInspector\"]/div/div[1]/div/div[1]/h1/a/i")
    WebElement facebookText;

    public String facebookPageText() {
        return facebookText.getText();
    }

    public String urlFacebookPage() {
        return driver.getCurrentUrl();
    }

}
