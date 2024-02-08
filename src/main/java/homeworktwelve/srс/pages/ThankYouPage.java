package homeworktwelve.srс.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ThankYouPage {
    private final SelenideElement title = $("span.title");
    private final SelenideElement successText = $("h2.complete-header");
    private final SelenideElement backHomeButton = $("#back-to-products");
    private final SelenideElement description = $("div.complete-text");

    public void checkSuccessText() {
        successText.shouldHave(text("Thank you for your order!"));
    }
}
