package helper;

import basepage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CaptureHelper {
    public static void captureScreenShot(String imgFile, String path) {
        String filePath = String.format(path + "%s", imgFile);
        try {

            File screenshot = ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(filePath));
        } catch (IOException e) {
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
