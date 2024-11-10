import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanCreatePostTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    PostPage postPage;

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
        postPage = new PostPage(driver);
        postPage.waitForLoadingAllFields();
        postPage.setPostData(postTitle,description,contentDescription);
        postPage.uploadImage();
        postPage.waitForLoadingImage();
        postPage.clickSubmitButton();
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
        postPage = new PostPage(driver);
        postPage.waitForLoadingAllFields();
        postPage.setPostData(postTitle,description,contentDescription);
        postPage.clickSubmitButton();
    }
}
