package hw12.src.test.utils;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.client.ClientUtil;
import com.browserup.bup.proxy.CaptureType;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.WebDriverRunner;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Objects;

@UtilityClass
public class DriverManager {
    public static void init(String testName) {
        initDriver(testName);
    }

    private static void initDriver(String testName) {
        configSelenide(testName);
        var proxy = configProxy();
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT);
    }

    public static BrowserUpProxy configProxy() {
        return Objects.requireNonNull(WebDriverRunner.getSelenideProxy()).getProxy();
    }

    public static void configSelenide(String testName) {
        Configuration.proxyEnabled = true;
        Configuration.proxyHost = String.valueOf(ClientUtil.getConnectableAddress());
        Configuration.fileDownload = FileDownloadMode.PROXY;
        setConfiguration(testName);
    }

    public static void setConfiguration(String testName) {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.headless = false;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
        Configuration.reportsFolder = "test-result/reports";
        Configuration.timeout = 4000;
        Configuration.browserCapabilities = capabilities(testName);
    }

    public static DesiredCapabilities capabilities(String testName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("videoName", testName + ".mp4");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("sessionTimeout", "2m");
        capabilities.setCapability("timeZone", "Europe/Kyiv");
        capabilities.setCapability("goog:chromeOptions", options);

        return capabilities;
    }
}