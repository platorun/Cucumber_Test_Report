package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver webDriver;
    public static void webSetup(String browserApp) {
        switch (browserApp) {
            case "MSEDGE":
                /* Version 111 */
                System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
                webDriver = new EdgeDriver();
                break;
            case "FIREFOX":
                /* Version 111 */
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            case "CHROME":
                /* Version 111 */
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
        }
        webDriver.manage().window().maximize();
        webDriver.get("https://www.saucedemo.com/");
    }
    public static void tearDown() throws InterruptedException {
        if (webDriver != null){
            Thread.sleep(1000);
            webDriver.quit();
            webDriver = null;
        }
    }
}
