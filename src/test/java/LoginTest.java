import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;


    @Test
    public void positiveLoginTest() {

        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, VALID_PASSWORD);
        homePage = new HomePage(driver);
        homePage.waitForLoadingHomePage();
        assertTrue(homePage.createPostTitleIsDisplayed());
    }

    @Test
    public void emptyEmailLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(EMPTY_EMAIL, VALID_PASSWORD);
        loginPage.waitForLoginButtonIsNotClickable();
        assertTrue(loginPage.loginFormTitleIsDisplayed());
    }

    @Test
    public void invalidEmailLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(INVALID_EMAIL, VALID_PASSWORD);
        loginPage.waitForLoginButtonIsNotClickable();
        assertTrue(loginPage.invalidEmailErrorMessageIsVisible());
    }

    @Test
    public void emptyPasswordLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, INVALID_EMPTY_PASSWORD);
        loginPage.clickOnLoginButton();
        loginPage.waitForEmptyPasswordError();
        assertTrue(loginPage.emptyPasswordErrorMessageIsVisible());
    }

    @Test
    public void invalidShortPasswordLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, INVALID_SHORT_PASSWORD);
        loginPage.waitForLoginButtonIsNotClickable();
        loginPage.waitForShortPasswordError();
        assertTrue(loginPage.invalidPasswordErrorMessageIsVisible());
    }

    @Test
    public void invalidNoDigitPasswordLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, INVALID_NO_DIGIT_PASSWORD);
        loginPage.waitForLoginButtonIsNotClickable();
        loginPage.waitForShortPasswordError();
        assertTrue(loginPage.invalidPasswordErrorMessageIsVisible());
    }

    @Test
    public void invalidNoLetterPasswordLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, INVALID_NO_LETTER_PASSWORD);
        loginPage.waitForLoginButtonIsNotClickable();
        loginPage.waitForShortPasswordError();
        assertTrue(loginPage.invalidPasswordErrorMessageIsVisible());
    }
}
