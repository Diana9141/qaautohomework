package homeworkfourteen.src.test;


import homeworkfourteen.src.pages.GmailPage;
import homeworkfourteen.src.pages.ProfilePage;
import org.testng.annotations.Test;

public class GmailTest extends BaseTest {

    @Test
    void checkDeletedImportantMessages() throws InterruptedException {
        GmailPage homePage = new GmailPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        homePage.gmailClick()
                .goToCredentials()
                .setCredentials("testerflexmade", "19111994q")
                .agreeToTerms()
                .goToProfile();
        profilePage.goToImportantSection()
                .deleteImportantMessage();
    }
}
