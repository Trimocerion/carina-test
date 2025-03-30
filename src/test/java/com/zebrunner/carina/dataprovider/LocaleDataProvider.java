package com.zebrunner.carina.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.Locale;

public class LocaleDataProvider {

    @DataProvider(name = "wikipediaLocales")
    public static Object[][] getWikipediaLocales(){
        return new Object[][]{
                {Locale.ENGLISH},
                {Locale.GERMAN},
                {Locale.FRENCH},
                {new Locale("pl")}
        };
    }
}
