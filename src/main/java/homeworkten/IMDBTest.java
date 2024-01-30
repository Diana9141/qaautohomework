package homeworkten;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class IMDBTest {
    private final ElementsCollection years = $$("div[class=\"sc-1e00898e-7 hcJWUf cli-title-metadata\"]");
    private final ElementsCollection titles = $$("a > h3.ipc-title__text");
    private final ElementsCollection ratings = $$("span[data-testid=\"ratingGroup--imdb-rating\"]");

    private final SelenideElement pageFilmTitle = $("span.hero__primary-text");
    private final SelenideElement pageFilmRating = $x("(//span[@class=\"sc-bde20123-1 cMEQkK\"])[1]");
    private final SelenideElement pageFilmYear = $("a[href=\"/title/tt0111161/releaseinfo?ref_=tt_ov_rdat\"]");

    @DataProvider(name = "testDataIMDB")
    public static Object[][] imdb() {
        return new Object[][]{{"Втеча з Шоушенка", "1994", "9.3"}};
    }

    @BeforeMethod()
    public static void setUp() {
        Configuration.baseUrl = "https://imdb.com/chart/top";
        Configuration.browserSize = "1920x1080";
    }

    @Test(dataProvider = "testDataIMDB")
    void testIMDB(String title, String year, String rating) {
        open("");
        $(byText("1. Втеча з Шоушенка")).click();

        pageFilmTitle.shouldHave(text(title));
        pageFilmYear.shouldHave(text(year));
        pageFilmRating.shouldHave(text(rating));
    }

    @AfterMethod()
    public static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
