package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPages {

    //@FindBy(id = "header-lk-button")
    //private WebElement submitButton;
    //@FindBy(xpath = "//*[@ng-click='openLoginModal()']")
    //data-testid="Login menu button"
    @FindBy(xpath = "//*[@data-testid=\"Login menu button\"]")
    private WebElement submitButton;

    public MainPage(WebDriver driver) { super(driver); }

    public void open() {
        driver.get("https://test.uxcrowd.ru/");
    }
    public void submit() {
        submitButton.click();
    }

}