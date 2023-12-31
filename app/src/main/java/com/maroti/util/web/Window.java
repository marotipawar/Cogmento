package com.maroti.util.web;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface Window {
    public static void switchTab(WebDriver driver, String parentWindow) {
        Set<String> list = driver.getWindowHandles();
        for (String tab : list) {
            if (tab.equals(parentWindow)) {
                driver.switchTo().window(tab);
            }

        }

    }

    public static void switchPreviousTab(WebDriver driver) {
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(driver.getWindowHandle())) {
                driver.switchTo().window(list.get(i - 1));
                break;

            }
        }
    }

    public static void switchNextTab(WebDriver driver) {
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(driver.getWindowHandle())) {
                driver.switchTo().window(list.get(i + 1));
                break;

            }
        }
    }

}
