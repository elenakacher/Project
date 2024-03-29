package com.telran.oscarOldVersion.tests.products;

import com.telran.oscar.data.LoginPasswordData;
import com.telran.oscar.pages.*;
import com.telran.oscar.pages.Basket.BasketPage;
import com.telran.oscar.pages.product.AllProductsPage;
import com.telran.oscar.pages.user.LoginAndRegistrationPage;
import com.telran.oscarOldVersion.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllProductsTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(wd).clickOnLoginButton();
        new LoginAndRegistrationPage(wd).userRegistrationWithoutConcat(LoginPasswordData.USER_LOGIN1, LoginPasswordData.USER_PASSWORD1);
        new HomePage(wd).clickOnAllProductsButton();
    }

    @Test
    public void addToBasketTest() {
        new AllProductsPage(wd).addToBasketOldVersion();
        new HomePage(wd).clickOnViewBasketButton();
        Assert.assertTrue(new BasketPage(wd).getBookTitel().contains("The shellcoder's handbook"));
    }

    @AfterMethod
    public void tierDown(){
        new HomePage(wd).clickOnOscarLink().deleteUserOldVersion(LoginPasswordData.USER_PASSWORD1);
    }
}
