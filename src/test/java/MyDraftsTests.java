import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyDraftsTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    MyDraftsPage myDraftsPage;

    @Test
    public void myDraftsPageIsEmptyTest() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, VALID_PASSWORD);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnMyDrafts();
        myDraftsPage = new MyDraftsPage(driver);
        myDraftsPage.waitForLoadingMyDraftsPage();
        assertTrue(myDraftsPage.emptyDraftsMessageIsDisplayed());
    }

    @Test
    public void myDraftsPageIsNotEmptyTest() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, VALID_PASSWORD);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnMyDrafts();
        myDraftsPage = new MyDraftsPage(driver);
        myDraftsPage.waitForLoadingMyDraftsPage();
        assertFalse(myDraftsPage.emptyDraftsMessageIsDisplayed());
    }
}
