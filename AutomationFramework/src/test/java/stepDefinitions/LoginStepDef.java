//package stepDefinitions;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import pages.HomePage;
//import pages.LoginPage;
//import utils.CommonMethods;
//import utils.ExcelUtils;
//
//import java.io.IOException;
//
///**
// * Steps defined for Login page Feature.
// */
//public class LoginStepDef extends CommonMethods {
//
//    CommonMethods common = new CommonMethods();
//    HomePage home = new HomePage(driver);
//    LoginPage loginPage = new LoginPage(driver);
//
//    private static final Logger LOGGER = LogManager.getLogger(LoginStepDef.class);
//
//    @Given("User is on the E-Commerce website")
//    public void userIsOnTheECommerceWebsite() {
//        driver.get(common.readProp("URL"));
//
//        common.waitTillElementPresent(home.TextHeaderAutomation, 10);
//
//        common.assertValues(home.TextHeaderAutomation, "Full-Fledged practice website for Automation Engineers", 10);
//
//        System.out.println("Application Launched Successfully in browser");
//
//        home.clickSignUpOrLoginButton();
//
//        LOGGER.info("Launching the application on the browser");
//    }
//
//    @Given("User entering valid mail and password from {string} in {string}")
//    public void serEnteringValidMailAndPasswordFromIn(String sheetName, String reference) throws IOException {
//
//        ExcelUtils excel = new ExcelUtils();
//        String email = excel.readCell(sheetName, reference, "Email");
//        String password = excel.readCell(sheetName, reference, "Password");
//
//        loginPage.enterEmail(email);
//        loginPage.enterPassword(password);
//
//        LOGGER.info("Entering email and password from Excel data");
//    }
//
//    @When("User click Login button")
//    public void userClickLoginButton() {
//        loginPage.clickLoginButton();
//
//        LOGGER.info("Clicking login Button");
//    }
//
//    @Then("User should be logged in successfully as a registered user")
//    public void userShouldBeLoggedInSuccessfullyAsARegisteredUser() {
//        common.assertValues(home.BtnLoggedIn, "Logged in as Priyadharshini S", 3);
//
//        LOGGER.info("User Logged In");
//    }
//
//    @Then("User should see error message")
//    public void userShouldSeeErrorMessage() {
//        common.assertValues(loginPage.MessageError,
//                "Your email or password is incorrect!", 3);
//
//        LOGGER.info("Invalid User Error seen");
//    }
//
//    @Given("User logs in using mail and password from {string} in {string}")
//    public void userLogsInUsingMailAndPasswordFromIn(String sheetName, String reference) throws IOException {
//
//        ExcelUtils excel = new ExcelUtils();
//        String email = excel.readCell(sheetName, reference, "Email");
//        String password = excel.readCell(sheetName, reference, "Password");
//
//        loginPage.loginAsRegisteredUser(email, password);
//        common.assertValues(home.BtnLoggedIn, "Logged in as Priyadharshini S", 3);
//
//        LOGGER.info("User logged in");
//    }
//    @When("User click Logout button")
//    public void userClickLogoutButton() {
//        common.clickElement(home.BtnLogOut, 5);
//
//        LOGGER.info("User Clicked Log out button");
//    }
//    @Then("User should be navigated to SignUpOrLogin Page")
//    public void userShouldBeNavigatedToSignUpOrLoginPage() {
//        common.assertValues(loginPage.TextHeaderLogin,
//                "Login to your account", 10);
//
//        LOGGER.info("User navigated to SignUpOrLogin Page");
//    }
//
//}


//----------------------

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ExcelUtils;
import utils.WebDriverConfig;

/**
 * Steps defined for Login page Feature.
 */
public class LoginStepDef {

    private WebDriver driver;
    private CommonMethods common;
    private HomePage home;
    private LoginPage loginPage;
    private static final Logger LOGGER = LogManager.getLogger(LoginStepDef.class);

    public LoginStepDef() {
        this.driver = WebDriverConfig.getDriver();
        this.common = new CommonMethods();
        this.home = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
    }

    @Given("User is on the E-Commerce website")
    public void userIsOnTheECommerceWebsite() {
        driver.get(common.readProp("URL"));

        common.waitTillElementPresent(home.TextHeaderAutomation, 10);

        common.assertValues(home.TextHeaderAutomation, "Full-Fledged practice website for Automation Engineers", 10);

        System.out.println("Application Launched Successfully in browser");

        home.clickSignUpOrLoginButton();

        LOGGER.info("Launching the application on the browser");
    }

    @Given("User entering valid mail and password from {string} in {string}")
    public void userEnteringValidMailAndPasswordFromIn(String sheetName, String reference) throws IOException {

        ExcelUtils excel = new ExcelUtils();
        String email = excel.readCell(sheetName, reference, "Email");
        String password = excel.readCell(sheetName, reference, "Password");

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        LOGGER.info("Entering email and password from Excel data");
    }

    @When("User click Login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();

        LOGGER.info("Clicking login Button");
    }

    @Then("User should be logged in successfully as a registered user")
    public void userShouldBeLoggedInSuccessfullyAsARegisteredUser() {
        common.assertValues(home.BtnLoggedIn, "Logged in as Priyadharshini S", 3);

        LOGGER.info("User Logged In");
    }

    @Then("User should see error message")
    public void userShouldSeeErrorMessage() {
        common.assertValues(loginPage.MessageError,
                "Your email or password is incorrect!", 3);

        LOGGER.info("Invalid User Error seen");
    }

    @Given("User logs in using mail and password from {string} in {string}")
    public void userLogsInUsingMailAndPasswordFromIn(String sheetName, String reference) throws IOException {

        ExcelUtils excel = new ExcelUtils();
        String email = excel.readCell(sheetName, reference, "Email");
        String password = excel.readCell(sheetName, reference, "Password");

        loginPage.loginAsRegisteredUser(email, password);
        common.assertValues(home.BtnLoggedIn, "Logged in as Priyadharshini S", 3);

        LOGGER.info("User logged in");
    }

    @When("User click Logout button")
    public void userClickLogoutButton() {
        common.clickElement(home.BtnLogOut, 5);

        LOGGER.info("User Clicked Log out button");
    }

    @Then("User should be navigated to SignUpOrLogin Page")
    public void userShouldBeNavigatedToSignUpOrLoginPage() {
        common.assertValues(loginPage.TextHeaderLogin,
                "Login to your account", 10);

        LOGGER.info("User navigated to SignUpOrLogin Page");
    }
}