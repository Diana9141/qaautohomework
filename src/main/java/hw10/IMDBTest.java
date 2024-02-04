package hw10;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class IMDBTest {
    @DataProvider(name = "movieDataProvider")
    public static Object[][] movieDataProvider() {
        open("https://www.imdb.com/chart/top/");

        Object[][] movies = new Object[99][4];

        for (int i = 1; i < movies.length; i++) {
            String title = $x("(//a[@class=\"ipc-title-link-wrapper\"])[" + i + "]").text().trim();
            String year = $x("((//span[@class=\"sc-1e00898e-8 hsHAHC cli-title-metadata-item\"]/..)[" + i + "])/child::*[1]").text();
            String rating = $x("(//span[@data-testid='ratingGroup--imdb-rating'])[" + i + "]").text().substring(0, 4);
            String movieUrl = $x("(//a[@class='ipc-title-link-wrapper'])[" + i + "]").attr("href");
            movies[i - 1] = new Object[]{title, year, rating, movieUrl};
        }

        closeWebDriver();
        return movies;
    }

    @BeforeMethod
    static void setup() {
        Configuration.baseUrl = "https://www.imdb.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test(dataProvider = "movieDataProvider", timeOut = 7000, retryAnalyzer = Retry.class)
    public void checkMovieInfo(String title, String year, String rating, String movieUrl) {
        open(movieUrl);
        String pageFilmTitle = $("span.hero__primary-text").text();
        String pageFilmRating = $x("(//span[@class=\"sc-bde20123-1 cMEQkK\"])[1]").text();
        String pageFilmYear = $x("(//a[@class=\"ipc-link ipc-link--baseAlt ipc-link--inherit-color\"])[6]").text();

        Assert.assertEquals(pageFilmTitle, title.substring(3).trim());
        Assert.assertEquals(pageFilmRating, rating.trim());
        Assert.assertEquals(pageFilmYear, year);

        System.out.println(title + " (" + year + "): Перевірка пройшла успішно");
    }
}
