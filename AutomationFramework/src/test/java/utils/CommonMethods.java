//package utils;
//
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.asserts.SoftAssert;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.util.Date;
//import java.util.Properties;
//import java.util.Random;
//
///**
// * This Class contains common utilities such as to send text, waits, takes screenshots, etc.
// */
//public class CommonMethods extends WebDriverConfig {
//
//    public static WebDriverWait wait;
//
//    private static final Random random = new Random();
//
//    /**
//     * Reads config.properties file.
//     */
//    public static Properties properties(){
//        Properties prop = new Properties();
//        try {
//            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
//            FileReader fileReader = new FileReader(filePath);
//            prop.load(fileReader);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return prop;
//    }
//
//    /**
//     * Gets the value from property file.
//     * @param key value of the key mentioned in property file
//     */
//    public String readProp(String key){
//        return properties().getProperty(key);
//    }
//
//    /**
//     * Opens the browser mentioned in property file and maximises it.
//     */
//    public void invokeBrowser(){
//        String browser = readProp("Browser").toLowerCase();
//        switch (browser) {
//            case "chrome":
//                driver = new ChromeDriver();
//                break;
//            case "edge":
//                driver = new EdgeDriver();
//                break;
//            case "firefox":
//                driver = new FirefoxDriver();
//                break;
//            default:
//                throw new IllegalArgumentException("The browser " + browser + " is not supported");
//        }
//
//        driver.manage().window().maximize();
//    }
//
//    /**
//     * Closes browser.
//     */
//    public void closeBrowser() throws IOException{
//        if(driver!=null){
//            driver.quit();
//        }
//    }
//    /**
//     * Waits for Element to be attached to DOM.
//     * @param Element shows the specific web element
//     * @param seconds denotes the time to wait
//     */
//    public void waitTillElementPresent(WebElement Element, int seconds) {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
//        wait.until(ExpectedConditions.visibilityOf(Element));
//    }
//
//
//    /**
//     * Waits for Element to be Clickable.
//     * @param Element shows the specific web element
//     * @param seconds denotes the time to wait
//     */
//    public void waitTillElementToBeClickable(WebElement Element, int seconds) {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
//        wait.until(ExpectedConditions.elementToBeClickable(Element));
//    }
//
//
//    /**
//     * Clicks referred element.
//     * @param Element shows the specific web element to be clicked
//     * @param seconds denotes the time to wait
//     */
//    public void clickElement(WebElement Element, int seconds) {
//        waitTillElementToBeClickable(Element, seconds);
//        Element.click();
//    }
//
//    /**
//     * Clears and send input to input field.
//     * @param Element shows the specific web element to be enter text
//     * @param seconds denotes the time to wait
//     */
//    public void sendText(WebElement Element, String text, int seconds) {
//        clickElement(Element, seconds);
//        Element.clear();
//        Element.sendKeys(text);
//    }
//
//    /**
//     * Gets Text from a Web Element.
//     * @param Element shows the specific web element to get text
//     * @param seconds denotes the time to wait
//     */
//    public String getText(WebElement Element, int seconds) {
//        waitTillElementPresent(Element, seconds);
//        String text = Element.getText();
//        return text;
//    }
//
//    /**
//     * Retrieves WebElement text values and matches with Expected String.
//     * @param Element shows the specific web element to get text and to match with expected
//     * @param Expected - enter the expected value
//     * @param seconds denotes the time to wait
//     */
//    public void assertValues(WebElement Element, String Expected, int seconds) {
//        waitTillElementPresent(Element, seconds);
//        String Actual = getText(Element, seconds);
//        Assert.assertEquals(Actual, Expected);
//    }
//
//    /**
//     * Retrieves WebElement text values and matches with Expected, will not stop execution
//     * @param Element shows the specific web element to get text and to match with expected
//     * @param Expected - enter the expected value
//     * @param seconds denotes the time to wait
//     */
//    public void softAssertValues(WebElement Element, String Expected, int seconds) {
//        waitTillElementPresent(Element, seconds);
//        String Actual = getText(Element, seconds);
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(Actual, Expected);
//    }
//
//    /**
//     * Handle dropdown by visible text
//     * @param Element shows the specific drop down web element to select by value
//     * @param value - enter the value to be selected from dropdown
//     */
//    public void dropDownSelectByValue(WebElement Element, String value) {
//        Select select = new Select(Element);
//        select.selectByVisibleText(value);
//    }
//
//    /**
//     * Handle dropdown by visible index
//     * @param Element shows the specific drop down web element to select by index
//     * @param index - enter the index to be selected from dropdown
//     */
//    public void dropDownSelectByIndex(WebElement Element, int index) {
//        Select select = new Select(Element);
//        select.selectByIndex(index);
//    }
//
//    /**
//     * Gets text from attribute value inside tags of DOM
//     * @param Element shows the locator of the attribute
//     * @param Attribute retrieves value from this attribute
//     */
//    public String getAttributeValue(WebElement Element, String Attribute) {
//        String value = Element.getAttribute(Attribute);
//        return value;
//    }
//
//    /**
//     * Generates random 10 digit number for phone number
//     */
//    public String tenDigitNumber() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 10; i++) {
//            int randomDigit = random.nextInt(10);
//            sb.append(randomDigit);
//        }
//        String tenDigitNumber = sb.toString();
//        return tenDigitNumber;
//    }
//
//    /**
//     * Takes screenshot whenever called
//     * @param scenario mentions scenario in feature file
//     */
//    public void takeScreenshot(Scenario scenario) {
//        SimpleDateFormat datetime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
//        String date = datetime.format(new Date());
//        final byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot, "image/png", scenario.getName() + " " + date);
//    }
//}

////----------------

package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot; // Import TakesScreenshot
import org.openqa.selenium.WebDriver; // Import WebDriver
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * This Class contains common utilities such as to send text, waits, takes screenshots, etc.
 */
public class CommonMethods extends WebDriverConfig {

    public static WebDriverWait wait;

    private static final Random random = new Random();

    /**
     * Reads config.properties file.
     */
    public static Properties properties(){
        Properties prop = new Properties();
        try {
            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
            FileReader fileReader = new FileReader(filePath);
            prop.load(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * Gets the value from property file.
     * @param key value of the key mentioned in property file
     */
    public String readProp(String key){
        return properties().getProperty(key);
    }

    /**
     * Opens the browser mentioned in property file and maximizes it.
     */
    public void invokeBrowser(){
        String browser = readProp("Browser").toLowerCase();
        RemoteWebDriver driverInstance;
        switch (browser) {
            case "chrome":
                driverInstance = new ChromeDriver();
                break;
            case "edge":
                driverInstance = new EdgeDriver();
                break;
            case "firefox":
                driverInstance = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("The browser " + browser + " is not supported");
        }

        driverInstance.manage().window().maximize();
        WebDriverConfig.setDriver(driverInstance);
    }

    /**
     * Closes browser.
     */
    public void closeBrowser() throws IOException{
        WebDriver driverInstance = WebDriverConfig.getDriver();
        if(driverInstance != null){
            driverInstance.quit();
            WebDriverConfig.removeDriver();
        }
    }

    /**
     * Waits for Element to be attached to DOM.
     * @param Element shows the specific web element
     * @param seconds denotes the time to wait
     */
    public void waitTillElementPresent(WebElement Element, int seconds) {
        wait = new WebDriverWait(WebDriverConfig.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(Element));
    }

    /**
     * Waits for Element to be Clickable.
     * @param Element shows the specific web element
     * @param seconds denotes the time to wait
     */
    public void waitTillElementToBeClickable(WebElement Element, int seconds) {
        wait = new WebDriverWait(WebDriverConfig.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(Element));
    }

    /**
     * Clicks referred element.
     * @param Element shows the specific web element to be clicked
     * @param seconds denotes the time to wait
     */
    public void clickElement(WebElement Element, int seconds) {
        waitTillElementToBeClickable(Element, seconds);
        Element.click();
    }

    /**
     * Clears and send input to input field.
     * @param Element shows the specific web element to be enter text
     * @param seconds denotes the time to wait
     */
    public void sendText(WebElement Element, String text, int seconds) {
        clickElement(Element, seconds);
        Element.clear();
        Element.sendKeys(text);
    }

    /**
     * Gets Text from a Web Element.
     * @param Element shows the specific web element to get text
     * @param seconds denotes the time to wait
     */
    public String getText(WebElement Element, int seconds) {
        waitTillElementPresent(Element, seconds);
        String text = Element.getText();
        return text;
    }

    /**
     * Retrieves WebElement text values and matches with Expected String.
     * @param Element shows the specific web element to get text and to match with expected
     * @param Expected - enter the expected value
     * @param seconds denotes the time to wait
     */
    public void assertValues(WebElement Element, String Expected, int seconds) {
        waitTillElementPresent(Element, seconds);
        String Actual = getText(Element, seconds);
        Assert.assertEquals(Actual, Expected);
    }

    /**
     * Retrieves WebElement text values and matches with Expected, will not stop execution
     * @param Element shows the specific web element to get text and to match with expected
     * @param Expected - enter the expected value
     * @param seconds denotes the time to wait
     */
    public void softAssertValues(WebElement Element, String Expected, int seconds) {
        waitTillElementPresent(Element, seconds);
        String Actual = getText(Element, seconds);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Actual, Expected);
    }

    /**
     * Handle dropdown by visible text
     * @param Element shows the specific drop down web element to select by value
     * @param value - enter the value to be selected from dropdown
     */
    public void dropDownSelectByValue(WebElement Element, String value) {
        Select select = new Select(Element);
        select.selectByVisibleText(value);
    }

    /**
     * Handle dropdown by visible index
     * @param Element shows the specific drop down web element to select by index
     * @param index - enter the index to be selected from dropdown
     */
    public void dropDownSelectByIndex(WebElement Element, int index) {
        Select select = new Select(Element);
        select.selectByIndex(index);
    }

    /**
     * Gets text from attribute value inside tags of DOM
     * @param Element shows the locator of the attribute
     * @param Attribute retrieves value from this attribute
     */
    public String getAttributeValue(WebElement Element, String Attribute) {
        String value = Element.getAttribute(Attribute);
        return value;
    }

    /**
     * Generates random 10 digit number for phone number
     */
    public String tenDigitNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomDigit = random.nextInt(10);
            sb.append(randomDigit);
        }
        String tenDigitNumber = sb.toString();
        return tenDigitNumber;
    }

    /**
     * Takes screenshot whenever called
     * @param scenario mentions scenario in feature file
     */
    public void takeScreenshot(Scenario scenario) {
        SimpleDateFormat datetime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        String date = datetime.format(new Date());
        WebDriver driverInstance = WebDriverConfig.getDriver();
        final byte[] screenshot = ((TakesScreenshot) driverInstance).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName() + " " + date);
    }
}