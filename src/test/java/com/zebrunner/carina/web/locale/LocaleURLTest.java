package com.zebrunner.carina.web.locale;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.LocaleDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.Locale;

public class LocaleURLTest implements IAbstractTest {

    private static final Logger log = Logger.getLogger(LocaleURLTest.class);
    WebDriver driver = getDriver();


    @Test(dataProvider = "wikipediaLocales", dataProviderClass = LocaleDataProvider.class)
    public void testWikipediaLocale(Locale locale) {
        log.info("Testing Wikipedia locale: " + locale.getLanguage());

        String url = "https://" + locale.getLanguage() + ".wikipedia.org";

        driver.get(url);

        String expectedURL = "https://" + locale.getLanguage() + ".wikipedia.org/";
        String actualURL = driver.getCurrentUrl();

        log.info("Expected url: " + expectedURL);
        log.info("Actual url: " + actualURL);
        log.info(locale.getLanguage());

        Assert.assertTrue(actualURL.contains(locale.getLanguage()),
                "Wrong Wikipedia page loaded for language: " + locale.getLanguage());

        log.info("Test passed for locale: " + locale.getLanguage());
    }

}
