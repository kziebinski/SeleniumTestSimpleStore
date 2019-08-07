package test.productTest;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.subpages.product.SendToFriendPage;
import test.BasicSetupTest;

import static org.testng.AssertJUnit.assertEquals;

public class SendToFriend extends BasicSetupTest {

    private Faker faker = new Faker();

    @Test
    public void correctSendToFriendMessage() {
        SendToFriendPage page =
                homePage
                        .clickItemAndGoToProductPage()
                        .clickAndGoTOSendFriendPage()
                        .sendKeysNameAndEmailThenClickSend(faker.name().firstName(), faker.internet().emailAddress());

        assertEquals("Send to a friend", page.getTextSendToFriend());
        assertEquals("Your e-mail has been sent successfully", page.getTextSendSuccessfully());

    }

    @Test
    public void validationNameSendToFriendMessage() {
        SendToFriendPage page =
                homePage
                        .clickItemAndGoToProductPage()
                        .clickAndGoTOSendFriendPage()
                        .sendKeysNameAndEmailThenClickSend(null, faker.internet().emailAddress());

        assertEquals("You did not fill required fields", page.getTextSendFriendError());

    }

    @Test
    public void validationEmailSendToFriendMessage() {
        SendToFriendPage page =
                homePage
                        .clickItemAndGoToProductPage()
                        .clickAndGoTOSendFriendPage()
                        .sendKeysNameAndEmailThenClickSend(faker.name().firstName(), null);

        assertEquals("You did not fill required fields", page.getTextSendFriendError());
    }
}
