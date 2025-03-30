package com.zebrunner.carina.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.LoginDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import static com.zebrunner.carina.demo.gui.utils.LoginUtils.login;

public class LoginTest implements IAbstractTest {

    private static final Logger log = Logger.getLogger(LoginTest.class);
    private WebDriver driver = getDriver();



    @Test
    public void testLogin(String username, String password) {


        login(driver, username, password);
        boolean isLoginSuccessful = driver.getCurrentUrl().contains("inventory.html");

        if (username.equals("invalid_user")) {
            Assert.assertFalse(isLoginSuccessful, "Invalid user should not log in!");
        } else {
            Assert.assertTrue(isLoginSuccessful, "User should log in successfully!");
        }
    }
}
