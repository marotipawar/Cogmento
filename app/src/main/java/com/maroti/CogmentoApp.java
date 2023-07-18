package com.maroti;

import com.maroti.base.BaseWebDriver;
import com.maroti.util.web.HandleFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;

public class CogmentoApp {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException, InterruptedException {
        WebDriver driver = BaseWebDriver.chrome("https://demoqa.com/nestedframes");
        HandleFrame.switchFrame(driver, "frame1");
        HandleFrame.switchFrame(driver, 0);
        System.out.println(driver.findElement(By.tagName("p")).getText());
    }

}
