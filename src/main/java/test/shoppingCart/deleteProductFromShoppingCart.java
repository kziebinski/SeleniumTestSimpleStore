package test.shoppingCart;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.paymentFlow.CartSummary;
import test.BasicSetupTest;

public class deleteProductFromShoppingCart extends BasicSetupTest {

    @Test
    public void deleteItemFromShoppingCartWithAuthorization() {
        CartSummary page =
                homePage
                        .goToAuthenticationPage()
                        .properLoginAndGoToMyAccountPage()
                        .clickLogoImageAndGoToHomePage()
                        .clickAddItemToCartAndConfirm()
                        .clickDeleteProductButton();

        Assert.assertEquals("Your shopping cart is empty.", page.getTextAlertEmptyShoppingCart());
    }

    @Test
    public void deleteItemFromShoppingCartWithoutAuthorization() {
        CartSummary page =
                homePage
                        .clickAddItemToCartAndConfirm()
                        .clickDeleteProductButton();

        Assert.assertEquals("Your shopping cart is empty.", page.getTextAlertEmptyShoppingCart());
    }
}
