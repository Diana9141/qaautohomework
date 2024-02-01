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
    private final SelenideElement paperBookPrice = $("div[class=\"ui-btn-format option-button selected\"]:first-child > div:nth-child(2)");
    private final SelenideElement electronicBookPrice = $("div[class=\"ui-btn-format option-button selected\"]:nth-child(2)");
    private final SelenideElement availabilityButton = $x("(//button[@class=\"ui-btn-accept waiting-list button-accept\"])[1]");

    @BeforeMethod()
    public static void setUp() {
        Configuration.baseUrl = "https://www.yakaboo.ua/";
        Configuration.browserSize = "1920x1080";
        open("");
    }

    @Test()
    void searchBook() {
        String searchText = "Мати і не мати";
        searchInput.setValue(searchText).pressEnter();
        firstBookFromSearch.should(visible).click();
        marketingBanner.click();

        if(paperBookPrice.isDisplayed() && !(availabilityButton.exists())) {
            System.out.println("Paper book is there");
        } else if (electronicBookPrice.isDisplayed() && !(availabilityButton.exists())) {
            System.out.println("Electronic book is there");
        }
        else {
            System.out.println("NOT THERE");
        }
    }


    @AfterMethod
    static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}