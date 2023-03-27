package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    WebDriver webDriver;
    WebElement testWebElement;
    public static final long WAIT = 10;
    public PageBase(WebDriver web_driver){
        webDriver = web_driver;
    }
    public boolean waitForVisibility(String ByWhat, String elementName){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, WAIT);
            switch (ByWhat) {
                case "XPATH":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
                    testWebElement = webDriver.findElement(By.xpath(elementName));
                    break;
                case "ID":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementName)));
                    testWebElement = webDriver.findElement(By.id(elementName));
                    break;
                case "LINKTEXT":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elementName)));
                    testWebElement = webDriver.findElement(By.linkText(elementName));
                    break;
                case "CSS":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementName)));
                    testWebElement = webDriver.findElement(By.cssSelector(elementName));
                    break;
            }
            Thread.sleep(500);
            return true;
        } catch (TimeoutException | InterruptedException e) {
            return false;
        }
    }
    public void click(String ByWhat, String ElementName){
        if (waitForVisibility(ByWhat,ElementName)) {

            Capabilities capabilities = ((RemoteWebDriver)webDriver).getCapabilities();
            switch (capabilities.getBrowserName().toUpperCase()) {
                case "MSEDGE":
                case "CHROME":
                    testWebElement.click();
                    break;
                case "FIREFOX":
                    Actions act = new Actions(webDriver);
                    act.moveToElement(testWebElement);
                    WebDriverWait wait = new WebDriverWait(webDriver, 10);
                    wait.until(ExpectedConditions.elementToBeClickable(testWebElement));
                    JavascriptExecutor executor  = (JavascriptExecutor)webDriver;
                    executor.executeScript("arguments[0].scrollIntoView();",testWebElement);
                    act.click().perform();
                    break;
            }
        }
        else
            throw new TimeoutException("Timeout locating " + ByWhat + " element " + ElementName);
    }
    public void sendText(String ByWhat, String ElementName, String TextToSend){
        if (waitForVisibility(ByWhat, ElementName)) {
            testWebElement.sendKeys(TextToSend);
        } else
            throw new TimeoutException("Timeout locating " + ByWhat + " element " + ElementName);
    }
    public String getAttribute(String byWhat, String elementName){
        if (waitForVisibility(byWhat, elementName))
            return testWebElement.getText();
        else
            return "";
    }
}
