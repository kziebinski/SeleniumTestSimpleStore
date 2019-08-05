package pages.subpages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;

public class SendToFriendPage extends BasicPage {

    @FindBy(id = "friend_name")
    WebElement nameInput;

    @FindBy(id = "friend_email")
    WebElement emailInput;

    @FindBy(id = "sendEmail")
    WebElement sendEmailButton;

    @FindBy(xpath = "//*[@id=\"product\"]/div[2]/div/div/div/h2")
    WebElement textSendToFriend;

    @FindBy(xpath = "//*[@id=\"product\"]/div[2]/div/div/div/p[1]")
    WebElement textSentSuccessfully;

    @FindBy(id = "send_friend_form_error")
    WebElement textSendFriendError;

    public SendToFriendPage(WebDriver driver) {
        super(driver);
    }

    public SendToFriendPage sendKeysNameAndEmailThenClickSend(String name, String email) {
        nameInput.clear();
        if (name != null) {
            nameInput.sendKeys(name);
        }
        emailInput.clear();
        if (email != null) {
            emailInput.sendKeys(email);
        }
        sendEmailButton.click();
        return this;
    }

    public String getTextSendToFriend() {
        return textSendToFriend.getText();
    }

    public String getTextSendSuccessfully() {
        return textSentSuccessfully.getText();
    }

    public String getTextSendFriendError() {
        return textSendFriendError.getText();
    }
}
