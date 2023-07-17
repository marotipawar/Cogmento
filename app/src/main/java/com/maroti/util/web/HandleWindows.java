package com.maroti.util.web;

import com.maroti.base.BaseWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface HandleWindows {


    public static void switchTab(WebDriver driver, String parentWindow) {
        Set<String> list = driver.getWindowHandles();

        for (String tab : list) {
            if (tab.equals(parentWindow)) {
                driver.switchTo().window(tab);
            }

        }

    }

    public static void switchPreviousTab(WebDriver driver) {
        Set<String> windowList = driver.getWindowHandles();
        List<String> list = new ArrayList<>(windowList);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(driver.getWindowHandle())) {
                driver.switchTo().window(list.get(i - 1));
                break;

            }
        }
    }

    public static void switchNextTab(WebDriver driver) {
        Set<String> windowList = driver.getWindowHandles();
        List<String> list = new ArrayList<>(windowList);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(driver.getWindowHandle())) {
                driver.switchTo().window(list.get(i + 1));
                break;

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BaseWebDriver.chrome("https://www.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(4000);
        switchPreviousTab(driver);
        Thread.sleep(4000);
        switchNextTab(driver);

    }

}
