package com.zebrunner.carina.mobile.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.mobile.android.LoginPage;
import com.zebrunner.carina.demo.mobile.android.MenuPage;
import com.zebrunner.carina.demo.mobile.android.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest implements IAbstractTest {


    @Test
    public void testUserCanLogout() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(getDriver());
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.selectLogoutOption();
        Assert.assertTrue(loginPage.isPageOpened(), "User is not redirected to login page after logout");
    }

}
