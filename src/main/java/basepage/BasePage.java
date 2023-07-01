package basepage;

import helper.HTMLReportHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void setupBrowser(String URL) {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LyLT6\\Downloads\\chromedriver_win32\\chromedriver.exe");

        setDriver(new ChromeDriver());

        getDriver().navigate().to(URL);

        getDriver().manage().window().maximize();
    }
}
