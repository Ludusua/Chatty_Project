import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanCreatePostTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    CreatePostPage createPostPage;
    MyDraftsPage myDraftsPage;
    public static final String POST_TITLE = "Create Post With Selenium";
    public static final String POST_TITLE_FOR_DELETING = "Create Post With Selenium For Deleting";
    public static final String POST_DESCRIPTION = "Create Post With Selenium By Rudenko Vitalii";
    public static final String CONTENT_DESCRIPTION_IMAGE = "Create Post With Selenium By Rudenko Vitalii";
    public static final String CONTENT_DESCRIPTION_NO_IMAGE = "Post has been successfully created without Image!";


    @Test
    public void positivePostCreatingTestWithImage() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, VALID_PASSWORD);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnCreatePostButton();
        createPostPage = new CreatePostPage(driver);
        createPostPage.waitForLoadingAllFields();
        createPostPage.setPostData(POST_TITLE, POST_DESCRIPTION, CONTENT_DESCRIPTION_IMAGE);
        createPostPage.uploadImageForCreatingPost();
        createPostPage.waitForLoadingImage();
        createPostPage.clickSubmitButton();
    }

    @Test
    public void positivePostCreatingTestWithoutImage() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, VALID_PASSWORD);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnCreatePostButton();
        createPostPage = new CreatePostPage(driver);
        createPostPage.waitForLoadingAllFields();
        createPostPage.setPostData(POST_TITLE, POST_DESCRIPTION, CONTENT_DESCRIPTION_NO_IMAGE);
        createPostPage.clickSubmitButton();
    }

    @Test
    public void positivePostCreatingAndSaveLikeDraftTest() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, VALID_PASSWORD);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnCreatePostButton();
        createPostPage = new CreatePostPage(driver);
        createPostPage.waitForLoadingAllFields();
        createPostPage.setPostData(POST_TITLE, POST_DESCRIPTION, CONTENT_DESCRIPTION_IMAGE);
        createPostPage.uploadImageForCreatingPost();
        createPostPage.waitForLoadingImage();
        createPostPage.clickOnTheSaveAsDraftSwitcher();
        createPostPage.clickSubmitButton();
        homePage.clickOnMyDrafts();
        myDraftsPage = new MyDraftsPage(driver);
        myDraftsPage.waitForLoadingMyDraftsPage();
    }

    @Test
    public void positivePostCreatingWithImageForDeleting() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, VALID_PASSWORD);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnCreatePostButton();
        createPostPage = new CreatePostPage(driver);
        createPostPage.waitForLoadingAllFields();
        createPostPage.setPostData(POST_TITLE_FOR_DELETING, POST_DESCRIPTION, CONTENT_DESCRIPTION_IMAGE);
        createPostPage.uploadImageForDeletingPost();
        createPostPage.waitForLoadingImage();
        createPostPage.clickSubmitButton();
    }
}
