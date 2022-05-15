/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Ibrahim
 */
public class Shot {

    private final WebDriver driver;
    private final String shotsPath;
    private Description description;

    public Shot(WebDriver driver) {
        this.driver = driver;
        shotsPath = "D:\\Shots";
    }

    public Shot(WebDriver driver, Description description) {
        this.driver = driver;
        this.description = description;
        shotsPath = "D:\\Shots";

    }

    public void snapError() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(errorShotName()));
        } catch (IOException ex) {
            Logger.getLogger(Shot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void snapStep() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(stepShotName()));
        } catch (IOException ex) {
            Logger.getLogger(Shot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void manualSnapStep() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(stepShotName()));
        } catch (IOException ex) {
            Logger.getLogger(Shot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String errorShotName() {
//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        System.out.println(description.getClassName() + "@" + description.getMethodName() + "@" + getCurrentTime() + ".png");
        return shotsPath + "\\" + description.getClassName() + "@" + description.getMethodName() + "@" + getCurrentTime() + ".png";
    }

    public String stepShotName() {
        return shotsPath + "\\@" + getCurrentTime() + ".png";
    }

    public String getCurrentTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss-S");
        return (simpleDateFormat.format(date));
    }

    public String getCurrentDate() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return (simpleDateFormat.format(date));
    }

    public void setDescription(Description description) {
        this.description = description;
    }

}
