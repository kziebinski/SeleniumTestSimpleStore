package test.shoppingCart;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.paymentFlow.CartSummary;
import test.BasicSetupTest;

public class deleteProductFromListShoppingCart extends BasicSetupTest {

    @Test
    public void deleteProductFromListCartWithoutAuthorization() {

        CartSummary page =
                homePage
                        .clickAddItemToCartAndClosePopup()
                        .moveMouseToShoppingCartList()
                        .clickDeleteProdcutButton()
                        .clickShoppingCartButton();

        Assert.assertEquals("Your shopping cart is empty.", page.getTextAlertEmptyShoppingCart());
    }

    @Test
    public void deleteProdcutFromListCartWithAuthorization() {
        CartSummary page =
                homePage
                        .goToAuthenticationPage()
                        .properLoginAndGoToMyAccountPage()
                        .clickLogoImageAndGoToHomePage()
                        .clickAddItemToCartAndClosePopup()
                        .moveMouseToShoppingCartList()
                        .clickDeleteProdcutButton()
                        .clickShoppingCartButton();

        Assert.assertEquals("Your shopping cart is empty.", page.getTextAlertEmptyShoppingCart());

    }
}
