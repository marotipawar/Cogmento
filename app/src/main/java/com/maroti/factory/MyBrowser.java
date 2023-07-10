package com.maroti.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface MyBrowser {

    WebDriver getDriver();

    String getTitle();

    String getCurrentUrl();

    void javaScriptClick(WebElement element);

    void javaScriptSendKeys(WebElement element, String value);

    void actionClick(WebElement element);

    void actionSendKey(WebElement element, String value);

    void implicitlyWait();

    WebDriverWait explicitWait();


}
