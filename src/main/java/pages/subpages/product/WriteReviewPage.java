package pages.subpages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasicPage;

public class WriteReviewPage extends BasicPage {

    @FindBy(id = "comment_title")
    WebElement titileInput;

    @FindBy(id = "content")
    WebElement commentTextArea;

    @FindBy(id = "submitNewMessage")
    WebElement sendMessageButton;

    @FindBy(xpath = "//*[@id=\"product\"]/div[2]/div/div/div/p[1]")
    WebElement textNewCommmentSend;

    public WriteReviewPage(WebDriver driver){
        super(driver);
    }

    public WriteReviewPage addTitleAndCommentAndClickSend(){
        titileInput.sendKeys("QAtest");
        commentTextArea.sendKeys("test 123456");
        sendMessageButton.click();
        return this;
    }

    public String textNewCommentSend(){
        return textNewCommmentSend.getText();
    }
}
