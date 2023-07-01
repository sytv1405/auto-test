package helper;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TimeHelper {
    public static void  waitElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(5000));
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public static void  wait(By locator, Duration second) {
        try {
            WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), second);
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        }
        catch (InterruptedException e ) {
            e.printStackTrace();
        }
    }
}
