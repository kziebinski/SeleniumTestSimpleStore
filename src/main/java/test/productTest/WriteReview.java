package test.productTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.subpages.product.ProductPage;
import pages.subpages.product.WriteReviewPage;
import test.BasicSetupTest;

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

        Assert.assertEquals("Your comment has been added and will be available once approved by a moderator", page.textNewCommentSend());
    }

    @Test
    public void sendReviewToAdminIfUserNotLogin() {
        ProductPage page =
                homePage
                .clickItemAndGoToProductPage();

        Assert.assertEquals(false, page.writeReviewButtonNotExist());
    }
}
