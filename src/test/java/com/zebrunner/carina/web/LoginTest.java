package com.zebrunner.carina.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.LoginDataProvider;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.EdgeCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import static com.zebrunner.carina.demo.gui.utils.LoginUtils.login;

public class LoginTest implements IAbstractTest {

    private static final Logger log = Logger.getLogger(LoginTest.class);
    private WebDriver driver;


    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("MicrosoftEdge") String browser) {
        log.info("Initializing driver for browser: " + browser);

        if (browser.equals("chrome")) {
            driver = getDriver(browser, new ChromeCapabilities().getCapability("Chrome"));
        } else {
            driver = getDriver(browser, new EdgeCapabilities().getCapability("Edge"));
        }

    }

    @Test(dataProvider = "loginCredentials", dataProviderClass = LoginDataProvider.class)
    public void testLogin(String username, String password) {
        log.info("Running login test with username: " + username);

        login(driver, username, password);
        boolean isLoginSuccessful = driver.getCurrentUrl().contains("inventory.html");

        if (username.equals("wrong_username")) {
            Assert.assertFalse(isLoginSuccessful, "Invalid user should not log in!");
        } else if (username.equals("locked_out_user")) {
            Assert.assertFalse(isLoginSuccessful, "Locked out user should not log in!");
        } else {
            Assert.assertTrue(isLoginSuccessful, "User should log in successfully!");
        }
    }
}
