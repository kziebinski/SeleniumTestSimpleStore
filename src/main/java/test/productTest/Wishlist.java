package test.productTest;

import org.testng.annotations.Test;
import pages.subpages.product.ProductPage;
import test.BasicSetupTest;

import static org.testng.AssertJUnit.assertEquals;

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

        assertEquals("Added to your wishlist.", page.textAddedToYourWishlistPopup());

    }

    @Test
    public void AddToWishlistWithoutLogin() {
        ProductPage page =
                homePage
                        .clickItemAndGoToProductPage()
                        .clickAddToWishlistButton();

        assertEquals("You must be logged in to manage your wishlist.", page.textAddedToYourWishlistPopup());
    }
}
