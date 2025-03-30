package com.zebrunner.carina.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.sauceDemo.CheckoutPage;
import com.zebrunner.carina.demo.gui.pages.sauceDemo.InventoryPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import static com.zebrunner.carina.demo.gui.utils.LoginUtils.login;

public class RemoveProductTest implements IAbstractTest {

    private static final Logger log = Logger.getLogger(RemoveProductTest.class);
    private WebDriver driver = getDriver();

    @Test
    public void testRemoveProduct() {
        log.info("testRemoveProduct: start");

        login(driver,"standard_user","secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.openCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.removeProductFromCart("Sauce Labs Backpack");

        Assert.assertFalse(checkoutPage.isProductInCart("Sauce Labs Backpack"), "Product should be removed from the cart");

        log.info("testRemoveProduct: success");
    }

    @Test
    public void testRemoveManyProducts(){
        log.info("testRemoveManyProducts: start");

        login(driver,"standard_user","secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");
        inventoryPage.openCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.removeProductFromCart("Sauce Labs Backpack");
        checkoutPage.removeProductFromCart("Sauce Labs Bike Light");

        Assert.assertFalse(checkoutPage.isProductInCart("Sauce Labs Backpack"), "Product should be removed from the cart");
        Assert.assertFalse(checkoutPage.isProductInCart("Sauce Labs Bike Light"), "Product should be removed from the cart");

        log.info("testRemoveManyProducts: success");
    }


}
