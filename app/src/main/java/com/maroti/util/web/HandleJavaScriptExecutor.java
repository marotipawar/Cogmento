package com.maroti.util.web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * @Author : Maroti Pawar
 *
 * */
public interface HandleJavaScriptExecutor {
    public static JavascriptExecutor getJavaScriptExecutorInstance(WebDriver driver) {
        return ((JavascriptExecutor) driver);
    }

    public static void javascript(WebDriver driver, String script, WebElement element) {
        getJavaScriptExecutorInstance(driver).executeScript(script, element);
    }

    public static void javaScriptClick(WebDriver driver, WebElement element) {
        getJavaScriptExecutorInstance(driver).executeScript("arguments[0].click();", element);
    }


    public static void javaScriptSendKeys(WebDriver driver, WebElement element, String value) {
        getJavaScriptExecutorInstance(driver).executeScript("arguments[0].value='" + value + "'", element);
    }

    public static void javaScriptAlert(WebDriver driver, String alertText) {
        getJavaScriptExecutorInstance(driver).executeScript("alert(" + alertText + ");");
    }

    public static String javaScriptGetText(WebDriver driver, WebElement element) {
        return getJavaScriptExecutorInstance(driver).executeScript("arguments[0].textContent;", element).toString();
    }

    public static String javaScriptGetDocumentTitle(WebDriver driver) {
        return getJavaScriptExecutorInstance(driver).executeScript("return document.title;").toString();
    }

    public static String javaScriptGetUrl(WebDriver driver) {
        return getJavaScriptExecutorInstance(driver).executeScript("return document.URL;").toString();
    }


    public static void javaScriptScrollBy(WebDriver driver, int h, int v) {
        getJavaScriptExecutorInstance(driver).executeScript("window.scrollBy(" + h + "," + v + ");");
    }

    public static void javaScriptScrollToBottom(WebDriver driver) {
        getJavaScriptExecutorInstance(driver).executeScript("window.scrollBy(0, document.body.scrollHeight;");
    }

    public static void javaScriptNavigateTo(WebDriver driver, String url) {
        getJavaScriptExecutorInstance(driver).executeScript("window.location='" + url + ";");
    }

    public static void javaScriptNavigateBack(WebDriver driver) {
        getJavaScriptExecutorInstance(driver).executeScript("window.history.back();");
    }

    public static void javaScriptNavigateForward(WebDriver driver) {
        getJavaScriptExecutorInstance(driver).executeScript("window.history.forward();");
    }

    public static void javaScriptNavigateRefresh(WebDriver driver) {
        getJavaScriptExecutorInstance(driver).executeScript("window.location.reload();");
    }

}
