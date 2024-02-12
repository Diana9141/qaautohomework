package homeworkfourteen.driver;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Emulator implements WebDriverProvider {


    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_3a");
        options.setPlatformName("android");
        options.setAutomationName("uiautomator2");
        options.setNewCommandTimeout(Duration.ofSeconds(11));
        options.setFullReset(false);

        try {
            return new AndroidDriver(new URL("http://192.168.0.102:4723/"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}