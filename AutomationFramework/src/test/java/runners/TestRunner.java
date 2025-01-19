package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Runner class to glue step definition and feature files.
 * Includes Cucumber options
 */
@CucumberOptions(features = "src/test/resources/features", glue = {"stepDefinitions","hooks"},
                    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                    "pretty", "html:Test-Results/CucumberReports/Results.html"},
                    //tags = "@CreateUser",
                    dryRun = false,
                    snippets = CucumberOptions.SnippetType.CAMELCASE,
                    monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
