import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanCreatePostTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    CreatePostPage createPostPage;
    MyDraftsPage myDraftsPage;

    @Test
    public void positivePostCreatingTestWithImage() {
        String postTitle = "Create Post With Selenium";
        String description = "Create Post With Selenium By Rudenko Vitalii";
        String contentDescription = "Post has been successfully created with Image! ";
        String email = "Virthunter@gmail.com";
        String password = "Chatty12";
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(email, password);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnCreatePostButton();
        createPostPage = new CreatePostPage(driver);
        createPostPage.waitForLoadingAllFields();
        createPostPage.setPostData(postTitle,description,contentDescription);
        createPostPage.uploadImageForCreatingPost();
        createPostPage.waitForLoadingImage();
        createPostPage.clickSubmitButton();
    }

    @Test
    public void positivePostCreatingTestWithoutImage() {
        String postTitle = "Create Post With Selenium";
        String description = "Create Post With Selenium By Rudenko Vitalii";
        String contentDescription = "Post has been successfully created without Image! ";
        String email = "Virthunter@gmail.com";
        String password = "Chatty12";
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(email, password);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnCreatePostButton();
        createPostPage = new CreatePostPage(driver);
        createPostPage.waitForLoadingAllFields();
        createPostPage.setPostData(postTitle,description,contentDescription);
        createPostPage.clickSubmitButton();
    }
    @Test
    public void positivePostCreatingAndSaveLikeDraftTest() {
        String postTitle = "Create Post With Selenium";
        String description = "Create Post With Selenium By Rudenko Vitalii";
        String contentDescription = "Post has been successfully created with Image! ";
        String email = "Virthunter@gmail.com";
        String password = "Chatty12";
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(email, password);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnCreatePostButton();
        createPostPage = new CreatePostPage(driver);
        createPostPage.waitForLoadingAllFields();
        createPostPage.setPostData(postTitle,description,contentDescription);
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
        String postTitle = "Create Post With Selenium For Deleting";
        String description = "Create Post With Selenium By Rudenko Vitalii";
        String contentDescription = "Post has been successfully created with Image for deleting!";
        String email = "Virthunter@gmail.com";
        String password = "Chatty12";
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(email, password);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
        homePage.clickOnCreatePostButton();
        createPostPage = new CreatePostPage(driver);
        createPostPage.waitForLoadingAllFields();
        createPostPage.setPostData(postTitle,description,contentDescription);
        createPostPage.uploadImageForDeletingPost();
        createPostPage.waitForLoadingImage();
        createPostPage.clickSubmitButton();
    }
}
