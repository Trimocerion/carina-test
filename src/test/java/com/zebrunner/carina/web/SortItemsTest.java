package com.zebrunner.carina.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.sauceDemo.InventoryPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.List;

import static com.zebrunner.carina.demo.gui.utils.LoginUtils.login;

public class SortItemsTest implements IAbstractTest {

    private static final Logger log = Logger.getLogger(SortItemsTest.class);
    private final WebDriver driver = getDriver();


    @Test
    public void testAvailableSortOptions(){
        log.info("testAvailableSortOptions: start");
        login(driver,"standard_user","secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver);
        List<String> options = inventoryPage.getSortOptions();
        log.info("sort options: " + inventoryPage.getSortOptions());
        List<String> expectedOptions = List.of(
                "Name (A to Z)",
                "Name (Z to A)",
                "Price (low to high)",
                "Price (high to low)"
        );
        Assert.assertEquals(options, expectedOptions, "Sorting options do not match expected values!");
        log.info("testAvailableSortOptions: success");
    }




}
