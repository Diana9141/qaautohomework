package homeworkfourteen.src.pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class GmailPage {

    private final SelenideElement gmailApp = $(By.xpath("//android.widget.TextView[@content-desc=\"Predicted app: Gmail\"]"));
    private final SelenideElement addEmail = $(By.id("com.google.android.gm:id/setup_addresses_add_another"));
    private final SelenideElement skipBtn = $(By.id("com.google.android.gm:id/welcome_tour_skip"));
    private final SelenideElement googleOption = $(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/account_setup_label\" and @text=\"Google\"]"));
    private final SelenideElement emailField = $(By.xpath("//android.widget.EditText[@resource-id=\"identifierId\"]"));
    private final SelenideElement nextBtn = $(By.xpath("//android.widget.Button[@text=\"Next\"]"));
    private final SelenideElement passField = $(By.xpath("//android.widget.EditText"));
    private final SelenideElement agreeBtn = $(By.xpath("//android.view.View[@resource-id=\"signinconsentNext\"]"));
    private final SelenideElement moreBtn = $(By.xpath("//android.widget.Button[@text=\"MORE\"]"));
    private final SelenideElement acceptBtn = $(By.xpath("//android.widget.Button[@text=\"ACCEPT\"]"));
    private final SelenideElement goTo = $(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/account_address\"]"));
    private final SelenideElement takeMeToGmail = $(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/action_done\"]"));
    private final SelenideElement nextBtn2 = $(By.xpath("//android.widget.ImageView[@content-desc=\"Next\"]"));
    private final SelenideElement tourDoneBtn = $(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/welcome_tour_done\"]"));

    public GmailPage gmailClick() {
        gmailApp.click();
        skipBtn.click();
        return this;
    }

    public GmailPage goToCredentials() {
        addEmail.click();
        googleOption.click();
        return this;
    }

    public GmailPage setCredentials(String email, String pass) {
        emailField.shouldBe(visible).click();
        emailField.sendKeys(email);
        nextBtn.click();
        passField.shouldBe(visible).click();
        passField.sendKeys(pass);
        nextBtn.click();
        return this;
    }

    public GmailPage agreeToTerms() {
        agreeBtn.shouldBe(visible).click();
        moreBtn.shouldBe(visible).click();
        acceptBtn.click();
        return this;
    }

    public void goToProfile() {
        goTo.click();
        takeMeToGmail.click();
        nextBtn2.click();
        tourDoneBtn.click();
        takeMeToGmail.click();
        nextBtn2.click();
        tourDoneBtn.click();
        takeMeToGmail.click();
    }
}