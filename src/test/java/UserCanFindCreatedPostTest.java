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
    public void userCanFindThePostByName() throws InterruptedException {
        String nameThePost = "Create Post With Selenium For Deleting";
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, VALID_PASSWORD);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnMyPostsSwitcher();
        myPostsPage = new MyPostsPage(driver);
        myPostsPage.allListOfPostsIsVisible();
        int countOfPosts=myPostsPage.getCountOfPosts();
        assertEquals(15,countOfPosts);
        myPostsPage.findMyPostByNameAndClick(nameThePost);
        onePostPage = new OnePostPage(driver);
        assertEquals(nameThePost,onePostPage.getNameOfPost());
    }
}
