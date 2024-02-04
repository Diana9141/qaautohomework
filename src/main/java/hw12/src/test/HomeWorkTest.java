package hw12.src.test;

import hw12.src.pages.LoginPage;
import org.testng.annotations.Test;

public class HomeWorkTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @Test
    void checkSuccessOrder() {
        loginPage.login("standard_user", "secret_sauce")
                .addProducts()
                .goToCart()
                .checkCart()
                .goToCheckoutDetails()
                .fillDetails()
                .outputTax()
                .checkSuccessText();
    }
}
