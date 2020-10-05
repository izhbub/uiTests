package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CabinetPage extends AbstractPages {

    private String okMessage;

    public CabinetPage(WebDriver driver) { super(driver); }

    public String getOkMessage() {
        String okMessage = driver.findElement(By.xpath("//*[@ng-tr=\"TEW.TEW1\"]")).getText();
        return okMessage;
    }

}
