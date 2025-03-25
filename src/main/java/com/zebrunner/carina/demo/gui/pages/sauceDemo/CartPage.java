package com.zebrunner.carina.demo.gui.pages.sauceDemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

public class CartPage extends AbstractPage {

    private static final Logger log = Logger.getLogger(CartPage.class);

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    private ExtendedWebElement sortDropdown;



    public CartPage(WebDriver driver) {
        super(driver);
    }
}
