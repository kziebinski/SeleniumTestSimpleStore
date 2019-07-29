package test.shoppingCart;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.paymentFlow.CartSummary;
import test.BasicSetupTest;

public class ShoppingCartEmpty extends BasicSetupTest {

    @Test
    public void paymentWithEmptyShoppingCart(){
        CartSummary cart =
                homePage
                .goToAuthenticationPage()
                .properLoginAndGoToMyAccountPage()
                .goToCartSummaryPage();

        Assert.assertEquals("Your shopping cart is empty.",cart.getTextAlertEmptyShoppingCart());
    }
}
