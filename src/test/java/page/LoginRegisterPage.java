package page;

import helper.PageHelper;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRegisterPage {
    public static WebDriver driver = null;

    public LoginRegisterPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "RegistrationEmail")
    public WebElement emailTxt;

    @FindBy(id = "RegistrationPassword")
    public WebElement passwordTxt;

    @FindBy(id = "ConfirmRegistrationPassword")
    public WebElement confirmPasswordTxt;

    @FindBy(id = "AgreeToTermsAndConditions")
    public WebElement agreeToTermsCb;

    @FindBy(xpath = "//button[text()='REGISTER']")
    public WebElement registerBtn;



    public void registerAccount(User user){
        emailTxt.sendKeys(user.email);
        passwordTxt.sendKeys(user.password);
        confirmPasswordTxt.sendKeys(user.password);
        agreeToTermsCb.click();
        PageHelper.scrollToElement(registerBtn);
        registerBtn.click();

    }

}
