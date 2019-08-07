package test.shoppingCart;

import org.testng.annotations.Test;
import pages.paymentFlow.CartSummary;
import test.BasicSetupTest;

import static org.testng.AssertJUnit.assertEquals;

public class deleteProductFromListShoppingCart extends BasicSetupTest {

    @Test
    public void deleteProductFromListCartWithoutAuthorization() {

        CartSummary page =
                homePage
                        .clickAddItemToCartAndClosePopup()
                        .moveMouseToShoppingCartList()
                        .clickDeleteProdcutButton()
                        .clickShoppingCartButton();

        assertEquals("Your shopping cart is empty.", page.getTextAlertEmptyShoppingCart());
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

        assertEquals("Your shopping cart is empty.", page.getTextAlertEmptyShoppingCart());

    }
}
