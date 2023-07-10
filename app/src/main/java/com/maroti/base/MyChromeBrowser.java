package com.maroti.base;

import com.maroti.factory.MyWebBrowser;
import com.maroti.util.MyPropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;

public final class MyChromeBrowser extends MyWebBrowser {

    private static MyChromeBrowser browser = null;
    private WebDriver driver;

    private MyChromeBrowser(WebDriver driver) throws FileNotFoundException {
        super(driver);
        this.driver = driver;
        MyPropertiesFileReader.load();
        this.driver.get(System.getProperty("url"));
        this.driver.manage().window().maximize();
        implicitlyWait();

    }

    public static MyWebBrowser getInstance(WebDriver driver) throws FileNotFoundException {
        if (browser == null) {
            browser = new MyChromeBrowser(driver);
        }
        return browser;
    }


}
