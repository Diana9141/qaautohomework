package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTranslatePage {
    private final SelenideElement originalText = $x("//textarea[@aria-label=\"Текст оригіналу\"]");
    private final SelenideElement otherLanguagesButton = $x("(//button[@aria-label=\"Інші мови перекладу\"])[1]");
    private final SelenideElement translationText = $x("//span[@jsname='W297wb']");
    public SelenideElement languageCode;

    @Step("Open Google Page")
    public GoogleTranslatePage openGooglePage(String url) {
        open(url);
        return this;
    }

    @Step("Set text to translate")
    public void setTextToTranslate(String text) {
        originalText.sendKeys(text);
    }

    @Step("Set the language")
    public void setTheLanguage(String language) {
        languageCode = $x("(//div[@data-language-code='" + language + "'])[2]");
    }
    @Step("Choose Translation Language")
    public GoogleTranslatePage chooseTranslationLang(String language) {
        otherLanguagesButton.click();
        setTheLanguage(language);
        languageCode.doubleClick();
        return this;
    }
    @Step("Check translation")
    public void checkTranslation(String translation) {
        translationText.shouldHave(text(translation));
    }
}