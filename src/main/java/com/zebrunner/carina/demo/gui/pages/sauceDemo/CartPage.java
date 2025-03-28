package com.zebrunner.carina.demo.gui.pages.sauceDemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;
import java.util.List;

public class CartPage extends AbstractPage {

    private static final Logger log = Logger.getLogger(CartPage.class);

    @FindBy(id = "shopping_cart_container")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/div/span/select")
    private ExtendedWebElement sortDropdown;

    @FindBy(className = "cart_item")
    private List<ExtendedWebElement> cartItems;

    @FindBy(id = "checkout")
    private ExtendedWebElement checkoutButton;

    @FindBy(className = "cart_button")
    private List<ExtendedWebElement> removeButtons;

    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    @FindBy(id = "finish")
    private ExtendedWebElement finishButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isItemInCart(String itemName) {
        return cartItems.stream().anyMatch(item -> item.getText().contains(itemName));
    }


    public void clickCheckoutButton() {
        log.info("Checkout button clicked");
        checkoutButton.click();
    }
}
