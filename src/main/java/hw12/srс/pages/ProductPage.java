package hw12.srс.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    private final SelenideElement product1 = $("#add-to-cart-sauce-labs-onesie");
    private final SelenideElement product2 = $("#add-to-cart-sauce-labs-bike-light");
    private final ElementsCollection descriptions =  $$("div.inventory_item_descdiv.inventory_item_desc");
    private final ElementsCollection prices = $$("div.inventory_item_price");
    private final ElementsCollection images = $$("div.inventory_item_img");
    private final SelenideElement cartIcon = $("#shopping_cart_container");
    private final SelenideElement burgerMenu = $("#react-burger-menu-btn");
    private final SelenideElement productSortDropdown = $("select.product_sort_container");
    private final SelenideElement removeBtn =  $("#remove-sauce-labs-backpack");

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
