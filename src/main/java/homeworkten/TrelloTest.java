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

    private final SelenideElement LOGIN_BUTTON = $(byText("Log in"));
    private final SelenideElement LOGIN_FIELD = $(byId("username"));
    private final SelenideElement PASS_FIELD = $(byId("password"));
    private final SelenideElement LOGIN_SUBMIT = $(byId("login-submit"));
    private final SelenideElement WORKSPACES_TITLE = $(".boards-page-section-header-name");
    private final SelenideElement DASHBOARD_BUTTON = $x("//a[@class=\"board-tile\"]");
    private final SelenideElement DASHBOARD_TITLE = $x("//h1[@data-testid=\"board-name-display\"]");

    private final SelenideElement ADD_A_CARD_BUTTON = $x("(//button[@data-testid=\"list-add-card-button\"])[1]");
    private final SelenideElement CARD_TITLE_FIELD = $x("//textarea[@data-testid=\"list-card-composer-textarea\"]");

    private final SelenideElement EDIT_TEST_CARD = $("li[data-testid=\"list-card\"]");
    private final SelenideElement DESCRIPTION_FAKE_AREA = $(".js-description-fake-text-area");
    private final SelenideElement DESCRIPTION_INPUT = $x("(//div[@id=\"ak-editor-textarea\"])[1]");
    private final SelenideElement CONFIRMATION_DESC_BUTTON = $(".confirm");
    private final SelenideElement DESCRIPTION_FIELD = $(".js-show-with-desc");

    private final SelenideElement COMMENT_INPUT = $("input[data-testid=\"card-back-new-comment-input-skeleton\"]");
    private final SelenideElement COMMENT_AREA = $x("(//div[@id=\"ak-editor-textarea\"])[2]");
    private final SelenideElement SAVE_COMMENT_BUTTON = $("button[data-testid=\"card-back-comment-save-button\"]");
    private final SelenideElement COMMENT_TEXT = $("div.current-comment > p");

    @BeforeMethod()
    public static void setUp() {
        Configuration.baseUrl = "https://trello.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 7000;
    }

    @Test()
    void trelloLogin() {
        open("");
        LOGIN_BUTTON.click();
        LOGIN_FIELD.setValue("diana.braun@gen.tech");
        LOGIN_SUBMIT.click();
        PASS_FIELD.setValue("19111994qa");
        LOGIN_SUBMIT.click();
        WORKSPACES_TITLE.shouldBe(visible).shouldHave(text("YOUR WORKSPACES"));
    }

    @Test(dependsOnMethods = "trelloLogin")
    void goToDashboard() {
        open("");
        LOGIN_BUTTON.click();
        LOGIN_FIELD.setValue("diana.braun@gen.tech");
        LOGIN_SUBMIT.click();
        PASS_FIELD.setValue("19111994qa");
        LOGIN_SUBMIT.click();
        WORKSPACES_TITLE.shouldBe(visible).shouldHave(text("YOUR WORKSPACES"));
        DASHBOARD_BUTTON.shouldBe(visible).click();
        DASHBOARD_TITLE.shouldHave(text("Моя дошка Trello"));
    }

    @Test(dependsOnMethods = "goToDashboard")
    void createTask() {
        open("");
        LOGIN_BUTTON.click();
        LOGIN_FIELD.setValue("diana.braun@gen.tech");
        LOGIN_SUBMIT.click();
        PASS_FIELD.setValue("19111994qa");
        LOGIN_SUBMIT.click();
        DASHBOARD_BUTTON.shouldBe(visible).click();
        ADD_A_CARD_BUTTON.click();
        CARD_TITLE_FIELD.sendKeys("Test Name");
        CARD_TITLE_FIELD.pressEnter().pressEnter();
        EDIT_TEST_CARD.shouldBe(visible);
    }

    @Test()
    void addDescriptionToTask() throws InterruptedException {
        open("");
        LOGIN_BUTTON.click();
        LOGIN_FIELD.setValue("diana.braun@gen.tech");
        LOGIN_SUBMIT.click();
        PASS_FIELD.setValue("19111994qa");
        LOGIN_SUBMIT.click();
        DASHBOARD_BUTTON.shouldBe(visible).click();
        ADD_A_CARD_BUTTON.click();
        CARD_TITLE_FIELD.sendKeys("Test Name");
        CARD_TITLE_FIELD.pressEnter().pressEnter();
        Thread.sleep(3000);
        EDIT_TEST_CARD.shouldBe(interactable).click();
        DESCRIPTION_INPUT.shouldBe(visible).click();
        DESCRIPTION_INPUT.setValue("Test Desc");
        CONFIRMATION_DESC_BUTTON.click();
        DESCRIPTION_FIELD.shouldHave(text("Test Desc"));
    }

    @Test()
    void addCommentToTask() throws InterruptedException {
        open("");
        LOGIN_BUTTON.click();
        LOGIN_FIELD.setValue("diana.braun@gen.tech");
        LOGIN_SUBMIT.click();
        PASS_FIELD.setValue("19111994qa");
        LOGIN_SUBMIT.click();
        DASHBOARD_BUTTON.shouldBe(visible).click();
        ADD_A_CARD_BUTTON.click();
        CARD_TITLE_FIELD.sendKeys("Test Name");
        CARD_TITLE_FIELD.pressEnter().pressEnter();
        Thread.sleep(3000);
        EDIT_TEST_CARD.shouldBe(interactable).click();
        COMMENT_INPUT.shouldBe(visible).click();
        COMMENT_AREA.sendKeys("Test Comment");
        SAVE_COMMENT_BUTTON.click();
        COMMENT_TEXT.shouldHave(text("Test Comment"));
    }

    @Test(dependsOnMethods = "addCommentToTask")
    void deleteTask() throws InterruptedException {
        open("");
        LOGIN_BUTTON.click();
        LOGIN_FIELD.setValue("diana.braun@gen.tech");
        LOGIN_SUBMIT.click();
        PASS_FIELD.setValue("19111994qa");
        LOGIN_SUBMIT.click();
        DASHBOARD_BUTTON.shouldBe(visible).click();
        ADD_A_CARD_BUTTON.click();
        CARD_TITLE_FIELD.sendKeys("Test Name");
        CARD_TITLE_FIELD.pressEnter().pressEnter();
        Thread.sleep(3000);
        EDIT_TEST_CARD.shouldBe(interactable).click();
        $("a.js-archive-card").click();
        $("a.js-delete-card").click();
        $("input.js-confirm").click();
        EDIT_TEST_CARD.should(disappear);
    }

    @AfterMethod
    public static void close() {
        WebDriverRunner.closeWebDriver();
    }
}
