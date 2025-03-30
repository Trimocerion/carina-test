package com.zebrunner.carina.demo.gui.utils;

import com.zebrunner.carina.demo.gui.pages.sauceDemo.InventoryPage;
import com.zebrunner.carina.demo.gui.pages.sauceDemo.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginUtils {
    public static void login(WebDriver driver, String username, String password){
        System.out.println("Logging in with username: " + username + " and password: " + password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, password);
    }

    public static void logout(WebDriver driver){
        System.out.println("Logging out");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logout();
    }

}