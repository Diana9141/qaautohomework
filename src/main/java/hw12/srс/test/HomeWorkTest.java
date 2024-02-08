package hw12.srс.test;

import hw12.srс.pages.CartPage;
import hw12.srс.pages.LoginPage;
import org.testng.annotations.Test;

public class HomeWorkTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final CartPage cartPage = new CartPage();

    @Test
    void checkSuccessOrder() {
        loginPage.login("standard_user", "secret_sauce")
                .addProducts()
                .goToCart()
                .checkProductsTitle("Sauce Labs Onesie", "Sauce Labs Bike Light");
        cartPage.goToCheckoutDetails()
                .fillDetails("Test", "Test", "11111")
                .outputTax()
                .checkSuccessText();
    }
}