package hw12.src.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ThankYouPage {
    private final SelenideElement successText = $("h2.complete-header");

    public void checkSuccessText() {
        successText.shouldHave(text("Thank you for your order!"));
    }
}
