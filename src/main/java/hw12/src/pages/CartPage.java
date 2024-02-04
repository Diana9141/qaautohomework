package hw12.src.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement productTitle1 = $("#item_2_title_link");
    private final SelenideElement productTitle2 = $("#item_0_title_link");
    private final SelenideElement checkoutButton = $("#checkout");

    public CartPage checkCart() {
        productTitle1.shouldBe(visible);
        productTitle2.shouldBe(visible);
        return this;
    }

    public CheckoutDetailsPage goToCheckoutDetails() {
        checkoutButton.click();
        return new CheckoutDetailsPage();
    }
}
