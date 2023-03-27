package pageObjects;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class OnlineShoppingAppPage extends PageBase {
    public OnlineShoppingAppPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "user-name")
    WebElement UserName;
    @FindBy(id = "password")
    WebElement Password;
    @FindBy(id ="login-button")
    WebElement BtnLogin;
    public void performLogin(String _username, String _password) {
        sendText("ID","user-name", _username);
        sendText("ID","password", _password);
        click("CSS","*[data-test='login-button']");
    }
    public void addItemsToCart(String inventoryItem) {
        click("LINKTEXT",inventoryItem);
        click("CSS","*[data-test='add-to-cart-sauce-labs-bike-light']");
    }
    public void checkOutAndFillShippingInformation(String firstName, String lastName, String postalCode) {
        click("XPATH","//*[@id='shopping_cart_container']/a");
        click("XPATH","//button[contains(text(),'Checkout')]");
        sendText("XPATH","//*[@id='first-name']",firstName);
        sendText("XPATH","//*[@id='last-name']",lastName);
        sendText("XPATH","//*[@id='postal-code']",postalCode);
        click("XPATH","//*[@id='continue']");
    }
    public void completeTransaction() {
        click("XPATH","//*[@id='finish']");
    }
    public void verifyConfirmationMessage(String msgConfirm) {
        String txtResult = getAttribute("XPATH", "//h2");
        /* Thank you for your order! */
        Assert.assertEquals(txtResult,msgConfirm);
    }
}
