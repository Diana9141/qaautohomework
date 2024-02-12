package homeworkten;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TrelloTest {
    private static final SelenideElement loginButton = $(byText("Log in"));
    private static final SelenideElement loginField = $(byId("username"));
    private static final SelenideElement passField = $(byId("password"));
    private static final SelenideElement loginSubmit = $(byId("login-submit"));
    private final SelenideElement workspaceTitle = $(".boards-page-section-header-name");
    private final SelenideElement dashboardBtn = $x("//a[@class=\"board-tile\"]");
    private final SelenideElement dashboardTitle = $x("//h1[@data-testid=\"board-name-display\"]");
    private final SelenideElement addCardButton = $x("(//button[@data-testid=\"list-add-card-button\"])[1]");
    private final SelenideElement cardTitleField = $x("//textarea[@data-testid=\"list-card-composer-textarea\"]");
    private final SelenideElement editTestCard = $("li[data-testid=\"list-card\"]");
    private final SelenideElement descriptionInput = $x("(//div[@id=\"ak-editor-textarea\"])[1]");
    private final SelenideElement confirmationDescButton = $(".confirm");
    private final SelenideElement descriptionField = $(".js-show-with-desc");
    private final SelenideElement commentInput = $("input[data-testid=\"card-back-new-comment-input-skeleton\"]");
    private final SelenideElement commentArea = $x("(//div[@id=\"ak-editor-textarea\"])[2]");
    private final SelenideElement saveCommentBtn = $("button[data-testid=\"card-back-comment-save-button\"]");
    private final SelenideElement commentText = $("div.current-comment > p");
    private final SelenideElement archiveCardBtn = $("a.js-archive-card");
    private final SelenideElement deleteCardBtn = $("a.js-delete-card");
    private final SelenideElement confirmDeleteBtn = $("input.js-confirm");

    public static void login() {
        open("");
        loginButton.click();
        loginField.setValue("diana.braun@gen.tech");
        loginSubmit.click();
        passField.setValue("19111994qa");
        loginSubmit.click();
    } //can also be done with cookies insert

    @BeforeMethod
    public static void setUp() {
        Configuration.baseUrl = "https://trello.com/";
        Configuration.browserSize = "1920x1080";
        login();
    }

    @Test()
    void goToDashboard() {
        workspaceTitle.shouldBe(visible);
        dashboardBtn.shouldBe(visible).click();
        dashboardTitle.shouldHave(text("Моя дошка Trello"));
    }

    @Test(dependsOnMethods = "goToDashboard")
    void createTask() {
        dashboardBtn.shouldBe(visible).click();
        addCardButton.click();
        cardTitleField.sendKeys("Test Name");
        cardTitleField.pressEnter().pressEnter();
        editTestCard.shouldBe(visible);
    }

    @Test(dependsOnMethods = "createTask")
    void addDescriptionToTask() {
        dashboardBtn.shouldBe(visible).click();
        editTestCard.shouldBe(interactable).click();
        descriptionInput.shouldBe(visible).click();
        descriptionInput.setValue("Test Desc");
        confirmationDescButton.click();
        descriptionField.shouldHave(text("Test Desc"));
    }

    @Test(dependsOnMethods = "addDescriptionToTask")
    void addCommentToTask() {
        dashboardBtn.shouldBe(visible).click();
        editTestCard.shouldBe(interactable).click();
        commentInput.shouldBe(visible).click();
        commentArea.sendKeys("Test Comment");
        saveCommentBtn.click();
        commentText.shouldHave(text("Test Comment"));
    }

    @Test(dependsOnMethods = "addCommentToTask")
    void deleteTask() {
        dashboardBtn.shouldBe(visible).click();
        editTestCard.shouldBe(interactable).click();
        archiveCardBtn.click();
        deleteCardBtn.click();
        confirmDeleteBtn.click();
        editTestCard.should(disappear);
    }

    @AfterMethod
    public static void close() {
        WebDriverRunner.closeWebDriver();
    }
}