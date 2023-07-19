package com.maroti.util.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.maroti.base.BaseWebDriver;
import com.maroti.model.Report;
import com.maroti.util.web.ScreenShot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface Extent {
    public static ExtentSparkReporter getSparkInstance(Report report) {
        ExtentSparkReporter reporter = new ExtentSparkReporter(report.getPath());
        reporter.getConf().setReportName(report.getReportName());
        reporter.getConf().setDocumentTitle(report.getDocumentTitle());
        return reporter;
    }

    public static ExtentReports getInstance(Report report) {
        ExtentSparkReporter reporter = getSparkInstance(report);
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(reporter);
        return reports;
    }

    public static ExtentTest createTest(Report report) {
        ExtentReports reports = getInstance(report);
        ExtentTest test=reports.createTest(report.getTestName());
        report.setReports(reports);
        return test;
    }


    public static File store(String fileName) throws IOException {

        String path = System.getProperty("user.dir") + "/app/build/";
        File file = new File(path + "/extentReport/");
        if (file.isDirectory()) {
            file.mkdir();
        }
        SimpleDateFormat sf = new SimpleDateFormat("ddMMMyyy_HHmm");
        String date = sf.format(new Date());
        return new File(file + "\\"+fileName + "_" + date + ".html");
    }






   /* public static void main(String[] args) throws IOException {

        WebDriver driver = BaseWebDriver.chrome("https://www.facebook.com");
        Report report1 = Report.builder()
                .documentTitle("Google")
                .reportName("Google Report")
                .testName("Search box")
                .status(Status.PASS)
                .path(store("google"))
                .build();
        createTest(report1).addScreenCaptureFromPath(ScreenShot.forReports(driver,Status.PASS,"google"));
        report1.getReports().flush();
    }*/

}
