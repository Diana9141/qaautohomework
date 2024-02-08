package homeworktwelve.srс.test;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;


public class BaseTest {

    @BeforeMethod
    public static void setUp() {
        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.browserSize = "1920x1080";
        open("");
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }
}
