package test.compareProductTest;

import org.testng.annotations.Test;
import pages.subpages.CompareProductPage;
import test.BasicSetupTest;

import static org.testng.AssertJUnit.assertEquals;

public class CompareProduct extends BasicSetupTest {

    @Test
    public void addToCompareRandomProduct() {
        CompareProductPage page =
                homePage
                        .clickAndGoToBestSellersPage()
                        .addProductToCompare()
                        .clickAndGoToCompareProductPage();

        assertEquals(page.getSelectedProduct().getName(), page.getCurrentProductName());
        assertEquals(new Float(page.getSelectedProduct().getValue()), page.getCurrentProductValue());

    }

    @Test
    public void deleteCompareProduct() {

        CompareProductPage page =
                homePage
                        .clickAndGoToBestSellersPage()
                        .addProductToCompare()
                        .clickAndGoToCompareProductPage()
                        .clickDeleteCompareProduct();

        assertEquals(new Integer(1), page.getProdcutComparison());
    }
}
