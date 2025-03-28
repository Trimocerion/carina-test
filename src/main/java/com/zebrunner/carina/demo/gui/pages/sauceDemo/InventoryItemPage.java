package com.zebrunner.carina.demo.gui.pages.sauceDemo;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

public class InventoryItemPage extends AbstractPage {

    private static final Logger log = Logger.getLogger(InventoryItemPage.class);



    public InventoryItemPage(WebDriver driver) {
        super(driver);
    }
}
