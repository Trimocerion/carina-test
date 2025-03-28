package com.zebrunner.carina.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.sauceDemo.CartPage;
import com.zebrunner.carina.demo.gui.pages.sauceDemo.CheckoutPage;
import com.zebrunner.carina.demo.gui.pages.sauceDemo.InventoryPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import static com.zebrunner.carina.demo.gui.utils.LoginUtilities.login;

public class CheckoutTest implements IAbstractTest {

    private static final Logger log = Logger.getLogger(CheckoutTest.class);
    private final WebDriver driver = getDriver();

    @Test
    public void testCheckoutProcedure(){
        log.info("testCheckoutProcedure: start");

        login(driver,"standard_user","secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.isItemInCart("Sauce Labs Bike Light");
        cartPage.isItemInCart("Sauce Labs Backpack");
        cartPage.clickCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutDetails("John", "Wick", "12345");
        checkoutPage.continueToOverview();

        Assert.assertTrue(checkoutPage.isItemInCheckout("Sauce Labs Backpack"), "Product should be in the checkout");
        Assert.assertTrue(checkoutPage.isItemInCheckout("Sauce Labs Bike Light"), "Product should be in the checkout");

        checkoutPage.completeCheckout();

        Assert.assertEquals(
                checkoutPage.getCheckoutCompleteMessage(),
                "Thank you for your order! Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}
