package com.telran.oscarOldVersion.tests.user;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscarOldVersion.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(wd).clickOnLoginButton();
    }

    @Test
    public void userRegistrationTest() {
        new LoginAndRegistrationPage(wd).userRegistration(LoginPasswordData.USER_LOGIN1,LoginPasswordData.USER_PASSWORD1);
        Assert.assertTrue(new HomePage(wd).isAccountCreated());
    }

    @AfterMethod(enabled = true)
    public void tierDown () {
        new HomePage(wd).clickOnOscarLink().deleteUserOldVersion(LoginPasswordData.USER_PASSWORD1);
    }

}
