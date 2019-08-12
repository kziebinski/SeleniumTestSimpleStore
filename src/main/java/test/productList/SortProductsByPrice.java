package test.productList;

import org.testng.annotations.Test;
import pages.subpages.BestSellersPage;
import test.BasicSetupTest;

import java.util.Collections;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class SortProductsByPrice extends BasicSetupTest {

    @Test
    public void sortProductsByHighestPrice() {
        BestSellersPage page =
                homePage
                        .clickAndGoToBestSellersPage()
                        .clickSortHighestPrice();

        List<Float> tempList = (List<Float>) page.getListNotSort();
        tempList.sort(Collections.reverseOrder());
        assertEquals(tempList, page.getListAfterSort());

    }

    //Test fail - bug on page
    @Test
    public void sortProductsBuLowestPrice() {
        BestSellersPage page =
                homePage
                        .clickAndGoToBestSellersPage()
                        .clickSortLowestPrice();

        Collections.sort((List<Float>) page.getListNotSort());
        assertEquals(page.getListNotSort(), page.getListAfterSort());
    }
}
