package com.zebrunner.carina.demo.mobile.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends AbstractPage {

    @FindBy(id = "usernameTextField")
    private ExtendedWebElement usernameField;

    @FindBy(id = "passwordTextField")
    private ExtendedWebElement passwordField;

    @FindBy(id = "loginButton")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeUsername(String username) {
        usernameField.type(username);
    }

    public void typePassword(String password) {
        passwordField.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickLoginButton();
    }
}