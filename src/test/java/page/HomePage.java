package page;

import model.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    public static WebDriver driver = null;

    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBys(@FindBy(xpath ="//ul[@class='nav float-left']//button"))
    public List<WebElement> categoriesLbl;


    @FindBy(xpath = "//div[text()='MY KAWASAKI']")
    public WebElement myKawasakiBtn;




    public boolean verifyCategoryMenu(List <Category> expectedCategories, String description){
         List<Category> actualCategories = buildActualCategories();
         for(int i = 0; i < actualCategories.size(); i++) {
             Category actualCategory = actualCategories.get(i);
             Category expectedCategory = expectedCategories.get(i);
             actualCategory.verifyCategory(expectedCategory, description);
         }
         return true;
    }


    public List<Category> buildActualCategories(){
        List<Category> ret = new ArrayList<>();
        for( int i = 0; i < categoriesLbl.size(); i++ ){
            String categoryName = categoriesLbl.get(i).getText();
            ret.add(new Category(categoryName));
        }
        return ret;
    }


    public void clickMyKawasakiBtn(){
        myKawasakiBtn.click();
    }
}
