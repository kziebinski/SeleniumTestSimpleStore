package test.homePageTest;

import org.testng.annotations.Test;
import pages.socialMediaPage.FacebookPage;
import pages.socialMediaPage.TwitterPage;
import test.BasicSetupTest;

import static org.testng.AssertJUnit.assertEquals;

public class RedirectionToSocialMedia extends BasicSetupTest {

    @Test
    public void goToFacebookPage() {

        FacebookPage page =
                homePage
                        .goToFacebookPage();

        assertEquals(page.facebookPageText(), "Facebook");
        assertEquals(page.urlFacebookPage(), "https://www.facebook.com/groups/525066904174158/");
    }

    @Test
    public void goTOTwitterPage() {
        TwitterPage page =
                homePage
                        .goToTwitterPage();
        assertEquals(page.twitterNameProfileText(), "Selenium Framework");
        assertEquals(page.urlTwitterPage(), "https://twitter.com/seleniumfrmwrk");
    }
}
