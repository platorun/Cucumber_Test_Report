package steps;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tests.TestBase;

import java.io.IOException;

public class Hooks {
    @After
    public static void tearDown(Scenario scenario) throws InterruptedException, IOException, Throwable {

        if(scenario.isFailed()) {

            byte[] screenShot = null;
            if (TestBase.webDriver != null) {
                screenShot = ((TakesScreenshot) TestBase.webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenShot, "image/png", scenario.getName());
            }
        }
        TestBase.tearDown();
    }
}
