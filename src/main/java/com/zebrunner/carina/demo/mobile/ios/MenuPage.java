package com.zebrunner.carina.demo.mobile.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends AbstractPage {

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='LOGOUT']")
    private ExtendedWebElement logoutOption;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='ALL ITEMS']")
    private ExtendedWebElement allItemsOption;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMenuOpened() {
        return logoutOption.isElementPresent() && allItemsOption.isElementPresent();
    }

    public LoginPage selectLogoutOption() {
        logoutOption.click();
        return new LoginPage(driver);
    }
}