package com.maroti.util.web;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : Maroti Pawar
 */

public interface ScreenShot {

    default String getScreenShot(WebDriver driver, String fileName) throws IOException {
        return screenShot(driver, fileName);
    }

    public static String screenShot(WebDriver driver, String fileName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String destFile = fileName + "_" + generateDate() + ".png";
        return storeScreenShot(srcFile, destFile);
    }


    public static String storeScreenShot(File srcFile, String fileName) throws IOException {
        String path = System.getProperty("user.dir") + "/screenshots/";
        File dir = new File(path);
        if (!dir.isDirectory()) {
            dir.mkdir();
        }
        if (dir != null) {
            FileUtils.copyFile(srcFile, new File(dir, fileName));
            return dir.getAbsolutePath();
        }

        return null;
    }
    default String getScreenShotForReport(WebDriver driver, Status status, String fileName) throws IOException {
        return forReports(driver, status, fileName);
    }

    public static String forReports(WebDriver driver, Status status, String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String destFileName = fileName + "_" + generateDate() + ".png";
        return store(srcFile, status, destFileName);
    }


    public static String store(File srcFile, Status status, String fileName) throws IOException {
        String pathPassScreenShot = System.getProperty("user.dir") + "/passScreenShot/";
        File createDirPassScreenShot = new File(pathPassScreenShot);

        boolean checkPassDir = createDirPassScreenShot.isDirectory();
        if (!checkPassDir) {
            createDirPassScreenShot.mkdir();
        }

        String pathFailedScreenShot = System.getProperty("user.dir") + "/failedScreenShot/";
        File createDirFailedScreenShot = new File(pathFailedScreenShot);

        boolean checkFailedDir = createDirFailedScreenShot.isDirectory();
        if (!checkFailedDir) {
            createDirFailedScreenShot.mkdir();
        }

        if (status.equals(Status.PASS)) {
            FileUtils.copyFile(srcFile, new File(createDirPassScreenShot, fileName));
            return "/passScreenShot/" + fileName;
        } else if (status.equals(Status.FAIL)) {
            FileUtils.copyFile(srcFile, new File(createDirFailedScreenShot, fileName));
            return "/failedScreenShot/"+ fileName;
        }
        return null;
    }

    public static String generateDate() {
        return new SimpleDateFormat("ddMMMyyyy_HHmm").format(new Date());
    }

}
