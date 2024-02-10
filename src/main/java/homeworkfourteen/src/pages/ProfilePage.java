package homeworkfourteen.src.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    private final AppiumDriver driver;

    public ProfilePage(AppiumDriver driver) {
        this.driver = driver;
    }

    By navigation = AppiumBy.accessibilityId("Open navigation drawer");
    By importantMessages = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/hub_drawer_label_title\" and @text=\"Important\"]");
    By firstImportant = AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.gm:id/contact_image\"])[1]");
    By secondImportant = AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.gm:id/contact_image\"])[2]");
    By deleteBtn = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Delete\"]");

    public ProfilePage goToImportantSection() {
        WebElement navEl = driver.findElement(navigation);
        navEl.isDisplayed();
        navEl.click();
        WebElement impEl = driver.findElement(importantMessages);
        impEl.isDisplayed();
        impEl.click();
        return this;
    }

    public void deleteImportantMessage() {
        WebElement imp1 = driver.findElement(firstImportant);
        imp1.isDisplayed();
        imp1.click();
        WebElement imp2 = driver.findElement(secondImportant);
        imp2.isDisplayed();
        imp2.click();
        WebElement deleteEl = driver.findElement(deleteBtn);
        deleteEl.isDisplayed();
        deleteEl.click();
    }
}
