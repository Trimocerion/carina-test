package com.zebrunner.carina.demo.mobile.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends AbstractPage {

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement product;


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    public void selectProduct(String productName) {
        product.format(productName).click();
    }
}