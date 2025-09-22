package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features/LoginPage.feature",         // ✅ Feature files location
        glue = "StepDefinitions",          // ✅ Step definitions package
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",           // ✅ HTML report
                "json:target/cucumber.json",                   // ✅ JSON report
                "rerun:target/rerun.txt"                       // ✅ Failed scenarios
        },
        monochrome = true,
        dryRun = false
//        tags = "@TC003"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // No need to override anything unless customizing parallel execution
}