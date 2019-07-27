package test.payment;

import model.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.paymentFlow.AddedToCartPopup;
import pages.paymentFlow.OrderConfirmationPage;
import test.BasicSetupTest;

public class PaymentStepByStep extends BasicSetupTest {

    private Product product = new Product();
    private float amountProduct;

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

        Assert.assertEquals(page.getTextConfirmOderComplete(), "Your order on My Store is complete.");
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

        Assert.assertEquals(page.getTextConfirmOderComplete(), "Your order on My Store is complete.");
    }

    @Test
    public void PaymentRandomQuantityVerifyAmount() {
        AddedToCartPopup popup =
                homePage
                        .clickItemAndGoToProductPage()
                        .addQuantityAndClickCartButton();

        amountProduct = product.getQuantity() * product.getValue();
        Assert.assertEquals(amountProduct, popup.getValueTotalProductValue());
        Assert.assertEquals(amountProduct + popup.getValueShipping(), popup.getTotalValue());
        Assert.assertEquals(amountProduct, popup.getTotalValueLayerCart());
        Assert.assertEquals(product.getQuantity(), popup.getQuantityValueLayerCart());
    }
}
