package hw12.srс.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;

@Getter
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
        double sumOfTax = Double.parseDouble(taxInfo.text().substring(6));
        double priceWithout = Double.parseDouble(totalPriceWithoutTax.text().substring(13));
        double taxPercent = (sumOfTax / priceWithout) * 100;
        String roundedDouble = String.format("%.2f", taxPercent);
        System.out.println("Tax percent is: " + roundedDouble);
        finishButton.click();
        return new ThankYouPage();
    }
}
