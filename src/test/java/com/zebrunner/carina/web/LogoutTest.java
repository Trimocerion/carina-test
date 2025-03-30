package com.zebrunner.carina.web;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import static com.zebrunner.carina.demo.gui.utils.LoginUtils.login;
import static com.zebrunner.carina.demo.gui.utils.LoginUtils.logout;

public class LogoutTest implements IAbstractTest {

    private static final Logger log = Logger.getLogger(LogoutTest.class);
    private final WebDriver driver = getDriver();

    @Test
    public void testLogout() {
        log.info("testLogout: start");
        login(driver,"standard_user","secret_sauce");
        logout(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));
        log.info("testLogout: success");
    }


}
