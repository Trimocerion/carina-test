package com.zebrunner.carina.demo.gui.pages.sauceDemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends AbstractPage {

    private static final Logger log = Logger.getLogger(InventoryPage.class);

    @FindBy(id = "react-burger-menu-btn")
    private ExtendedWebElement burgerMenu;

    @FindBy(id = "inventory_sidebar_link")
    private ExtendedWebElement allItemsButton;

    @FindBy(id = "shopping_cart_container")
    private ExtendedWebElement cartButton;

    @FindBy(id = "logout_sidebar_link")
    private ExtendedWebElement logoutButton;

    @FindBy(className = "inventory_item")
    private List<ExtendedWebElement> itemList;

    @FindBy(className = "inventory_item_name")
    private List<ExtendedWebElement> itemNames;

    @FindBy(className = "inventory_item_price")
    private List<ExtendedWebElement> itemPrices;

    @FindBy(className = "btn_inventory")
    private List<ExtendedWebElement> addToCartButtons;

    @FindBy(className = "product_sort_container")
    private ExtendedWebElement sortDropdown;



    public InventoryPage(WebDriver driver) {
        super(driver);
    }


    public void logout(){
        log.info("Logging out");
        openBurgerMenu();
        logoutButton.isElementPresent();
        logoutButton.click();
    }

    public void openCart() {
        log.info("Opening cart");
        cartButton.click();
    }

    public void openBurgerMenu() {
        burgerMenu.click();
        log.info("opened burger menu");
    }


    public void addProductToCart(String productName) {
        log.info("Adding product to cart: " + productName);
        for (int i = 0; i < itemNames.size(); i++) {
            if (itemNames.get(i).getText().contains(productName)) {
                if (i < addToCartButtons.size()) {
                    addToCartButtons.get(i).click();
                    log.info("Product added to the cart: " + productName);
                    return;
                } else {
                    log.error("Index out of bounds while adding product: " + productName);
                    throw new IndexOutOfBoundsException("No matching add button for index: " + i);
                }
            }
        }
        log.warn("Product not found: " + productName);
    }

    public List<String> getSortOptions(){
        log.info("Getting sort options");
        Select select = new Select(sortDropdown.getElement());
        return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }


    public void sortItemsBy(int index) {
        log.info("Sorting items by index: " + index);




    }
}
