package utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Listeners extends CommonOps implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        currentTest = extent.createTest("testName: "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            if (iTestResult.getStatus() == ITestResult.FAILURE) {
                currentTest.log(Status.FAIL,
                        MarkupHelper.createLabel(iTestResult.getName()
                                        + " Test case FAILED due to below issues:",
                                ExtentColor.RED));
                String srnshotpath = takescreen(iTestResult);
                currentTest.fail(iTestResult.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(srnshotpath).build());
            } else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
                currentTest.log(
                        Status.PASS,
                        MarkupHelper.createLabel(iTestResult.getName()
                                + " Test Case PASSED", ExtentColor.GREEN));
                String srnshot = takescreen(iTestResult);
                currentTest.pass(iTestResult.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(srnshot).build());
            } else {
                currentTest.log(
                        Status.SKIP,
                        MarkupHelper.createLabel(iTestResult.getName()
                                + " Test Case SKIPPED", ExtentColor.ORANGE));
                currentTest.skip(iTestResult.getThrowable());
            }

            //     takescreen(iTestResult); //we want to capture image only on failures


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
    public String takescreen(ITestResult result) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File localScreenshots = new File(new File("target"), "screenshots");

        if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
            localScreenshots.mkdirs();
        }

        File screenshot = new File(localScreenshots, result.getName()+timeStamp+ ".png");
        FileUtils.moveFile(imageFile, screenshot);

        System.out.println(screenshot.getAbsolutePath());

        String extentScrnshot =screenshot.getAbsolutePath(); //I think its better to capture the test name in the image rather than current time

        return extentScrnshot;
    }

}
