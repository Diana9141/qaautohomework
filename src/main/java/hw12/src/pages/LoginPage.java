package hw12.src.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginField = $("#user-name");
    private final SelenideElement passField = $("#password");
    private final SelenideElement loginButton = $("#login-button");

    public ProductPage login(String login, String pass) {
        loginField.setValue(login);
        passField.setValue(pass);
        loginButton.click();
        return new ProductPage();
    }
}
