package com.zebrunner.carina.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.sauceDemo.CartPage;
import com.zebrunner.carina.demo.gui.pages.sauceDemo.InventoryPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import static com.zebrunner.carina.demo.gui.utils.LoginUtils.login;


public class AddProductTest implements IAbstractTest {

    private static final Logger log = Logger.getLogger(AddProductTest.class);
    private final WebDriver driver = getDriver();

    @Test
    public void testAddProductToCart() {
        log.info("testAddProductToCart: start");
        login(driver,"standard_user","secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.openCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Backpack"));;
        log.info("testAddProductToCart: success");
    }

    @Test
    public void testAddMultipleProducts(){
        log.info("testAddMultipleProducts: start");
        login(driver,"standard_user","secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");
        inventoryPage.openCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Backpack"));
        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Bike Light"));
        log.info("testAddMultipleProducts: success");
    }



}
