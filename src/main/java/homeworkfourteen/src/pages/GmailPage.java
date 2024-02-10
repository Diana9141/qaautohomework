package homeworkfourteen.src.pages;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class GmailPage {
    private final AppiumDriver driver;

    public GmailPage(AppiumDriver driver) {
        this.driver = driver;
    }

    By gmailApp = AppiumBy.accessibilityId("Predicted app: Gmail");
    By addEmail = AppiumBy.id("com.google.android.gm:id/setup_addresses_add_another");
    By skipBtn = AppiumBy.id("com.google.android.gm:id/welcome_tour_skip");
    By googleOption = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/account_setup_label\" and @text=\"Google\"]");
    By emailField = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"identifierId\"]");
    By nextBtn = AppiumBy.xpath("//android.widget.Button[@text=\"Next\"]");
    By passField = AppiumBy.xpath("//android.widget.EditText");
    By agreeBtn = AppiumBy.xpath("//android.view.View[@resource-id=\"signinconsentNext\"]");
    By moreBtn = AppiumBy.xpath("//android.widget.Button[@text=\"MORE\"]");
    By acceptBtn = AppiumBy.xpath("//android.widget.Button[@text=\"ACCEPT\"]");
    By goTo = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/account_address\"]");
    By takeMeToGmail = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/action_done\"]");
    By nextBtn2 = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Next\"]");
    By tourDoneBtn = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.gm:id/welcome_tour_done\"]");

    public GmailPage gmailClick() {
        WebElement openGmail = driver.findElement(gmailApp);
        openGmail.isDisplayed();
        openGmail.click();
        WebElement skipEl = driver.findElement(skipBtn);
        skipEl.isDisplayed();
        skipEl.click();
        return this;
    }

    public GmailPage goToCredentials() {
        WebElement addEmailBtn = driver.findElement(addEmail);
        addEmailBtn.isDisplayed();
        addEmailBtn.click();
        WebElement googleOptionBtn = driver.findElement(googleOption);
        googleOptionBtn.isDisplayed();
        googleOptionBtn.click();
        return this;
    }

    public GmailPage setCredentials(String email, String pass) throws InterruptedException {
        WebElement emailFieldElement = driver.findElement(emailField);
        emailFieldElement.click();
        emailFieldElement.sendKeys(email);
        WebElement nextBtnElement = driver.findElement(nextBtn);
        nextBtnElement.isDisplayed();
        nextBtnElement.click();
        Thread.sleep(4000);
        WebElement passwordFieldElement = driver.findElement(passField);
        passwordFieldElement.click();
        passwordFieldElement.isDisplayed();
        passwordFieldElement.sendKeys(pass);
        WebElement nextBtnElement2 = driver.findElement(nextBtn);
        nextBtnElement2.isDisplayed();
        nextBtnElement2.click();
        return this;
    }

    public GmailPage agreeToTerms() {
        WebElement agreeBtnElement = driver.findElement(agreeBtn);
        agreeBtnElement.isDisplayed();
        agreeBtnElement.click();
        WebElement moreBtnElement = driver.findElement(moreBtn);
        moreBtnElement.isDisplayed();
        moreBtnElement.click();
        WebElement acceptBtnElement = driver.findElement(acceptBtn);
        acceptBtnElement.isDisplayed();
        acceptBtnElement.click();
        return this;
    }

    public ProfilePage goToProfile() {
        WebElement goToEl = driver.findElement(goTo);
        goToEl.isDisplayed();
        goToEl.click();
        WebElement takeMe = driver.findElement(takeMeToGmail);
        takeMe.isDisplayed();
        takeMe.click();
        WebElement nextEl = driver.findElement(nextBtn2);
        nextEl.isDisplayed();
        nextEl.click();
        WebElement tourDone = driver.findElement(tourDoneBtn);
        tourDone.isDisplayed();
        tourDone.click();
        WebElement takeMe2 = driver.findElement(takeMeToGmail);
        takeMe2.isDisplayed();
        takeMe2.click();
        WebElement nextEl3 = driver.findElement(nextBtn2);
        nextEl3.click();
        WebElement tourDone2 = driver.findElement(tourDoneBtn);
        tourDone2.click();
        WebElement takeMe3 = driver.findElement(takeMeToGmail);
        takeMe3.click();
        return new ProfilePage(driver);
    }
}