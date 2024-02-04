package hw12.src.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutDetailsPage {
    private final SelenideElement title = $("span.title");
    private final SelenideElement firstNameField = $("#first-name");
    private final SelenideElement lastNameField = $("#last-name");
    private final SelenideElement postCodeField = $("#postal-code");
    private final SelenideElement continueButton = $("#continue");
    private final SelenideElement cancelButton = $("#cancel");

    public CheckoutOverviewPage fillDetails() {
        firstNameField.setValue("Test");
        lastNameField.setValue("Test");
        postCodeField.setValue("00000");
        continueButton.click();
        return new CheckoutOverviewPage();
    }
}
