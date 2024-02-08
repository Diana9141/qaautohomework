package hw12.srс.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    private final SelenideElement productTitle1 = $("#item_2_title_link");
    private final SelenideElement productTitle2 = $("#item_0_title_link");
    private final SelenideElement checkoutButton = $("#checkout");
    private final SelenideElement continueShoppingBtn = $("#continue-shopping");
    private final ElementsCollection productDescriptions = $$("div.inventory_item_desc");
    private final SelenideElement removeBtn = $("#remove-sauce-labs-backpack");
    private final ElementsCollection prices = $$("div.inventory_item_price");

    @Step("Check the exact titles pf products in the cart")
    public void checkProductsTitle(String title1, String title2) {
        productTitle1.shouldHave(text(title1));
        productTitle2.shouldHave(text(title2));
    }

    @Step("Go to checkout details")
    public CheckoutDetailsPage goToCheckoutDetails() {
        checkoutButton.click();
        return new CheckoutDetailsPage();
    }
}
