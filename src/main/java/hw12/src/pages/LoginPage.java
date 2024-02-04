package hw12.src.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement loginField = $("#user-name");
    private final SelenideElement passField = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorMessage = $x("//h3[@data-test=\"error\"]");
    private final SelenideElement loginCredList = $("#login_credentials");
    private final SelenideElement passCred = $("div.login_password");

    public ProductPage login(String login, String pass) {
        loginField.setValue(login);
        passField.setValue(pass);
        loginButton.click();
        return new ProductPage();
    }
}
