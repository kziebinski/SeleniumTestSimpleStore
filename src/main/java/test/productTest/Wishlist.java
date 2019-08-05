package test.productTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.subpages.product.ProductPage;
import test.BasicSetupTest;

public class Wishlist extends BasicSetupTest {

    @Test
    public void AddToWishlistWithLogin() {

        ProductPage page =
                homePage
                        .goToAuthenticationPage()
                        .properLoginAndGoToMyAccountPage()
                        .clickLogoImageAndGoToHomePage()
                        .clickItemAndGoToProductPage()
                        .clickAddToWishlistButton();

        Assert.assertEquals("Added to your wishlist.", page.textAddedToYourWishlistPopup());

    }

    @Test
    public void AddToWishlistWithoutLogin(){
        ProductPage page =
                homePage
                    .clickItemAndGoToProductPage()
                    .clickAddToWishlistButton();

        Assert.assertEquals("You must be logged in to manage your wishlist.", page.textAddedToYourWishlistPopup());
    }
}
