package page;

import helper.PageHelper;
import helper.ProcessDataMainHelper;
import helper.TimeHelper;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import report.SoftAssertion;
import testmain.TestDataConstant;

import java.util.List;

public class ShopVehicleAccessoriesPage {
    public static WebDriver driver = null;

    public ShopVehicleAccessoriesPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@class='sortBy font-oswald-important']")
    public WebElement sortByBtn;

    @FindBy(xpath = "//option[contains(.,'high to low')]")
    public WebElement highToLowOption;

    @FindBy(xpath = "//div[@class='row pb-5']/div")
    List<WebElement> productsLbl;

    @FindBy(xpath = "//div[@class='disclaimer mt-negative-50']")
    public WebElement disclaimerMessageLbl;

    @FindBy(xpath = "//h2[text()='Rear Carrier']")
    public WebElement lblName;

    @FindBy(xpath = "//p[text()='Item # 99994-1483']")
    public WebElement lblId;

    @FindBy(xpath = "//div[@class='headFour' and contains(.,'$201.95')]")
    public WebElement lblPrice;

    @FindBy(id = "price-0-25")
    public WebElement lblRangePrice;

    @FindBy(id = "shop_cart")
    public WebElement btnAddToCart;

    @FindBy(id = "btnModalCartViewCart")
    public WebElement btnViewCart;








    public void sortPrice(){
        sortByBtn.click();
        highToLowOption.click();
    }

    public boolean verifyDisplayedProductTotal(int expectedTotal, String description){
        int actualTotal = productsLbl.size();
        SoftAssertion.assertEquals(actualTotal, expectedTotal, description);
        return true;
    }

    public boolean verifyProduct(Product expectedProduct){
        PageHelper.scrollToElement(lblRangePrice);
        String xpath = "//a[contains(@href,'/en-us/shop/vehicle-accessories/motorcycle/')]//h4[contains(.,'%s')]";
        driver.findElement(By.xpath(ProcessDataMainHelper.formatElement(xpath, TestDataConstant.product.getName()))).click();
        Product actualProduct = buildActualProduct();
        actualProduct.verifyProduct(expectedProduct);
        return true;
    }



    public Product buildActualProduct(){
        Product ret = new Product();
        ret.setName(lblName.getText());
        ret.setId(lblId.getText().substring(lblId.getText().indexOf("#")+1));
        ret.setPrice(lblPrice.getText());
        return ret;

    }


    public void clickAddToCart(){
        PageHelper.scrollToElement(btnAddToCart);
        btnAddToCart.click();
    }


    public void clickViewCart(){
        TimeHelper.waitElement(By.id("btnModalCartViewCart"));
        btnViewCart.click();
    }












}
