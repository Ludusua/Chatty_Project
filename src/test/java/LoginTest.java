import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void positiveLoginTest() {
        String email = "Virthunter@gmail.com";
        String password = "Chatty12";
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(email, password);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
    }
}
