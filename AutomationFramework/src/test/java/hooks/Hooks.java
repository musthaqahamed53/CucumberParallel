//package hooks;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.ITestListener;
//import utils.CommonMethods;
//import utils.WebDriverConfig;
//import java.io.IOException;
//
//
//public class Hooks extends WebDriverConfig implements ITestListener {
//
//    CommonMethods common = new CommonMethods();
//    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
//
//    /**
//     * @Before perform before operations which is to open browser.
//     */
//    @Before
//    public void invokeURL() throws IOException {
//
//        common.invokeBrowser();
//
//        LOGGER.info("Launching browser and invoking URL");
//    }
//
//    /**
//     * @After hooks to perform after operations to close browser.
//     */
//    @After
//    public void tearDown() throws IOException {
//        common.closeBrowser();
//
//        LOGGER.info("Closing Browser");
//    }
//
//    /**
//     * @AfterStep method is used to add screenshots to Extent reports
//     * @param scenario takes after each step in a scenario
//     */
//    @AfterStep
//    public void attach_screenshot(Scenario scenario){
//        common.takeScreenshot(scenario);
//    }
//}


//-----------

package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import utils.CommonMethods;
import utils.WebDriverConfig;
import java.io.IOException;

public class Hooks extends WebDriverConfig implements ITestListener {

    CommonMethods common = new CommonMethods();
    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);

    /**
     * @Before perform before operations which is to open browser.
     */
    @Before
    public void invokeURL() throws IOException {
        common.invokeBrowser();
        LOGGER.info("Launching browser and invoking URL");
    }

    /**
     * @After hooks to perform after operations to close browser.
     */
    @After
    public void tearDown() throws IOException {
        common.closeBrowser();
        LOGGER.info("Closing Browser");
    }

    /**
     * @AfterStep method is used to add screenshots to Extent reports
     * @param scenario takes after each step in a scenario
     */
    @AfterStep
    public void attach_screenshot(Scenario scenario){
        common.takeScreenshot(scenario);
    }
}