package com.zebrunner.carina.dataprovider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name = "loginCredentials")
    public static Object[][] getLoginCredentials() {
        return new Object[][] {
                {"standard_user", "secret_sauce", "inventory.html"},
                {"locked_out_user", "secret_sauce", "https://www.saucedemo.com/"},
                {"wrong_username", "secret_sauce", "https://www.saucedemo.com/"}
        };
    }
}

