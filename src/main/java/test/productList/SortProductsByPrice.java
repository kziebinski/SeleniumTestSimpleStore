package test.productList;

import org.testng.annotations.Test;
import pages.subpages.BestSellersPage;
import test.BasicSetupTest;

import java.util.Collections;

import static org.testng.AssertJUnit.assertEquals;

public class SortProductsByPrice extends BasicSetupTest {

    @Test
    public void sortProductsByHighestPrice() {
        BestSellersPage page =
                homePage
                        .clickAndGoToBestSellersPage()
                        .clickSortHighestPrice();

        page.getListPriceNotSort().sort(Collections.reverseOrder());
        assertEquals(page.getListPriceNotSort(), page.getListSortByHigherPrice());
    }

    //Test fail - bug on page
    @Test
    public void sortProductsBuLowestPrice() {
        BestSellersPage page =
                homePage
                        .clickAndGoToBestSellersPage()
                        .clickSortLowestPrice();

        Collections.sort(page.getListPriceNotSort());
        assertEquals(page.getListPriceNotSort(), page.getListSortByLowestPrice());
    }
}
