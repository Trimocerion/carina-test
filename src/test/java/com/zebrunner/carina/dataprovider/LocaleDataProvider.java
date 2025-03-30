package com.zebrunner.carina.dataprovider;

import net.bytebuddy.asm.Advice;
import org.testng.annotations.DataProvider;

import java.util.Locale;

public class LocaleDataProvider {

    @DataProvider(name = "wikipediaLocales")
    public static Object[][] getWikipediaLocales(){
        return new Object[][]{
                {Locale.ENGLISH},
                {Locale.CHINESE},
                {Locale.JAPAN},
                {Locale.KOREAN},
                {Locale.GERMAN},
                {Locale.FRENCH},
                {new Locale("pl")},
                {new Locale("ru")},
                {new Locale("es")},
                {new Locale("it")},
                {new Locale("pt")},
        };
    }
}
