package com.maroti.factory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class MyWebBrowser implements MyBrowser {

    private WebDriver driver;

    public MyWebBrowser(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebDriver getDriver() {
        return this.driver;
    }

    @Override
    public String getTitle() {
        return this.getTitle();
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public void javaScriptClick(WebElement element) {
        JavascriptExecutor ex =(JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", element);
    }

    @Override
    public void javaScriptSendKeys(WebElement element, String value) {
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].value='"+value+"'", element);
    }

    @Override
    public void actionClick(WebElement element) {
        Actions act = new Actions(driver);
        act.click(element).build().perform();
    }

    @Override
    public void actionSendKey(WebElement element, String value) {
        Actions act = new Actions(driver);
        act.sendKeys(element, value).build().perform();
    }

    @Override
    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    @Override
    public WebDriverWait explicitWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(40));

    }
}
