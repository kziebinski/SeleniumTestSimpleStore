package test.shoppingCart;

import org.testng.annotations.Test;
import pages.paymentFlow.CartSummary;
import test.BasicSetupTest;

import static org.testng.AssertJUnit.assertEquals;

public class ShoppingCartEmpty extends BasicSetupTest {

    @Test
    public void paymentWithEmptyShoppingCart() {
        CartSummary cart =
                homePage
                        .goToAuthenticationPage()
                        .properLoginAndGoToMyAccountPage()
                        .goToCartSummaryPage();

        assertEquals("Your shopping cart is empty.", cart.getTextAlertEmptyShoppingCart());
    }
}
