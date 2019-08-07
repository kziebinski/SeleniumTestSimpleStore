package test.paymentTest;

import model.Product;
import org.testng.annotations.Test;
import pages.paymentFlow.AddedToCartPopup;
import pages.paymentFlow.OrderConfirmationPage;
import test.BasicSetupTest;

import static org.testng.AssertJUnit.assertEquals;

public class PaymentStepByStep extends BasicSetupTest {

    @Test
    public void PaymentBuyItemNotLogin() {

        OrderConfirmationPage page =
                homePage
                        .clickAddItemToCartAndConfirm()
                        .goToSignInPage()
                        .properLoginAndGoToAddressesPage()
                        .clickProceedToCheckoutButtonAndGoToShippingPage()
                        .clickAgreeCheckbox()
                        .clickProceedToCheckoutButtonAndGoToPaymentPage()
                        .clickPayByBankWireButton()
                        .clickConfirmButton();

        assertEquals(page.getTextConfirmOderComplete(), "Your order on My Store is complete.");
    }

    @Test
    public void PaymentRandomItemNotLogin() {
        OrderConfirmationPage page =
                homePage
                        .clickItemAndGoToProductPage()
                        .clickAddToCartAndConfirmPopup()
                        .goToSignInPage()
                        .properLoginAndGoToAddressesPage()
                        .clickProceedToCheckoutButtonAndGoToShippingPage()
                        .clickAgreeCheckbox()
                        .clickProceedToCheckoutButtonAndGoToPaymentPage()
                        .clickPayByBankWireButton()
                        .clickConfirmButton();

        assertEquals(page.getTextConfirmOderComplete(), "Your order on My Store is complete.");
    }

    @Test
    public void PaymentRandomQuantityVerifyAmount() {
        AddedToCartPopup popup =
                homePage
                        .clickItemAndGoToProductPage()
                        .addQuantityAndClickCartButton();
        Product product = popup.getProduct();
        float amountProduct = product.getQuantity() * product.getValue();
        assertEquals(amountProduct, popup.getValueTotalProductValue());
        assertEquals(amountProduct + popup.getValueShipping(), popup.getTotalValue());
        assertEquals(amountProduct, popup.getTotalValueLayerCart());
        assertEquals(product.getQuantity(), popup.getQuantityValueLayerCart());
    }
}
