package test.payment;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.paymentFlow.OrderConfirmationPage;
import test.BasicSetupTest;

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

        Assert.assertEquals(page.getTextConfirmOderComplete(), "Your order on My Store is complete.");
    }

    @Test
    public void PaymentRandomItemNotLogin() throws InterruptedException {
        homePage
                .clickRandomImageAndGoToProductPage();
    }
}
