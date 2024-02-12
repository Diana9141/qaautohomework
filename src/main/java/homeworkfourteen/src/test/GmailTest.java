package homeworkfourteen.src.test;

import homeworkfourteen.src.pages.GmailPage;
import homeworkfourteen.src.pages.ProfilePage;
import org.testng.annotations.Test;



public class GmailTest extends BaseTest {
    GmailPage homePage = new GmailPage();
    ProfilePage profilePage = new ProfilePage();
    @Test
    void checkDeletedImportantMessages() {
        homePage.gmailClick()
                .goToCredentials()
                .setCredentials("testerflexmade", "19111994q")
                .agreeToTerms()
                .goToProfile();
        profilePage.goToImportantSection()
                .deleteImportantMessage()
                .checkMessagesDeleted(profilePage.getFourthMessage(), profilePage.getFifthMessage());
    }
}