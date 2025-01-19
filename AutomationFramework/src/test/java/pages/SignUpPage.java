package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import utils.WebDriverConfig;

/**
 * This class Contains locators for Signup Page along with basic methods used in the page.
 * Page Factory is used to Find Web elements.
 */
public class SignUpPage extends WebDriverConfig{
    private WebDriver driver;
    private CommonMethods common;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        this.common = new CommonMethods();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement TextInputName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement TextInputEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement BtnSignUp;

    @FindBy(xpath = "(//h2[@class='title text-center']//b)[1]")
    public WebElement HeaderCreateAccount;

    @FindBy(id = "id_gender1")
    public WebElement RadioBtnGender1;

    @FindBy(id = "id_gender2")
    public WebElement RadioBtnGender2;

    @FindBy(id = "name")
    public WebElement TextBoxName;

    @FindBy(id = "email")
    public WebElement TextBoxEmail;

    @FindBy(xpath = "//input[@data-qa='password']")
    public WebElement TextInputPassword;

    @FindBy(id = "days")
    public WebElement DropDownDate;

    @FindBy(id = "months")
    public WebElement DropDownMonth;

    @FindBy(id = "years")
    public WebElement DropDownYear;

    @FindBy(id = "newsletter")
    public WebElement CheckBoxNewsLetter;

    @FindBy(id = "optin")
    public WebElement CheckBoxOptIn;

    @FindBy(xpath = "//input[@data-qa='first_name']")
    public WebElement TextInputFirstName;

    @FindBy(xpath = "//input[@data-qa='last_name']")
    public WebElement TextInputLastName;

    @FindBy(xpath = "//input[@data-qa='address']")
    public WebElement TextInputAddress;

    @FindBy(id = "country")
    public WebElement DropDownCountry;

    @FindBy(xpath = "//input[@data-qa='state']")
    public WebElement TextInputState;

    @FindBy(xpath = "//input[@data-qa='city']")
    public WebElement TextInputCity;

    @FindBy(xpath = "//input[@data-qa='zipcode']")
    public WebElement TextInputZipCode;

    @FindBy(xpath = "//input[@data-qa='mobile_number']")
    public WebElement TextInputMobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement BtnCreateAccount;

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    public WebElement HeaderAccountCreated;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement BtnContinue;

    public void enterName(String name){
        common.sendText(TextInputName, name, 3);
    }

    public void enterEmail(String email){
        common.sendText(TextInputEmail, email, 3);
    }

    public void clickSignUpButton(){
        common.clickElement(BtnSignUp, 3);
    }

    public void clickGenderOption(String Gender){
        if (Gender.toLowerCase().equals("mr")){
            common.clickElement(RadioBtnGender1, 3);
        } else {
            common.clickElement(RadioBtnGender2, 3);
        }
    }

    public void enterPassword() {
        common.sendText(TextInputPassword, "Test@123", 3);
    }

    public void selectDOB(String date, String month, String year) {
        common.dropDownSelectByValue(DropDownDate, date);
        common.dropDownSelectByValue(DropDownMonth, month);
        common.dropDownSelectByValue(DropDownYear, year);
    }

    public void checkNewsLetterAndOptIn(){
        common.clickElement(CheckBoxNewsLetter, 3);
        common.clickElement(CheckBoxOptIn, 3);
    }

    public void enterFirstName(){
        String firstName = common.getAttributeValue(TextBoxName, "value");
        common.sendText(TextInputFirstName, firstName, 5);
    }

    public void enterLastName(){
        String lastName = common.getAttributeValue(TextBoxName, "value");
        common.sendText(TextInputLastName, lastName, 5);
    }

    public void enterAddress(String address) {
        common.sendText(TextInputAddress, address, 3);
    }

    public void selectCountry(String Country) {
        common.dropDownSelectByValue(DropDownCountry, Country);
    }

    public void enterState(String state) {
        common.sendText(TextInputState, state, 3);
    }

    public void enterCity(String city) {
        common.sendText(TextInputCity, city, 3);
    }

    public void enterZipCode(String zipCode) {
        common.sendText(TextInputZipCode, zipCode, 3);
    }

    public void enterMobileNumber(String mobileNumber) {
        common.sendText(TextInputMobileNumber, mobileNumber, 3);
    }

    public void clickCreateAccountButton() {
        common.clickElement(BtnCreateAccount, 3);
    }

    public void clickContinueButton() {
        common.clickElement(BtnContinue, 8);
    }
}
