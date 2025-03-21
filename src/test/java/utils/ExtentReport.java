package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;

public class ExtentReport {
    WebDriver driver;
    static ExtentReports extent;
    static ExtentTest test;
    public static void setup(){
        ExtentSparkReporter reporter=new ExtentSparkReporter("First Extent.html");
        extent=new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(reporter);
    }
    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logTestStep(String message, String status) {
        if (status.equalsIgnoreCase("pass")) {
            test.pass(message);
        } else if (status.equalsIgnoreCase("fail")) {
            test.fail(message);
        } else if (status.equalsIgnoreCase("skip")) {
            test.skip(message);
        }
    }
    public static void teardown(){
        extent.flush();
    }
}
