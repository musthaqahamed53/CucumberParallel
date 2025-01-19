//package utils;
//
//import org.openqa.selenium.remote.RemoteWebDriver;
//
///**
// * Declares the driver to initialised to be used across the framework.
// */
//public class WebDriverConfig {
//    public static RemoteWebDriver driver;
//
//}


//------------
package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Declares the driver to be initialized to be used across the framework.
 */
public class WebDriverConfig {
    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(RemoteWebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void removeDriver() {
        driver.remove();
    }
}