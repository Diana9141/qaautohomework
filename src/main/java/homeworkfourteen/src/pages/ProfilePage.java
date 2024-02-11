package homeworkfourteen.src.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;


public class ProfilePage {

    private final SelenideElement navigation = $(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]"));
    private final SelenideElement importantMessages = $(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/hub_drawer_label_title\" and @text=\"Important\"]"));
    private final SelenideElement firstImportant = $(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.gm:id/contact_image\"])[1]"));
    private final SelenideElement secondImportant = $(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.gm:id/contact_image\"])[2]"));
    private final SelenideElement deleteBtn = $(By.xpath("//android.widget.Button[@content-desc=\"Delete\"]"));
    private final SelenideElement fourthMessage = $(By.xpath("(//android.widget.TextView[@resource-id=\"com.google.android.gm:id/senders\"])[4]"));

    private final SelenideElement fifthMessage = $(By.xpath("(//android.widget.TextView[@resource-id=\"com.google.android.gm:id/senders\"])[5]"));

    public ProfilePage goToImportantSection() {
        navigation.click();
        importantMessages.click();
        return this;
    }

    public ProfilePage deleteImportantMessage() {
        firstImportant.click();
        secondImportant.click();
        deleteBtn.click();
        return this;
    }

    public void checkMessagesDeleted() {
        Assert.assertFalse(fourthMessage.exists());
        Assert.assertFalse(fifthMessage.exists());
    }
}