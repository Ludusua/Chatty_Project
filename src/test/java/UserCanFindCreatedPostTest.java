import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanFindCreatedPostTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    CreatePostPage createPostPage;
    MyPostsPage myPostsPage;
    OnePostPage onePostPage;

    @Test
    public void userCanFindThePostTest() throws InterruptedException {
        String nameThePost = "Create Post With Selenium For Deleting";
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, VALID_PASSWORD);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnMyPostsSwitcher();
        myPostsPage = new MyPostsPage(driver);
        myPostsPage.allListOfPostsIsVisible();
        myPostsPage.findMyPostByNameAndClick(nameThePost);
        onePostPage = new OnePostPage(driver);
        Thread.sleep(300);
        assertEquals(nameThePost,onePostPage.getNameOfPost());
    }
}
