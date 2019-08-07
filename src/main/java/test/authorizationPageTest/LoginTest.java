package test.authorizationPageTest;

import org.testng.annotations.Test;
import pages.subpages.AuthenticationPage;
import pages.subpages.MyAccountPage;
import test.BasicSetupTest;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BasicSetupTest {

    @Test
    public void loginInvalidPassword() {
        final AuthenticationPage authenticationPage =
                homePage
                        .goToAuthenticationPage()
                        .complementEmailPasswordAndClickConfirm("1@gmail.com", "1");

        assertEquals(authenticationPage.checkDisplayInvalidErrorText(), "Invalid password.");
    }

    @Test
    public void loginInvalidEmail() {
        final AuthenticationPage authenticationPage =
                homePage
                        .goToAuthenticationPage()
                        .complementEmailPasswordAndClickConfirm(" ", "password");

        assertEquals(authenticationPage.checkDisplayInvalidErrorText(), "An email address required.");
    }

    @Test
    public void loginCorrect() {
        final MyAccountPage myAccountPage =
                homePage
                        .goToAuthenticationPage()
                        .properLoginAndGoToMyAccountPage();

        assertEquals(myAccountPage.myAccountText(), "MY ACCOUNT");
        assertEquals(myAccountPage.myAccountNameText(), "Konrad Ziebinski");

    }
}
