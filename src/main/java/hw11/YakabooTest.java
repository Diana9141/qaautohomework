package hw11;

import com.codeborne.selenide.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class YakabooTest {
    private final SelenideElement searchInput = $("input[type=\"search\"]");
    private final SelenideElement marketingBanner = $(".cl-dialog-close-icon");
    private final SelenideElement firstBookFromSearch = $x("(//a[@data-testid=\"productLink\"])[1]");
    private final SelenideElement bookPrice = $x("//div[@class=\"ui-price-display price simple selected\"]");
    private final SelenideElement availabilityButton = $x("(//button[@class=\"ui-btn-accept waiting-list button-accept\"])[1]");
    private final SelenideElement bookTypeSelected = $x("//div[@class='ui-btn-format option-button selected']/*[1]/*[2]");

    @BeforeMethod()
    public static void setUp() {
        Configuration.baseUrl = "https://www.yakaboo.ua/";
        Configuration.browserSize = "1920x1080";
        open("");
    }

    @Test()
    void searchBook() {
        String searchText = "Pride And Prejudice";
        searchInput.setValue(searchText).pressEnter();
        firstBookFromSearch.should(visible).click();
        marketingBanner.click();

        if (bookTypeSelected.text().trim().equals("Паперова") && !(availabilityButton.exists())) {
            System.out.println("Paper book is there: " + bookPrice.text());
        } else if (bookTypeSelected.text().trim().equals("Електронна") && !(availabilityButton.exists())) {
            System.out.println("Electronic book is there: " + bookPrice.text());
        } else if (bookTypeSelected.text().trim().equals("Паперова") && bookTypeSelected.text().trim().equals("Електронна") && !(availabilityButton.exists())) {
            System.out.println("Paper and Electronic books are both available");
        } else {
            System.out.println("BOOK IS NOT AVAILABLE");
        }
    }

    @AfterMethod
    static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}