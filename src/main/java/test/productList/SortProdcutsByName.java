package test.productList;

import org.testng.annotations.Test;
import pages.subpages.BestSellersPage;
import test.BasicSetupTest;

import java.util.Collections;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class SortProdcutsByName extends BasicSetupTest {

    @Test
    public void sortProductsByNameA_Z() {
        BestSellersPage page =
                homePage
                        .clickAndGoToBestSellersPage()
                        .clickSortNameA_Z();

        Collections.sort((List<String>) page.getListNotSort());
        assertEquals(page.getListNotSort(), page.getListAfterSort());
    }
}
