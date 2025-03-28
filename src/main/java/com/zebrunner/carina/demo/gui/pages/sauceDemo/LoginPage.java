package com.zebrunner.carina.demo.gui.pages.sauceDemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

public class LoginPage extends AbstractPage {

    public static final Logger log = Logger.getLogger(LoginPage.class);

    @FindBy(id = "user-name")
    private ExtendedWebElement usernameInput;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    @FindBy(css = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    private void typeUsername(String username) {
        usernameInput.type(username);
        log.info("entered username");
    }
    private void typePassword(String password) {
        passwordInput.type(password);
        log.info("entered password");
    }
    private void clickLoginButton() {
        loginButton.click();
        log.info("clicked login button");
    }

    public void login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickLoginButton();
    }


}
