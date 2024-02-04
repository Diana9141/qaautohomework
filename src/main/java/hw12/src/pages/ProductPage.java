package hw12.src.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private final SelenideElement product1 = $("#add-to-cart-sauce-labs-onesie");
    private final SelenideElement product2 = $("#add-to-cart-sauce-labs-bike-light");
    private final SelenideElement cartIcon = $("#shopping_cart_container");

    public ProductPage addProducts() {
        product1.click();
        product2.click();
        return this;
    }

    public CartPage goToCart() {
        cartIcon.click();
        return new CartPage();
    }
}
