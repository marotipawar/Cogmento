package com.maroti;

import com.aventstack.extentreports.Status;
import com.maroti.base.BaseWebDriver;
import com.maroti.util.web.HandleScreenShot;
import org.openqa.selenium.WebDriver;


import java.io.IOException;
import java.net.URISyntaxException;


public class CogmentoApp {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        WebDriver driver = BaseWebDriver.chrome("https://www.google.com");
        String path=HandleScreenShot.getScreenShotForReports(driver, Status.FAIL,"Example");
        System.out.println("Path :"+path);
    }

}
