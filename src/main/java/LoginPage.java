import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Login Form']")
    private WebElement loginFormTitle;
    @FindBy(xpath = "//*[@name='email']")
    private WebElement emailInputField;
    @FindBy(xpath = "//*[@name='password']")
    private WebElement passwordInputField;
    @FindBy(xpath = "//*[@class='registration-btn']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[contains(text(),'Incorrect email')]")
    WebElement emailError;
    @FindBy(xpath = "//div[contains(text(),'Invalid email or password. Please try again.')]")
    WebElement invalidEmailOrPasswordFieldErrorMessage;
    @FindBy(xpath = "//div[contains(text(),'Password must be 8-100 characters and include at least one letter and one digit')]")
    WebElement shortOrInvalidPasswordFieldError;

    public void waitForLoadingLoginPage() {
        getWait().forVisibility(loginFormTitle);
        assertTrue(loginFormTitle.isDisplayed());

        getWait().forVisibility(emailInputField);
        assertTrue(emailInputField.isDisplayed());

        getWait().forVisibility(passwordInputField);
        assertTrue(passwordInputField.isDisplayed());

        getWait().forVisibility(loginButton);
        assertTrue(loginButton.isDisplayed());
    }

    public void setEmailInputField(String email) {
        emailInputField.sendKeys(email);
    }

    public void setPasswordInputField(String password) {
        passwordInputField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void loginButtonIsNotClickable() {
        getWait().forInClickable(loginButton);
    }

    public void setDateLoginPage(String email, String password) {
        waitForLoadingLoginPage();
        emailInputField.sendKeys(email);
        passwordInputField.sendKeys(password);
        loginButton.click();
    }

    public boolean invalidEmailErrorMessageIsVisible() {
        return emailError.isDisplayed();
    }

    public boolean emptyPasswordErrorMessageIsVisible() {
        return invalidEmailOrPasswordFieldErrorMessage.isDisplayed();
    }

    public boolean invalidPasswordErrorMessageIsVisible() {
        return shortOrInvalidPasswordFieldError.isDisplayed();
    }

    public void waitForEmailError() {
        getWait().forVisibility(emailError);
    }

    public void waitForEmptyPasswordError() {
        getWait().forVisibility(invalidEmailOrPasswordFieldErrorMessage);
    }

    public void waitForShortPasswordError() {
        getWait().forVisibility(shortOrInvalidPasswordFieldError);
    }
}
