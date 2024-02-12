package homeworkten;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTranslateTest {
    private final SelenideElement originalText = $x("//textarea[@aria-label=\"Текст оригіналу\"]");
    private final SelenideElement otherLanguagesButton = $x("(//button[@aria-label=\"Інші мови перекладу\"])[1]");
    private final SelenideElement translationText = $x("//span[@jsname='W297wb']");
    public SelenideElement languageCode;

    @DataProvider(name = "languageCodesAndTranslations")
    public static Object[][] strings() {
        return new Object[][]{{"en", "I will study TESTNG cool"},
                {"bg", "Ще проуча тестова готина"},
                {"ar", "سأدرس testng بارد"},
                {"de", "Ich werde testng cool studieren"},
                {"fr", "J'étudierai le test"},
                {"nl", "Ik zal testng cool bestuderen"},
                {"et", "Uurin testi jahedat"},
                {"iw", "אני אלמד מבחן מגניב"},
                {"is", "Ég mun læra TestNG flott"},
                {"sv", "Jag kommer att studera testng cool"},
                {"fi", "Opiskelen testiä viileänä"},
                {"no", "Jeg vil studere testng kult"},
                {"mk", "Ќе учам тест кул"},
                {"hr", "Proučit ću testng cool"},
                {"pl", "Badam testng fajny"},
                {"kk", "Мен тестілеуді керемет түрде оқимын"},
                {"ja", "テストをクールに勉強します"},
                {"tr", "Testng serin çalışacağım"},
                {"hu", "Tanulni fogom a tesztng cool -ot"},
                {"zh-CN", "我将研究测试凉爽"},
        };
    }

    @BeforeMethod()
    public static void setUp() {
        Configuration.baseUrl = "https://translate.google.com/?hl=uk";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000;
    }

    @Test(dataProvider = "languageCodesAndTranslations")
    void googleTranslateTo20Languages(String language, String translation) {
        //arrange a selector with country code
        languageCode = $x("(//div[@data-language-code='" + language + "'])[2]");

        //steps for translation
        open("");
        originalText.sendKeys("Я круто вивчу TestNG");
        otherLanguagesButton.click();
        languageCode.doubleClick();
        translationText.shouldHave(text(translation));
    }

    @AfterMethod
    public static void close() {
        WebDriverRunner.closeWebDriver();
    }
}