package hw12.src.test;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;


import java.net.MalformedURLException;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;


public class BaseTest {


    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("sessionTimeout", "15m");
            put("enableVNC", true);
            put("enableVideo", false);
        }});

        Configuration.browserCapabilities = options;
        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://localhost:4444/wd/hub";
        open("");
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }
}
