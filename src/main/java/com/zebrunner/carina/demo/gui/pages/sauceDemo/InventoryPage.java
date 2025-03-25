package com.zebrunner.carina.demo.gui.pages.sauceDemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

public class InventoryPage extends AbstractPage {

    private static final Logger log = Logger.getLogger(InventoryPage.class);

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private ExtendedWebElement burgerMenu;

    @FindBy(xpath = "//*[@id=\"inventory_sidebar_link\"]")
    private ExtendedWebElement allItemsButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private ExtendedWebElement logoutButton;


    public InventoryPage(WebDriver driver) {
        super(driver);
    }
}
