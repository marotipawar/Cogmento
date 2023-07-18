package com.maroti.util.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
 * @Author : Maroti Pawar
 * */
public interface HandleFrame {

    default void switchToFrame(WebDriver driver, int index) {
        switchFrame(driver, index);
    }

    default void switchToFrame(WebDriver driver, String nameOrId) {
        switchFrame(driver, nameOrId);
    }

    default void switchToFrame(WebDriver driver, WebElement element) {
        switchFrame(driver, element);
    }

    default int getTotalFrame(WebDriver driver) {
        return getFramesSize(driver);
    }

    default List<WebElement> getTotalListOfFrame(WebDriver driver) {
        return getTotalFrames(driver);
    }


    public static void switchFrame(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    public static void switchFrame(WebDriver driver, String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    public static void switchFrame(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    public static int getFramesSize(WebDriver driver) {
        return driver.findElements(By.tagName("iframe")).size();
    }

    public static List<WebElement> getTotalFrames(WebDriver driver) {
        return driver.findElements(By.tagName("iframe"));
    }

}
