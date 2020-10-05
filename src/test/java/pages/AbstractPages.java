package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPages {
    protected WebDriver driver;

    public AbstractPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
