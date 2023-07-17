package com.maroti.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
/*
 * @Author : Maroti Pawar
 * */
@FunctionalInterface
public interface BaseWebDriver {

    public WebDriver otherDriver(String url);

    default String getUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    default String getTitle(WebDriver driver){
        return driver.getTitle();
    }


    public static WebDriver chrome(String url) {
        WebDriver driver = new ChromeDriver();
        init(driver, url);
        return driver;
    }

    public static WebDriver firefox(String url) {
        WebDriver driver = new FirefoxDriver();
        init(driver, url);
        return driver;
    }

    public static WebDriver edge(String url) {
        WebDriver driver = new EdgeDriver();
        init(driver, url);
        return driver;
    }


    public static void init(WebDriver driver, String url) {
        if (driver != null) {
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        }

    }


    public static void newTab(WebDriver driver, String url){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(url);
    }
}
