import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanFindCreatedPostTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    PostPage postPage;

    MyPostsPage myPostsPage;

    @Test
    public void userCanFindThePostTest() throws InterruptedException {
        String nameThePost = "Create Post With Selenium For Deleting";
        String date = "18.11.2024";
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, VALID_PASSWORD);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnMyPostsSwitcher();
        myPostsPage = new MyPostsPage(driver);
        Thread.sleep(4000);
        assertTrue(myPostsPage.findMyPostByNameAndDate(nameThePost, date));
        //myPostsPage.findMyPostByName("Not");
        // myPostsPage.nameOfPostIsVisible();
    }
}
