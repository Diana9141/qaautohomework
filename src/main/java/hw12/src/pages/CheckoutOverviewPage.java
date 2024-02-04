package hw12.src.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage {
    private final SelenideElement taxInfo = $("div.summary_tax_label");
    private final SelenideElement finishButton = $("#finish");

    public ThankYouPage outputTax() {
        System.out.println(taxInfo.text());
        finishButton.click();
        return new ThankYouPage();
    }
}
