package test.homePageTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.subpages.SearchPage;
import test.BasicSetupTest;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchItemTest extends BasicSetupTest {

    private final String searchTshirtText = "t-shirts";

    @Test
    public void searchItemTshirts() {
        SearchPage page =
                homePage
                        .fillSearchFieldAndSubmit(searchTshirtText);

        List<String> listItem = page.getListElement();

        for (int i = 0; i < listItem.size(); i++) {
            if(listItem.get(i).toLowerCase().contains(searchTshirtText)){
                continue;
            }else {
                Assert.fail();
            }
        }
        assertTrue(true);
    }
}
