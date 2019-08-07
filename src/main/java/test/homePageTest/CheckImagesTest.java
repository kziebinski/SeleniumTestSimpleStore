package test.homePageTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BasicSetupTest;

import java.io.IOException;
import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

public class CheckImagesTest extends BasicSetupTest {

    private final Logger log = LogManager.getLogger(BasicSetupTest.class.getName());

    @Test
    public void checkImagesExist() throws IOException {
        ArrayList<String> tempList =
                homePage
                        .calculatelistImages();

        for (int i = 0; i < tempList.size(); i++) {
            if (tempList.get(i).substring(0, 3).equalsIgnoreCase("200")) {
                continue;
            } else {
                log.error("Broken img: " + tempList.get(i).substring(4, tempList.get(i).length()));
                Assert.fail();
            }
        }
        assertTrue(true);
    }
}
