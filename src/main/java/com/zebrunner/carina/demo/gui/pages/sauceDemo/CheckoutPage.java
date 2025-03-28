package com.zebrunner.carina.demo.gui.pages.sauceDemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

import java.util.List;

public class CheckoutPage extends AbstractPage {

    private static final Logger log = Logger.getLogger(CheckoutPage.class);
    private final WebDriver driver = getDriver();

    @FindBy(id = "first-name")
    private ExtendedWebElement firstNameField;

    @FindBy(id = "last-name")
    private ExtendedWebElement lastNameField;

    @FindBy(id = "postal-code")
    private ExtendedWebElement postalCodeField;

    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    @FindBy(id = "cancel")
    private ExtendedWebElement cancelButton;

    @FindBy(className = "cart_item")
    private List<ExtendedWebElement> cartItems;

    @FindBy(className = "inventory_item_name")
    private List<ExtendedWebElement> itemNames;

    @FindBy(xpath = "//button[contains(text(), 'Remove')]")
    private List<ExtendedWebElement> removeButtons;

    @FindBy(id = "finish")
    private ExtendedWebElement finishButton;

    @FindBy(className = "complete-header")
    private ExtendedWebElement completeHeader;

    @FindBy(className = "complete-text")
    private ExtendedWebElement completeText;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
        log.info("Entering checkout details: " + firstName + " " + lastName + ", " + postalCode);
        firstNameField.type(firstName);
        lastNameField.type(lastName);
        postalCodeField.type(postalCode);
    }

    public void removeCheckoutDetails() {
        log.info("Removing checkout details");
        firstNameField.clear();
        lastNameField.clear();
        postalCodeField.clear();
    }

    public void removeProductFromCart(String productName) {
        log.info("Attempting to remove product from cart: " + productName);
        for (int i = 0; i < itemNames.size(); i++) {
            if (itemNames.get(i).getText().equalsIgnoreCase(productName)) {
                removeButtons.get(i).click();
                log.info("Removed product from cart: " + productName);
                return;
            }
        }
        log.warn("Product not found in cart: " + productName);
    }

    public boolean isProductInCart(String productName) {
        for (ExtendedWebElement item : itemNames) {
            if (item.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }


    public boolean isItemInCheckout(String itemName) {
        return cartItems.stream().anyMatch(item -> item.getText().contains(itemName));
    }

    public void continueToOverview() {
        log.info("Continuing to checkout overview");
        continueButton.click();
    }

    public void completeCheckout() {
        log.info("Completing checkout process");
        finishButton.click();
    }

    public void cancelCheckout() {
        log.info("Cancelling checkout process");
        cancelButton.click();
    }

    public String getCheckoutCompleteMessage() {
        return completeHeader.getText() + " " + completeText.getText();
    }
}
