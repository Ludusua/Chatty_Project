import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
        loginPage.loginButtonIsNotClickable();
    }

    @Test
    public void invalidEmailLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(INVALID_EMAIL, VALID_PASSWORD);
        loginPage.loginButtonIsNotClickable();
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
        loginPage.loginButtonIsNotClickable();
        loginPage.waitForShortPasswordError();
        assertTrue(loginPage.invalidPasswordErrorMessageIsVisible());
    }

    @Test
    public void invalidNoDigitPasswordLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, INVALID_NO_DIGIT_PASSWORD);
        loginPage.loginButtonIsNotClickable();
        loginPage.waitForShortPasswordError();
        assertTrue(loginPage.invalidPasswordErrorMessageIsVisible());
    }

    @Test
    public void invalidNoLetterPasswordLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.setDateLoginPage(VALID_EMAIL, INVALID_NO_LETTER_PASSWORD);
        loginPage.loginButtonIsNotClickable();
        loginPage.waitForShortPasswordError();
        assertTrue(loginPage.invalidPasswordErrorMessageIsVisible());
    }

//////////////////////////////////////////With ParameterizedTest///////////////////////////////////////
    @ParameterizedTest
    @MethodSource("validData")
    public void loginParamTest(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.waitForLoadingLoginPage();
        loginPage.setEmailInputField(email);
        loginPage.setPasswordInputField(password);
        loginPage.loginButtonIsNotClickable();
        if (!email.equals("Virthunter@gmail.com")) {
            assertTrue(loginPage.invalidEmailErrorMessageIsVisible());
        } else if (password.isEmpty()) {
            assertTrue(loginPage.emptyPasswordErrorMessageIsVisible());
        } else {
            assertTrue(loginPage.invalidPasswordErrorMessageIsVisible());
        }
    }

    static Stream<Arguments> validData() {
        return Stream.of(
                Arguments.arguments("Virthuntergmail.com", "Chatty12"),
                // Arguments.arguments("Virthunter@gmail.com", ""),
                Arguments.arguments("Virthunter@gmail.com", "invalid"),
                Arguments.arguments("Virthunter@gmail.com", "invalidPasswordNoDigit"),
                Arguments.arguments("Virthunter@gmail.com", "123456789")
        );
    }

}
