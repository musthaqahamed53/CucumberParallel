//package stepDefinitions;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import pages.HomePage;
//import pages.SignUpPage;
//import utils.CommonMethods;
//import utils.ExcelUtils;
//import java.io.IOException;
//
///**
// * Steps defined for SignUp page Feature.
// */
//public class SignUpStepDef extends CommonMethods {
//
//    SignUpPage signUpPage = new SignUpPage(driver);
//    CommonMethods common = new CommonMethods();
//    HomePage home = new HomePage(driver);
//
//    private static final Logger LOGGER = LogManager.getLogger(SignUpStepDef.class);
//    @Given("User enters name and email and clicks signup Button")
//    public void userEntersNameAndEmailAndClicksSignupButton() {
//        home.clickSignUpOrLoginButton();
//        signUpPage.enterName(RandomStringUtils.randomAlphabetic(6));
//        signUpPage.enterEmail(RandomStringUtils.randomAlphanumeric(10) + "@mailinator.com");
//        signUpPage.clickSignUpButton();
//
//        LOGGER.info("User Enters name and email");
//    }
//    @When("User navigates to Create account page")
//    public void userNavigatesToCreateAccountPage() {
//        common.assertValues(signUpPage.HeaderCreateAccount,
//                "ENTER ACCOUNT INFORMATION", 10);
//
//        LOGGER.info("User navigates to account information page");
//    }
//    @When("User enters all the necessary details from {string}")
//    public void userEntersAllTheNecessaryDetailsFrom(String sheetName) throws IOException {
//        String name = common.getAttributeValue(signUpPage.TextBoxName, "value");
//        String email = common.getAttributeValue(signUpPage.TextBoxEmail, "value");
//        ExcelUtils excel = new ExcelUtils();
//        excel.writeCell(sheetName, "New_User", "Email", email);
//        excel.writeCell(sheetName, "New_User", "Password", "Test@123");
//        signUpPage.clickGenderOption("Mrs");
//        signUpPage.enterPassword();
//        signUpPage.selectDOB("22", "May", "2001");
//        signUpPage.checkNewsLetterAndOptIn();
//        signUpPage.enterFirstName();
//        signUpPage.enterLastName();
//        signUpPage.enterAddress("PO BOX 11");
//        signUpPage.selectCountry("India");
//        signUpPage.enterState("Tamil Nadu");
//        signUpPage.enterCity("Chennai");
//        signUpPage.enterZipCode("612341");
//        signUpPage.enterMobileNumber(common.tenDigitNumber());
//        signUpPage.clickCreateAccountButton();
//
//        LOGGER.info("User Enters necessary details");
//    }
//    @Then("User should be logged in newly created account")
//    public void userShouldBeLoggedInNewlyCreatedAccount() throws InterruptedException {
//        common.assertValues(signUpPage.HeaderAccountCreated, "ACCOUNT CREATED!", 15);
//        signUpPage.clickContinueButton();
//        common.assertValues(home.BtnLogOut, "Logout", 15);
//
//        LOGGER.info("New Account created");
//    }
//}

//-----------------------

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SignUpPage;
import utils.CommonMethods;
import utils.ExcelUtils;
import utils.WebDriverConfig;

import java.io.IOException;

/**
 * Steps defined for SignUp page Feature.
 */
public class SignUpStepDef {

    private WebDriver driver;
    private CommonMethods common;
    private HomePage home;
    private SignUpPage signUpPage;
    private static final Logger LOGGER = LogManager.getLogger(SignUpStepDef.class);

    public SignUpStepDef() {
        this.driver = WebDriverConfig.getDriver();
        this.common = new CommonMethods();
        this.home = new HomePage(driver);
        this.signUpPage = new SignUpPage(driver);
    }

    @Given("User enters name and email and clicks signup Button")
    public void userEntersNameAndEmailAndClicksSignupButton() {
        home.clickSignUpOrLoginButton();
        signUpPage.enterName(RandomStringUtils.randomAlphabetic(6));
        signUpPage.enterEmail(RandomStringUtils.randomAlphanumeric(10) + "@mailinator.com");
        signUpPage.clickSignUpButton();

        LOGGER.info("User Enters name and email");
    }

    @When("User navigates to Create account page")
    public void userNavigatesToCreateAccountPage() {
        common.assertValues(signUpPage.HeaderCreateAccount,
                "ENTER ACCOUNT INFORMATION", 10);

        LOGGER.info("User navigates to account information page");
    }

    @When("User enters all the necessary details from {string}")
    public void userEntersAllTheNecessaryDetailsFrom(String sheetName) throws IOException {
        String name = common.getAttributeValue(signUpPage.TextBoxName, "value");
        String email = common.getAttributeValue(signUpPage.TextBoxEmail, "value");
        ExcelUtils excel = new ExcelUtils();
        excel.writeCell(sheetName, "New_User", "Email", email);
        excel.writeCell(sheetName, "New_User", "Password", "Test@123");
        signUpPage.clickGenderOption("Mrs");
        signUpPage.enterPassword();
        signUpPage.selectDOB("22", "May", "2001");
        signUpPage.checkNewsLetterAndOptIn();
        signUpPage.enterFirstName();
        signUpPage.enterLastName();
        signUpPage.enterAddress("PO BOX 11");
        signUpPage.selectCountry("India");
        signUpPage.enterState("Tamil Nadu");
        signUpPage.enterCity("Chennai");
        signUpPage.enterZipCode("612341");
        signUpPage.enterMobileNumber(common.tenDigitNumber());
        signUpPage.clickCreateAccountButton();

        LOGGER.info("User Enters necessary details");
    }

    @Then("User should be logged in newly created account")
    public void userShouldBeLoggedInNewlyCreatedAccount() throws InterruptedException {
        common.assertValues(signUpPage.HeaderAccountCreated, "ACCOUNT CREATED!", 15);
        signUpPage.clickContinueButton();
        common.assertValues(home.BtnLogOut, "Logout", 15);

        LOGGER.info("New Account created");
    }
}
