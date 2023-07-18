package com.maroti.util.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
 * @Author : Maroti Pawar
 * */
public interface HandleFrame {
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
