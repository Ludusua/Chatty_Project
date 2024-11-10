import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyDraftsTests extends BaseTest{
LoginPage loginPage;
HomePage homePage;
MyDraftsPage myDraftsPage;
    @Test
    public void myDraftsPageIsEmptyTest() {
        String email = "Virthunter@gmail.com";
        String password = "Chatty12";
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(email, password);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnMyDrafts();
        myDraftsPage = new MyDraftsPage(driver);
        myDraftsPage.waitForLoadingMyDraftsPage();
        assertTrue(myDraftsPage.emptyDraftsMessageIsDisplayed());
    }
}
