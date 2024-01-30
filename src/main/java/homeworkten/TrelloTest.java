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
    private static final SelenideElement LOGIN_BUTTON = $(byText("Log in"));
    private static final SelenideElement LOGIN_FIELD = $(byId("username"));
    private static final SelenideElement PASS_FIELD = $(byId("password"));
    private static final SelenideElement LOGIN_SUBMIT = $(byId("login-submit"));
    private final SelenideElement WORKSPACES_TITLE = $(".boards-page-section-header-name");
    private final SelenideElement DASHBOARD_BUTTON = $x("//a[@class=\"board-tile\"]");
    private final SelenideElement DASHBOARD_TITLE = $x("//h1[@data-testid=\"board-name-display\"]");
    private final SelenideElement ADD_A_CARD_BUTTON = $x("(//button[@data-testid=\"list-add-card-button\"])[1]");
    private final SelenideElement CARD_TITLE_FIELD = $x("//textarea[@data-testid=\"list-card-composer-textarea\"]");
    private final SelenideElement EDIT_TEST_CARD = $("li[data-testid=\"list-card\"]");
    private final SelenideElement DESCRIPTION_INPUT = $x("(//div[@id=\"ak-editor-textarea\"])[1]");
    private final SelenideElement CONFIRMATION_DESC_BUTTON = $(".confirm");
    private final SelenideElement DESCRIPTION_FIELD = $(".js-show-with-desc");
    private final SelenideElement COMMENT_INPUT = $("input[data-testid=\"card-back-new-comment-input-skeleton\"]");
    private final SelenideElement COMMENT_AREA = $x("(//div[@id=\"ak-editor-textarea\"])[2]");
    private final SelenideElement SAVE_COMMENT_BUTTON = $("button[data-testid=\"card-back-comment-save-button\"]");
    private final SelenideElement COMMENT_TEXT = $("div.current-comment > p");
    private final SelenideElement ARCHIVE_CARD_BUTTON = $("a.js-archive-card");
    private final SelenideElement DELETE_CARD_BUTTON = $("a.js-delete-card");
    private final SelenideElement DELETE_CONFIRM_BUTTON = $("input.js-confirm");

    @BeforeMethod()
    public static void setUp() {
        Configuration.baseUrl = "https://trello.com/";
        Configuration.browserSize = "1920x1080";
        open("");
        LOGIN_BUTTON.click();
        LOGIN_FIELD.setValue("diana.braun@gen.tech");
        LOGIN_SUBMIT.click();
        PASS_FIELD.setValue("19111994qa");
        LOGIN_SUBMIT.click();
    }

    @Test()
    void goToDashboard() {
        WORKSPACES_TITLE.shouldBe(visible);
        DASHBOARD_BUTTON.shouldBe(visible).click();
        DASHBOARD_TITLE.shouldHave(text("Моя дошка Trello"));
    }

    @Test(dependsOnMethods = "goToDashboard")
    void createTask() {
        DASHBOARD_BUTTON.shouldBe(visible).click();
        ADD_A_CARD_BUTTON.click();
        CARD_TITLE_FIELD.sendKeys("Test Name");
        CARD_TITLE_FIELD.pressEnter().pressEnter();
        EDIT_TEST_CARD.shouldBe(visible);
    }

    @Test(dependsOnMethods = "createTask")
    void addDescriptionToTask() {
        DASHBOARD_BUTTON.shouldBe(visible).click();
        EDIT_TEST_CARD.shouldBe(interactable).click();
        DESCRIPTION_INPUT.shouldBe(visible).click();
        DESCRIPTION_INPUT.setValue("Test Desc");
        CONFIRMATION_DESC_BUTTON.click();
        DESCRIPTION_FIELD.shouldHave(text("Test Desc"));
    }

    @Test(dependsOnMethods = "addDescriptionToTask")
    void addCommentToTask() {
        DASHBOARD_BUTTON.shouldBe(visible).click();
        EDIT_TEST_CARD.shouldBe(interactable).click();
        COMMENT_INPUT.shouldBe(visible).click();
        COMMENT_AREA.sendKeys("Test Comment");
        SAVE_COMMENT_BUTTON.click();
        COMMENT_TEXT.shouldHave(text("Test Comment"));
    }

    @Test(dependsOnMethods = "addCommentToTask")
    void deleteTask() {
        DASHBOARD_BUTTON.shouldBe(visible).click();
        EDIT_TEST_CARD.shouldBe(interactable).click();
        ARCHIVE_CARD_BUTTON.click();
        DELETE_CARD_BUTTON.click();
        DELETE_CONFIRM_BUTTON.click();
        EDIT_TEST_CARD.should(disappear);
    }

    @AfterMethod
    public static void close() {
        WebDriverRunner.closeWebDriver();
    }
}