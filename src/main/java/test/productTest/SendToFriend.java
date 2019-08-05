package test.productTest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.subpages.product.SendToFriendPage;
import test.BasicSetupTest;

public class SendToFriend extends BasicSetupTest {

    private Faker faker = new Faker();

    @Test
    public void correctSendToFriendMessage() {
        SendToFriendPage page =
                homePage
                        .clickItemAndGoToProductPage()
                        .clickAndGoTOSendFriendPage()
                        .sendKeysNameAndEmailThenClickSend(faker.name().firstName(), faker.internet().emailAddress());

        Assert.assertEquals("Send to a friend", page.getTextSendToFriend());
        Assert.assertEquals("Your e-mail has been sent successfully", page.getTextSendSuccessfully());

    }

    @Test
    public void validationNameSendToFriendMessage() {
        SendToFriendPage page =
                homePage
                        .clickItemAndGoToProductPage()
                        .clickAndGoTOSendFriendPage()
                        .sendKeysNameAndEmailThenClickSend(null, faker.internet().emailAddress());

        Assert.assertEquals("You did not fill required fields", page.getTextSendFriendError());

    }

    @Test
    public void validationEmailSendToFriendMessage() {
        SendToFriendPage page =
                homePage
                        .clickItemAndGoToProductPage()
                        .clickAndGoTOSendFriendPage()
                        .sendKeysNameAndEmailThenClickSend(faker.name().firstName(), null);

        Assert.assertEquals("You did not fill required fields", page.getTextSendFriendError());
    }
}
