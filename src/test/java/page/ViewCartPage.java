package page;

import helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import report.SoftAssertion;

import java.sql.Time;

public class ViewCartPage {
    public static WebDriver driver = null;

    public ViewCartPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[contains(@id,'qty-')]")
    public WebElement cbbQuantity;

    @FindBy(xpath = "//button[contains(@id,'cart-submit-')]")
    public WebElement btnUpdate;

    @FindBy(xpath = "//div[@class='float-right headFour']")
    public WebElement lblPrice;

    @FindBy(xpath = "//div[text()='MY KAWASAKI']")
    public WebElement myKawasakiBtn;



    public void updateQuantity(String quantity){
        cbbQuantity.click();
        cbbQuantity.sendKeys(quantity);
        btnUpdate.click();
    }



    public boolean verifyTotalPrice(float expectedTotalPrice, String description){
//        TimeHelper.waitElement(By.xpath("//div[@class='float-right headFour']"));
        TimeHelper.sleep(4);
        float actualTotalPrice = Float.parseFloat(lblPrice.getText().substring(1)); //lblPrice.getText().indexOf("$")
        SoftAssertion.assertEquals(actualTotalPrice,expectedTotalPrice,description);
        return true;
    }


    public void clickMyKawasaki(){
        TimeHelper.sleep(4);
        myKawasakiBtn.click();
    }
}
