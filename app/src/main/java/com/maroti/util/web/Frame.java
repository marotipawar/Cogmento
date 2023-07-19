package com.maroti.util.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
 * @Author : Maroti Pawar
 * */
public interface Frame {

    default void switchTo(WebDriver driver, int index) {
        to(driver, index);
    }

    default void switchTo(WebDriver driver, String nameOrId) {
        to(driver, nameOrId);
    }

    default void switchTo(WebDriver driver, WebElement element) {
        to(driver, element);
    }

    default int getSize(WebDriver driver) {
        return size(driver);
    }

    default List<WebElement> getList(WebDriver driver) {
        return getFrameList(driver);
    }


    public static void to(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    public static void to(WebDriver driver, String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    public static void to(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    public static int size(WebDriver driver) {
        return driver.findElements(By.tagName("iframe")).size();
    }

    public static List<WebElement> getFrameList(WebDriver driver) {
        return driver.findElements(By.tagName("iframe"));
    }

}
