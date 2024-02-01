package hw11;

import com.codeborne.selenide.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class YakabooTest {
    private final SelenideElement searchInput = $("input[type=\"search\"]");
    private final SelenideElement marketingBanner = $(".cl-dialog-close-icon");
    private final SelenideElement firstBookFromSearch = $x("(//a[@data-testid=\"productLink\"])[1]");
    private final SelenideElement paperBookPrice = $("div[class=\"ui-btn-format option-button selected\"]:first-child > div:nth-child(2)");
    private final SelenideElement electronicBookPrice = $("div[class=\"ui-btn-format option-button selected\"]:nth-child(2)");
    public SelenideElement availabilityText = $x("(//span[@class=\"ui-shipment-status__text\"])[1]");

    @BeforeMethod()
    public static void setUp() {
        Configuration.baseUrl = "https://www.yakaboo.ua/";
        Configuration.browserSize = "1920x1080";
        open("");
    }

    @Test()
    void searchBook() throws InterruptedException {
        String searchText = "Мати";
        searchInput.setValue(searchText).pressEnter();
        firstBookFromSearch.should(appear).click();
        marketingBanner.isDisplayed();

        if (!availabilityText.text().trim().equals("Немає в наявності") && paperBookPrice.exists()) {
            System.out.println("Паперова версія доступна. Ціна: " + paperBookPrice.text());
        } else if (electronicBookPrice.exists() && !availabilityText.text().trim().equals("Немає в наявності")) {
            System.out.println("Електронна версія доступна. Ціна: " + electronicBookPrice.text());
        } else {
            System.out.println("Книга не в наявності.");
        }
        Thread.sleep(5000);
    }

    @AfterMethod
    static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}