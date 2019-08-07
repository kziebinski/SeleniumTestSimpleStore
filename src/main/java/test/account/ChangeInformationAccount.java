package test.account;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.subpages.MyAccountPage;
import test.BasicSetupTest;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ChangeInformationAccount extends BasicSetupTest {

    @Test
    public void changeEmailAndPasswordThenLoginWithNewCredential() throws IOException {
        MyAccountPage page =
                homePage
                        .goToAuthenticationPage()
                        .properLoginWithTemperaryEmailAndLogin()
                        .clickMyPersonalInfromationButtonAndGoToPersonalInformationPage()
                        .fillNewEmailAndNewPasswordThenSave()
                        .clickSignOutButton()
                        .properLoginWithRandomGenerateEmailAndLogin();

        assertEquals(page.myAccountText(), "MY ACCOUNT");
        assertEquals(page.myAccountNameText(), "Konrad Ziebinski");
    }

    //TODO_needRefactor
    @AfterTest
    public void backToTempEmailAndTempPassword() throws IOException {
            homePage
                    .goToAuthenticationPage()
                    .properLoginWithRandomGenerateEmailAndLogin()
                    .clickMyPersonalInfromationButtonAndGoToPersonalInformationPage()
                    .fillNewEmailAndNewPasswordThenSave()
                    .fillNTempEmailAndTempPasswordThenSave();
    }
}
