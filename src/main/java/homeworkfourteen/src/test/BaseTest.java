package homeworkfourteen.src.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import homeworkfourteen.driver.Emulator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class BaseTest {

    @BeforeMethod
    static void open() {
        closeWebDriver();
        Configuration.browserSize = null;
        Configuration.browser = Emulator.class.getName();
        Configuration.timeout = 30000;
        WebDriverRunner.addListener(new WebDriverListener() {
            @Override
            public void beforeClick(WebElement element) {
                WebDriverListener.super.beforeClick(element);
            }
        });
        Selenide.open();
    }
}