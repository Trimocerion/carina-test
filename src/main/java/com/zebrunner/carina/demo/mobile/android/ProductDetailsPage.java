package com.zebrunner.carina.demo.mobile.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductDetailsPage extends AbstractPage {

    @FindBy(id = "com.saucelabs.mobileapp:id/productName")
    private ExtendedWebElement productName;

    @FindBy(id = "com.saucelabs.mobileapp:id/productDescription")
    private ExtendedWebElement productDescription;

    @FindBy(id = "com.saucelabs.mobileapp:id/productPrice")
    private ExtendedWebElement productPrice;

    @FindBy(id = "com.saucelabs.mobileapp:id/addToCartButton")
    private ExtendedWebElement addToCartButton;

    @FindBy(id = "com.saucelabs.mobileapp:id/removeFromCartButton")
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
