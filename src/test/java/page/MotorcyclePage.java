package page;

import helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import report.SoftAssertion;

import java.util.List;

public class MotorcyclePage {
    public static WebDriver driver = null;

    public MotorcyclePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[contains(.,'Customize your vehicle')]")
    public WebElement messageLbl;

    @FindBy(id = "product")
    public WebElement motorcycleItem;

    @FindBy(xpath = "//option[text()='KLX® 300']")
    public WebElement vehicleItem;

    @FindBy(id = "urlLink")
    public WebElement selectBtn;



    public void verifyMessage(String expectedMessage, String description){
        String actualMessage = messageLbl.getText();
        SoftAssertion.assertEquals(actualMessage, expectedMessage,description);
    }

    public void selectVehicleItem(){
        TimeHelper.waitElement(By.id("product"));
        motorcycleItem.click();
        TimeHelper.waitElement(By.xpath("//option[text()='KLX® 300']"));
        vehicleItem.click();
        selectBtn.click();
    }

}
