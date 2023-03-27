package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(
        features = "src/test/resources/features/OnlineShopping.feature",
        glue = {"steps"},
        plugin = {"pretty",
                "html:Reports/HTMLReports/cucumber_test_report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = ("@SeleniumWebTesting"))
public class OnlineShoppingRunner extends TestBase {
}
