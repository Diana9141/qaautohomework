package hw12.src.test;

import com.codeborne.selenide.Configuration;
import hw12.src.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class HomeWorkTest {
    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod
    static void setUp() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.browserSize = "1920x1080";
        open("/");
    }

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
