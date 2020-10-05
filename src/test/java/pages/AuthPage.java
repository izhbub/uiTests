package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends AbstractPages {

    @FindBy(css = "input[name=\"login\"]")
    private WebElement inputLogin;
    @FindBy(css = "input[name=\"password\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@data-testid=\"Login button\"]")
    private WebElement loginButton;

    public AuthPage(WebDriver driver) { super(driver); }

    public AuthPage sendDataAuth(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        return this;
    }
    public void submitAuth() {
        loginButton.click();
    }
}
