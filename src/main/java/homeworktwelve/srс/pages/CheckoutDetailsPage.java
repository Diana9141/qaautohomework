package homeworktwelve.srс.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutDetailsPage {
    private final SelenideElement title = $("span.title");
    private final SelenideElement firstNameField = $("#first-name");
    private final SelenideElement lastNameField = $("#last-name");
    private final SelenideElement postCodeField = $("#postal-code");
    private final SelenideElement continueButton = $("#continue");
    private final SelenideElement cancelButton = $("#cancel");

    public CheckoutOverviewPage fillDetails(String firstName, String lastName, String postCode) {
        firstNameField.setValue(firstName);
        lastNameField.setValue(lastName);
        postCodeField.setValue(postCode);
        continueButton.click();
        return new CheckoutOverviewPage();
    }
}
