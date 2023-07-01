package base;

import helper.HTMLReportHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePage extends basepage.BasePage {

    @BeforeClass
    public void openBrowserAndCreateHTMLRp() {
        setupBrowser("https://www.kawasaki.com");
        HTMLReportHelper.htmlReportHelper();
    }

    @AfterClass
    public void closeBrowser(){
        HTMLReportHelper.getExtent().flush();
//        getDriver().quit();
    }

}
