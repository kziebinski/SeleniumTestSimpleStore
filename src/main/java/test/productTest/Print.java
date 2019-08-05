package test.productTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.subpages.PrintPage;
import pages.subpages.ProductPage;
import test.BasicSetupTest;

public class Print extends BasicSetupTest {

    @Test
    public void printProduct() {
        PrintPage page =
                homePage
                        .goToAuthenticationPage()
                        .properLoginAndGoToMyAccountPage()
                        .clickLogoImageAndGoToHomePage()
                        .clickItemAndGoToProductPage()
                        .clickPrintButton();

        Assert.assertEquals("chrome://print/", page.getCurrentlyUrl());
    }

    @Test
    public void printProductWithoutLogin() {
        PrintPage page =
                homePage
                        .clickItemAndGoToProductPage()
                        .clickPrintButton();

        Assert.assertEquals("chrome://print/", page.getCurrentlyUrl());
    }
}
