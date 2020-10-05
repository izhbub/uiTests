import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.CabinetPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class startTests {
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\_work\\_pflab\\soft\\chromedriver_win32\\chromedriver.exe");
    }

    private WebDriver driver;
    private WebDriverWait WebDriverWait;

    public final String login = "buben@ultra-web.ru";
    //public final String password = "wgkHTh"; // good password
    public final String password = "wgkHTh1";

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //WebDriverWait = new WebDriverWait(driver,20L);
    }

    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void startTests () {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.submit();
        AuthPage authPage = new AuthPage(driver);
        authPage.sendDataAuth(login, password);
        authPage.submitAuth();
        pause(1000);
        //System.out.println(authPage.getErrorAuth().isDisplayed());
        //System.out.println(authPage.getErrorAuth().size());
        assert (authPage.getErrorAuth().size() == 0) : "Ошибка авторизации, не верный логин или пароль.";
        CabinetPage cabinetPage = new CabinetPage(driver);
        pause(1000);
        //System.out.println(cabinetPage.getOkMessage());
        assert cabinetPage.getOkMessage().equals("ДОБРЫЙ ДЕНЬ!"): "Ошибка! Элемент личного кабинета не найден или изменен.";
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
