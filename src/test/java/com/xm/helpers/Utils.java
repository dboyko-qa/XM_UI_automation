package com.xm.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Utils {


    private static void addCookies(String cookieName, String cookiesValue){
        Cookie authCookie = new Cookie(cookieName, cookiesValue);
        getWebDriver().manage().addCookie(authCookie);
    }

    @Step("Accept cookies")
    public static void acceptCookies(){
        open("/privacy-policy");
        addCookies("xmck_popupShown", "1");
        addCookies("xmck_preferences", "1");
        addCookies("xmck_analytical", "1");
        addCookies("xmck_functional", "1");
        addCookies("xmck_promotional", "1");
    }

    @Step("Remove sticky bars on top and bottom of the site")
    public static void removeStickyBars(){
        executeJavaScript("$('.sticky-bar').remove()");
        executeJavaScript("$('#risk-block').remove()");
        executeJavaScript("$('#cookies-block').remove()");
    }
}
