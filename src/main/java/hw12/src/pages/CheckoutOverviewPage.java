package hw12.src.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CheckoutOverviewPage {
    private final SelenideElement title = $("span.title");
    private final SelenideElement taxInfo = $("div.summary_tax_label");
    private final SelenideElement finishButton = $("#finish");
    private final ElementsCollection prices = $$("div.inventory_item_price");
    private final ElementsCollection descriptions = $$("div.inventory_item_desc");
    private final ElementsCollection paymentAndShipInfo = $$(".summary_value_label");
    private final SelenideElement totalPriceWithoutTax = $("div.summary_subtotal_label");
    private final SelenideElement totalPrice = $x("//div[@class=\"summary_info_label summary_total_label\"]");
    private final SelenideElement cancelButton = $("#cancel");

    public ThankYouPage outputTax() {
        System.out.println(taxInfo.text());
        finishButton.click();
        return new ThankYouPage();
    }
}
