package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import utils.WebDriverConfig;

/**
 * This class Contains locators for Login Page along with basic methods used in the page.
 * Page Factory is used to Find Web elements.
 */
public class LoginPage extends WebDriverConfig{

    private WebDriver driver;
    private CommonMethods common;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.common = new CommonMethods();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement TextHeaderLogin;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement TextInputEmail;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement TextInputPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement BtnLogin;

    @FindBy(xpath= "//button[@data-qa='login-button']//preceding-sibling::p")
    public WebElement MessageError;

    public void enterEmail(String email){
        common.sendText(TextInputEmail, email, 5);
    }

    public void enterPassword(String password){
        common.sendText(TextInputPassword, password, 5);
    }

    public void clickLoginButton(){
        common.clickElement(BtnLogin, 5);
    }

    public void loginAsRegisteredUser(String email, String password){
        common.sendText(TextInputEmail, email, 3);
        common.sendText(TextInputPassword, password, 3);
        common.clickElement(BtnLogin, 3);
    }

}
