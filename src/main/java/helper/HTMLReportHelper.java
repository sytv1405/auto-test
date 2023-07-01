package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;

public class HTMLReportHelper {
    public static ExtentTest rpHTML = null;
    public static ExtentReports extent = new ExtentReports();
    public static int countIndex = 1;
    public static final String STEP_LOG = "%s. %s ";


    public static void htmlReportHelper() {
        ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("src\\test\\java\\htmlreport\\output.html");

        htmlReport.config().setTheme(Theme.STANDARD);

        htmlReport.config().setReportName("Automation report");

        htmlReport.config().setCSS(".r-img { width: 30%; }");

        getExtent().attachReporter(htmlReport);

    }

    public static void createTest(String testName){
        setRpHTML(getExtent().createTest(testName));
    }

    public static ExtentTest getRpHTML() {
        return rpHTML;
    }

    public static void setRpHTML(ExtentTest rpHTML) {
        HTMLReportHelper.rpHTML = rpHTML;
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public void setExtent(ExtentReports extent) {
        HTMLReportHelper.extent = extent;
    }

    public static void stepLog(String description) {
        String stepDescription = String.format(STEP_LOG, countIndex, description);
        logMessage(stepDescription);
        countIndex++;
    }

    public static void logMessage(String stepDescription){
        rpHTML.log(Status.INFO, stepDescription);
    }

    public static void logPass(final String message) {
        rpHTML.pass(message);
    }

    public static void logFail(final String unsuccessfulVerificationMessage) {
        double random = Math.floor(Math.random()*100-1+1)+1;
        String imgFile = String.format("screenShot(%s).png", random);
        CaptureHelper.captureScreenShot(imgFile, "src\\\\test\\\\java\\\\htmlreport\\\\");
        try {
            HTMLReportHelper.rpHTML.fail(unsuccessfulVerificationMessage, MediaEntityBuilder.createScreenCaptureFromPath(imgFile).build());
        } catch (IOException e) {
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
