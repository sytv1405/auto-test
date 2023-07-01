package helper;

import org.testng.*;
import org.testng.annotations.Listeners;
import testmain.TestDataConstant;

@Listeners
public class ListenerHelper implements ITestListener, ISuiteListener {

    private static final String OTF_MESSAGE_FORMAT = "&emsp;&emsp;&emsp;<i>- Fail because of bad internet connection";


    @Override
    public void onStart(ISuite iSuite) {
        //Delete old screenshot files
        FileHelper.deleteFiles(TestDataConstant.LOCATOR, TestDataConstant.EXTENSION);
    }

    @Override
    public void onFinish(ISuite iSuite) {

    }

    @Override
    public void onTestStart(ITestResult result) {
        HTMLReportHelper.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        HTMLReportHelper.logFail(OTF_MESSAGE_FORMAT);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
