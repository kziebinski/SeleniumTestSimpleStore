package test.productList;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.subpages.BestSellersPage;
import test.BasicSetupTest;

import java.util.Collections;

public class SortProdcutsByName extends BasicSetupTest {

    @Test
    public void sortProductsByNameA_Z(){
        BestSellersPage page =
                homePage
                .clickAndGoToBestSellersPage()
                .clickSortNameA_Z();

        Collections.sort(page.getListNameNotSort());
        Assert.assertEquals(page.getListNameNotSort(), page.getListSortByNameA_Z());
    }
}
