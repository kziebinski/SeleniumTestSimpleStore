package test.compareProductTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.subpages.CompareProductPage;
import test.BasicSetupTest;

public class CompareProduct extends BasicSetupTest {

    @Test
    public void addToCompareRandomProduct() {
        CompareProductPage page =
                homePage
                        .clickAndGoToBestSellersPage()
                        .addProductToCompare()
                        .clickAndGoToCompareProductPage();

        Assert.assertEquals(page.getSelectedProduct().getName(), page.getCurrentProductName());
        Assert.assertEquals(new Float(page.getSelectedProduct().getValue()), page.getCurrentProductValue());

    }
}
