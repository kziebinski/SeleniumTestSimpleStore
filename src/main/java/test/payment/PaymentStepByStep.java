package test.payment;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.paymentFlow.OrderConfirmationPage;
import test.BasicSetupTest;

public class PaymentStepByStep extends BasicSetupTest {

    @Test
    public void PaymentBuyItemNotLogin() throws InterruptedException {

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
}
