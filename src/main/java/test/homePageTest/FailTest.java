package test.homePageTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BasicSetupTest;

public class FailTest extends BasicSetupTest {

    @Test
    public void FailScreenshotTest() {
                homePage
                        .goToAuthenticationPage();

        Assert.assertEquals(false,true);
    }
}
