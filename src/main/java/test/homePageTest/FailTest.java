package test.homePageTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.subpages.AuthenticationPage;
import test.BasicSetupTest;

public class FailTest extends BasicSetupTest {

    @Test
    public void FailScreenshotTest() {
        AuthenticationPage page =
                homePage
                        .goToAuthenticationPage();

        Assert.assertEquals(false,true);
    }
}
