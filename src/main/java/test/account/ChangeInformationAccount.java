package test.account;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.subpages.MyAccountPage;
import test.BasicSetupTest;

public class ChangeInformationAccount extends BasicSetupTest {

    @Test
    public void changeEmailAndPasswordThenLoginWithNewCredential() {

        MyAccountPage page =
                homePage
                        .goToAuthenticationPage()
                        .properLoginWithTemperaryEmailAndLogin()
                        .clickMyPersonalInfromationButtonAndGoToPersonalInformationPage()
                        .fillNewEmailAndNewPasswordThenSave()
                        .clickSignOutButton()
                        .properLoginWithRandomGenerateEmailAndLogin();

        Assert.assertEquals(page.myAccountText(), "MY ACCOUNT");
        Assert.assertEquals(page.myAccountNameText(), "Konrad Ziebinski");
    }

    //needRefactor
    @AfterTest
    public void backToTempEmailAndTempPassword() {
        homePage
                .goToAuthenticationPage()
                .properLoginWithRandomGenerateEmailAndLogin()
                .clickMyPersonalInfromationButtonAndGoToPersonalInformationPage()
                .fillNewEmailAndNewPasswordThenSave()
                .fillNTempEmailAndTempPasswordThenSave();
    }
}
