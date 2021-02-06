package common;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class CommonReport {
    ExtentReports report;
    ExtentTest logger;
    private static ThreadLocal<CommonReport> ourInstance = new ThreadLocal<>();
    private final static String USER_DIR = System.getProperty("user.dir");

    public static void init(String suiteName) {
        CommonReport localOurInstance = new CommonReport(suiteName);
        ourInstance.set(localOurInstance);
    }

    public static CommonReport getInstance() {
        return ourInstance.get();
    }

    private CommonReport(String suiteName) {
        String reportName = suiteName + ".html";
        report = new ExtentReports(USER_DIR + "\\test-output\\report\\" + reportName);
        report.loadConfig(new File(USER_DIR + "\\extent-config.xml"));
    }

    public void log(LogStatus status, String content) {
        logger.log(status, encodingContent(content));
    }

    public void logInfo(String content) {
        logger.log(LogStatus.INFO, encodingContent(content));
    }

    public void logFail(String content) {
        logger.log(LogStatus.FAIL, encodingContent(content));
    }

    public void logError(String content) {
        logger.log(LogStatus.ERROR, encodingContent(content));
    }

    public void addScreenCapture(LogStatus status, String path) {
        logger.log(status, logger.addScreenCapture(path));
    }

    public void startTest(String testName) {
        logger = report.startTest(testName);
    }

    public void close() {
        report.close();
    }
    
    public void flush() {
        report.endTest(logger);
        report.flush();
    }

    private String encodingContent(String content) {
        try {
            byte ptext[] = content.getBytes("UTF-8");
            return new String(ptext);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return content;
        }
    }

    public void logFullPageInfo(WebDriver driver, String fileName) {
        String content, path, logMessage;
        content = driver.getPageSource();
        try {
            path = USER_DIR + "\\test-output\\report\\" + fileName + ".html";
            new CommonFile().write(path, content);
            logMessage = "HTML record: <a target='_blank' href='" + fileName + ".html" + "'>" + fileName + ".html" + "</a>";
            logInfo(logMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
