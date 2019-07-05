package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    WebElement myAccountText;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement customerAccountName;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String myAccountNameText(){
        return customerAccountName.getText();
    }
    public String myAccountText(){
        return myAccountText.getText();
    }
}
