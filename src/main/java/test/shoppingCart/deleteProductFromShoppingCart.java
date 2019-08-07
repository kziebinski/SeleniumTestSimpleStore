package test.shoppingCart;

import org.testng.annotations.Test;
import pages.paymentFlow.CartSummary;
import test.BasicSetupTest;

import static org.testng.AssertJUnit.assertEquals;

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

        assertEquals("Your shopping cart is empty.", page.getTextAlertEmptyShoppingCart());
    }

    @Test
    public void deleteItemFromShoppingCartWithoutAuthorization() {
        CartSummary page =
                homePage
                        .clickAddItemToCartAndConfirm()
                        .clickDeleteProductButton();

        assertEquals("Your shopping cart is empty.", page.getTextAlertEmptyShoppingCart());
    }
}
