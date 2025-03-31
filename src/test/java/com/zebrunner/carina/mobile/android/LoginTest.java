package com.zebrunner.carina.mobile.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.LoginDataProvider;
import com.zebrunner.carina.demo.mobile.android.LoginPage;
import com.zebrunner.carina.demo.mobile.android.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {


    @Test(dataProvider = "loginCredentials", dataProviderClass = LoginDataProvider.class)
    public void testSuccessfulLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickLoginButton();

        if (username.equals("wrong_username")) {
            Assert.assertTrue(productsPage.isPageOpened(), "Invalid user should not log in!");
        } else if (username.equals("locked_out_user")) {
            Assert.assertFalse(productsPage.isPageOpened(), "Locked out user should not log in!");
        } else {
            Assert.assertTrue(productsPage.isPageOpened(), "User should log in successfully!");
        }
    }

    @Test
    public void testProductsPageIsOpenedAfterLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(getDriver());
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login");
    }




}
