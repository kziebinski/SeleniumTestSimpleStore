package test.productTest;

import org.testng.annotations.Test;
import pages.subpages.product.ProductPage;
import pages.subpages.product.WriteReviewPage;
import test.BasicSetupTest;

import static org.testng.AssertJUnit.assertEquals;

public class WriteReview extends BasicSetupTest {

    @Test
    public void sendReviewToAdminIfUserLogin() {
        WriteReviewPage page =
                homePage
                        .goToAuthenticationPage()
                        .properLoginAndGoToMyAccountPage()
                        .clickLogoImageAndGoToHomePage()
                        .clickItemAndGoToProductPage()
                        .clickWriteReviewButton()
                        .addTitleAndCommentAndClickSend();

        assertEquals("Your comment has been added and will be available once approved by a moderator", page.textNewCommentSend());
    }

    @Test
    public void sendReviewToAdminIfUserNotLogin() {
        ProductPage page =
                homePage
                        .clickItemAndGoToProductPage();

        assertEquals(false, page.writeReviewButtonNotExist());
    }
}
