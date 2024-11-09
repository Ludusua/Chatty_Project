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

    @Test
    public void emptyEmailLoginTest() {
        String password = "Chatty12";
        loginPage = new LoginPage(driver);
        loginPage.waitForLoadingLoginPage();
        loginPage.setEmailInputField("");
        loginPage.setPasswordInputField(password);
        loginPage.loginButtonIsNotClickable();
    }

    @Test
    public void invalidEmailLoginTest() {
        String invalidEmail = "Virthuntergmail.com";
        String password = "Chatty12";
        loginPage = new LoginPage(driver);
        loginPage.waitForLoadingLoginPage();
        loginPage.setEmailInputField(invalidEmail);
        loginPage.setPasswordInputField(password);
        loginPage.loginButtonIsNotClickable();
        assertTrue(loginPage.invalidEmailErrorMessageIsVisible());
    }

    @Test
    public void emptyPasswordLoginTest() {
        String validEmail = "Virthunter@gmail.com";
        String password = "";
        loginPage = new LoginPage(driver);
        loginPage.waitForLoadingLoginPage();
        loginPage.setEmailInputField(validEmail);
        loginPage.setPasswordInputField(password);
        loginPage.clickOnLoginButton();
        loginPage.waitForEmptyPasswordError();
        assertTrue(loginPage.emptyPasswordErrorMessageIsVisible());
    }

    @Test
    public void invalidShortPasswordLoginTest() {
        String validEmail = "Virthunter@gmail.com";
        String shortPassword = "invalid";
        loginPage = new LoginPage(driver);
        loginPage.waitForLoadingLoginPage();
        loginPage.setEmailInputField(validEmail);
        loginPage.setPasswordInputField(shortPassword);
        loginPage.loginButtonIsNotClickable();
        loginPage.waitForShortPasswordError();
        assertTrue(loginPage.invalidPasswordErrorMessageIsVisible());
    }
    @Test
    public void invalidNoDigitPasswordLoginTest() {
        String validEmail = "Virthunter@gmail.com";
        String noDigitPassword = "invalidPasswordNoDigit";
        loginPage = new LoginPage(driver);
        loginPage.waitForLoadingLoginPage();
        loginPage.setEmailInputField(validEmail);
        loginPage.setPasswordInputField(noDigitPassword);
        loginPage.loginButtonIsNotClickable();
        loginPage.waitForShortPasswordError();
        assertTrue(loginPage.invalidPasswordErrorMessageIsVisible());
    }
    @Test
    public void invalidNoLetterPasswordLoginTest() {
        String validEmail = "Virthunter@gmail.com";
        String noLetterPassword = "123456789";
        loginPage = new LoginPage(driver);
        loginPage.waitForLoadingLoginPage();
        loginPage.setEmailInputField(validEmail);
        loginPage.setPasswordInputField(noLetterPassword);
        loginPage.loginButtonIsNotClickable();
        loginPage.waitForShortPasswordError();
        assertTrue(loginPage.invalidPasswordErrorMessageIsVisible());
    }
}
