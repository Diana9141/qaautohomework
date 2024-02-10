package homeworkfourteen.src.test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class BaseTest {
    public AndroidDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_3a");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver(new URL("http://192.168.0.102:4723/"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
