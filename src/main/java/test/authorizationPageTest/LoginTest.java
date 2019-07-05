package test.authorizationPageTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.MyAccountPage;
import test.BasicSetupTest;

public class LoginTest extends BasicSetupTest {

    @Test
    public void loginInvalidPassword() {
        final AuthenticationPage authenticationPage =
                homePage
                        .goToAuthenticationPage()
                        .complementEmailPasswordAndClickConfirm("1@gmail.com", "1");

        Assert.assertEquals(authenticationPage.checkDisplayInvalidErrorText(), "Invalid password.");
    }

    @Test
    public void loginInvalidEmail() {
        final AuthenticationPage authenticationPage =
                homePage
                        .goToAuthenticationPage()
                        .complementEmailPasswordAndClickConfirm(" ", "password");

        Assert.assertEquals(authenticationPage.checkDisplayInvalidErrorText(), "An email address required.");
    }

    @Test
    public void loginCorrect() {
        final MyAccountPage myAccountPage =
                homePage
                        .goToAuthenticationPage()
                        .properLoginAndGoToMyAccountPage();

        Assert.assertEquals(myAccountPage.myAccountText(), "MY ACCOUNT");
        Assert.assertEquals(myAccountPage.myAccountNameText(), "Konrad Ziebinski");

    }
}
