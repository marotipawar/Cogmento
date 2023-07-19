package com.maroti;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.maroti.base.BaseWebDriver;
import com.maroti.model.Report;
import com.maroti.util.report.Extent;
import com.maroti.util.web.ScreenShot;
import org.openqa.selenium.WebDriver;


import java.io.IOException;
import java.net.URISyntaxException;


public class CogmentoApp {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        WebDriver driver = BaseWebDriver.chrome("https://www.google.com");


        ExtentReports reports =Extent.getExtentInstance("FaceBook Suit", "facebookLogin");
        ExtentTest test =reports.createTest("login");
        test.pass("Login success");
        test.addScreenCaptureFromPath(ScreenShot.forReports(driver, Status.PASS, "Facebook"));
        ExtentTest test1 =reports.createTest("login");
        test1.fail("Login failed");
        test1.addScreenCaptureFromPath(ScreenShot.forReports(driver, Status.FAIL, "Facebook"));

        reports.flush();
    }

}
