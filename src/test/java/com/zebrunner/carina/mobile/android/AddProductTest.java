package com.zebrunner.carina.mobile.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.mobile.android.LoginPage;
import com.zebrunner.carina.demo.mobile.android.ProductDetailsPage;
import com.zebrunner.carina.demo.mobile.android.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddProductTest implements IAbstractTest {

    @Test()
    public void testAddProductToCart() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.selectProduct("Sauce Labs Backpack");
        ProductDetailsPage detailsPage = new ProductDetailsPage(getDriver());
        detailsPage.addToCart();
        Assert.assertTrue(detailsPage.isProductAddedToCart(), "Product was not added to cart");
    }

    @Test
    public void testAddMultipleProducts(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.selectProduct("Sauce Labs Backpack");
        ProductDetailsPage detailsPage = new ProductDetailsPage(getDriver());
        detailsPage.addToCart();
        Assert.assertTrue(detailsPage.isProductAddedToCart(), "Product was not added to cart");

    }


    @Test
    public void testAddSecondProductToCart() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.selectProduct("Sauce Labs Bike Light");
        ProductDetailsPage detailsPage = new ProductDetailsPage(getDriver());
        detailsPage.addToCart();
        Assert.assertTrue(detailsPage.isProductAddedToCart(), "Product was not added to cart");
    }

    @Test
    public void testAddThirdProductToCart() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.selectProduct("Sauce Labs Bolt T-Shirt");
        ProductDetailsPage detailsPage = new ProductDetailsPage(getDriver());
        detailsPage.addToCart();
        Assert.assertTrue(detailsPage.isProductAddedToCart(), "Product was not added to cart");
    }

}