import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanFindCreatedPostTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    MyPostsPage myPostsPage;
    OnePostPage onePostPage;
    public static final String POST_TITLE = "Create Post With Selenium";

    @Test
    public void userCanFindThePostByName() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, VALID_PASSWORD);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnMyPostsSwitcher();
        myPostsPage = new MyPostsPage(driver);
        myPostsPage.allListOfPostsIsVisible();
        int countOfPosts = myPostsPage.getCountOfPosts();
        assertEquals(5, countOfPosts);
        myPostsPage.findMyPostByNameAndClick(POST_TITLE);
        onePostPage = new OnePostPage(driver);
        assertEquals(POST_TITLE, onePostPage.getNameOfPost());
    }

    @Test
    public void userCanDeleteThePostByNameAndCheckDeleting() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, VALID_PASSWORD);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnMyPostsSwitcher();
        myPostsPage = new MyPostsPage(driver);
        myPostsPage.allListOfPostsIsVisible();
        myPostsPage.findMyPostByNameAndClick(POST_TITLE);
        onePostPage = new OnePostPage(driver);
        assertEquals(POST_TITLE, onePostPage.getNameOfPost());
        onePostPage.clickDeleteButton();
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.homePageIsVisible());
        homePage.clickOnMyPostsSwitcher();
        myPostsPage.allListOfPostsIsVisible();
        assertTrue(myPostsPage.findDeletedPost(POST_TITLE));
    }
}
