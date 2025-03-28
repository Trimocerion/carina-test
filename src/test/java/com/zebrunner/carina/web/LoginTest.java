package com.zebrunner.carina.web;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import static com.zebrunner.carina.demo.gui.utils.LoginUtilities.login;

public class LoginTest implements IAbstractTest {

    private static final Logger log = Logger.getLogger(LoginTest.class);
    private final WebDriver driver = getDriver();

    @Test
    public void testSuccessfulLogin() {
        log.info("testSuccessfulLogin: start");
        login(driver,"standard_user","secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        log.info("testSuccessfulLogin: success");
    }

    @Test
    public void testBlockedUserLogin(){
        log.info("testBlockedUserLogin: start");
        login(driver,"locked_out_user","secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        log.info("testBlockedUserLogin: success");
    }

    @Test
    public void testFailedLogin() {
        log.info("testFailedLogin: start");
        login(driver,"wrong_username","secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        log.info("testFailedLogin: success");
    }



}
