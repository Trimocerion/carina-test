package com.zebrunner.carina.demo.gui.pages.sauceDemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

public class LoginPage extends AbstractPage {

    public static final Logger log = Logger.getLogger(LoginPage.class);

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private ExtendedWebElement usernameInput;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
