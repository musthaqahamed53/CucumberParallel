//package pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import utils.CommonMethods;
//import utils.WebDriverConfig;
//
///**
// * This class Contains locators for Home Page along with basic methods used in the page.
// * Page Factory is used to Find Web elements.
// */
//public class HomePage extends WebDriverConfig {
//
//    public static WebDriver driver;
//    CommonMethods common = new CommonMethods();
//
//    public HomePage(WebDriver driver){
//        this.driver = WebDriverConfig.driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy (xpath = "//i[@class='fa fa-home']")
//    public WebElement BtnHome;
//
//    @FindBy(xpath = "//i[@class='fa fa-lock']")
//    public WebElement BtnSignUpOrLogin;
//
//    @FindBy(xpath = "(//h2)[1]")
//    public WebElement TextHeaderAutomation;
//
//    @FindBy(xpath = "//a[text()=' Logout']")
//    public WebElement BtnLogout;
//
//    @FindBy(xpath = "//a[text()=' Delete Account']")
//    public WebElement BtnDeleteAccount;
//
//    @FindBy(xpath = "//i[@class='fa fa-user']//parent::a")
//    public WebElement BtnLoggedIn;
//
//    @FindBy(xpath = "//i[@class='fa fa-lock']//parent::a")
//    public WebElement BtnLogOut;
//
//    public void clickSignUpOrLoginButton(){
//        common.clickElement(BtnSignUpOrLogin, 3);
//    }
//
//}


//------------------------
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

/**
 * This class Contains locators for Home Page along with basic methods used in the page.
 * Page Factory is used to Find Web elements.
 */
public class HomePage {

    private WebDriver driver;
    private CommonMethods common;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.common = new CommonMethods();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='fa fa-home']")
    public WebElement BtnHome;

    @FindBy(xpath = "//i[@class='fa fa-lock']")
    public WebElement BtnSignUpOrLogin;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement TextHeaderAutomation;

    @FindBy(xpath = "//a[text()=' Logout']")
    public WebElement BtnLogout;

    @FindBy(xpath = "//a[text()=' Delete Account']")
    public WebElement BtnDeleteAccount;

    @FindBy(xpath = "//i[@class='fa fa-user']//parent::a")
    public WebElement BtnLoggedIn;

    @FindBy(xpath = "//i[@class='fa fa-lock']//parent::a")
    public WebElement BtnLogOut;

    public void clickSignUpOrLoginButton(){
        common.clickElement(BtnSignUpOrLogin, 3);
    }
}