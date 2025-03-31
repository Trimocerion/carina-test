package com.zebrunner.carina.demo.mobile.ios;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductDetailsPage extends AbstractPage {

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='productName']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='productDescription']")
    private ExtendedWebElement productDescription;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='productPrice']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='addToCartButton']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='removeFromCartButton']")
    private ExtendedWebElement removeFromCartButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductDescription() {
        return productDescription.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void removeFromCart() {
        removeFromCartButton.click();
    }

    public boolean isAddToCartButtonVisible() {
        return addToCartButton.isElementPresent();
    }

    public boolean isRemoveFromCartButtonVisible() {
        return removeFromCartButton.isElementPresent();
    }

    public void verifyProductDetails(String expectedName, String expectedPrice) {
        Assert.assertEquals(getProductName(), expectedName, "Product name doesn't match");
        Assert.assertEquals(getProductPrice(), expectedPrice, "Product price doesn't match");
    }

    public boolean isProductAddedToCart() {
        return removeFromCartButton.isElementPresent();
    }
}