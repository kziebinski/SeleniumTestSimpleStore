package test.homePageTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.socialMediaPage.FacebookPage;
import test.BasicSetupTest;

public class RedirectionToSocialMedia extends BasicSetupTest {

    @Test
    public void goToFacebookPage() {

        FacebookPage page =
                homePage
                        .goToFacebookPage();

        Assert.assertEquals(page.facebookPageText(), "Facebook");
        Assert.assertEquals(page.urlFacebookPage(), "https://www.facebook.com/groups/525066904174158/");
    }
}
