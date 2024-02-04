package hw12.src.test;

import com.browserup.bup.BrowserUpProxy;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import hw12.src.test.utils.DriverManager;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;


public class BaseTest {
    protected String testCaseName;
    protected BrowserUpProxy proxy;

    @BeforeMethod
    public void setUp(Method method) {
        this.testCaseName = method.getName();
        DriverManager.init(testCaseName);
        proxy = Objects.requireNonNull(WebDriverRunner.getSelenideProxy().getProxy());
        clearBrowserCookies();
        clearBrowserLocalStorage();

        Configuration.baseUrl = "https//:www.saucedemo.com/";
        Configuration.browserSize = "1920x1080";
        open();
    }
}
