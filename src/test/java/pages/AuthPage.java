package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AuthPage extends AbstractPages {

    @FindBy(css = "input[name=\"login\"]")
    private WebElement inputLogin;
    @FindBy(css = "input[name=\"password\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@data-testid=\"Login button\"]")
    private WebElement loginButton;

    //@FindBy(xpath = "//*[@ng-show=\"authenticationError\"]")
    //private WebElement errorMessage;

    //@FindBy(xpath = "//*[@class=\"error-block\"]")
    //private WebElement errorMessage123;

    public AuthPage(WebDriver driver) { super(driver); }

    public AuthPage sendDataAuth(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        return this;
    }

    public List<WebElement> getErrorAuth (){
        List<WebElement> erorrElements = driver.findElements(By.xpath("//*[@class=\"error-block\"]"));
        return erorrElements;
    }

    public void submitAuth() {
        loginButton.click();
    }
}
