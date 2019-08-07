package test.homePageTest;

import org.testng.annotations.Test;
import test.BasicSetupTest;

import static org.testng.AssertJUnit.assertEquals;

public class FailTest extends BasicSetupTest {

    @Test
    public void FailScreenshotTest() {
                homePage
                        .goToAuthenticationPage();

        assertEquals(false,true);
    }
}
