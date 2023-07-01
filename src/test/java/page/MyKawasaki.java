package page;

import helper.ProcessDataMainHelper;
import helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyKawasaki {
    public static WebDriver driver = null;

    public MyKawasaki(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "shopDropdown")
    public WebElement shopCbb;

    @FindBy(id = "dropdownMenuLink")
    public WebElement headSixIcon;

    @FindBy(xpath = "//a[text()='Log Off']")
    public WebElement logoutLbl;



    public void clickShopCbb(){
        TimeHelper.waitElement(By.id("shopDropdown"));
        shopCbb.click();
    }



    public void selectProductType(String type){
        String xpath = "//a[contains(@href,'/en-us/shop/') and @class='pOne' and text()= '%s']";
        driver.findElement(By.xpath(ProcessDataMainHelper.formatElement(xpath,type))).click();
    }


    public void logout(){
        headSixIcon.click();
        logoutLbl.click();
    }


}
