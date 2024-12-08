import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatePostPage extends BasePage {
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String ABSOLUTEPATHFORCREATING = "C:" + FILE_SEPARATOR + "Users" + FILE_SEPARATOR + "Dell" + FILE_SEPARATOR + "IdeaProjects" + FILE_SEPARATOR + "Chatty_Project" + FILE_SEPARATOR + "src" + FILE_SEPARATOR + "main" + FILE_SEPARATOR + "resources" + FILE_SEPARATOR + "books.png";
    private static final String ABSOLUTEPATHFORDELETING = "C:" + FILE_SEPARATOR + "Users" + FILE_SEPARATOR + "Dell" + FILE_SEPARATOR + "IdeaProjects" + FILE_SEPARATOR + "Chatty_Project" + FILE_SEPARATOR + "src" + FILE_SEPARATOR + "main" + FILE_SEPARATOR + "resources" + FILE_SEPARATOR + "DeleteButton.png";
    @FindBy(xpath = "//input[@placeholder='Title']")
    private WebElement titleInputField;
    @FindBy(xpath = "//*[@placeholder='Description']")
    private WebElement descriptionInputField;
    @FindBy(xpath = "//*[@name='content']")
    private WebElement contentDescriptionInputField;
    @FindBy(xpath = "//*[@for='draftCheckbox']")
    private WebElement saveAsDraftSwitcher;
    @FindBy(xpath = "//*[@data-test='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']")
    private WebElement imageUploadField;
    @FindBy(xpath = "//*[@data-test='uploaded-image']")
    private WebElement uploadedImage;

    public CreatePostPage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoadingAllFields() {
        getWait().forVisibility(titleInputField);
        assertTrue(titleInputField.isDisplayed());
        getWait().forVisibility(descriptionInputField);
        assertTrue(descriptionInputField.isDisplayed());
        getWait().forVisibility(contentDescriptionInputField);
        assertTrue(contentDescriptionInputField.isDisplayed());
    }
    public boolean fieldsAreNotVisible() {
        assertFalse(titleInputField.isEnabled());
        assertFalse(descriptionInputField.isEnabled());
        assertFalse(contentDescriptionInputField.isEnabled());
        return true;
    }

    public void waitForLoadingImage() {
        getWait().forVisibility(uploadedImage);
        assertTrue(uploadedImage.isDisplayed());
    }

    public void setTitleInputField(String title) {
        titleInputField.sendKeys(title);
    }

    public void setDescriptionInputField(String description) {
        descriptionInputField.sendKeys(description);
    }

    public void setContentDescriptionInputField(String contentDescription) {
        contentDescriptionInputField.sendKeys(contentDescription);
    }

    public void setPostData(String title, String description, String contentDescription) {
        titleInputField.sendKeys(title);
        descriptionInputField.sendKeys(description);
        contentDescriptionInputField.sendKeys(contentDescription);
    }

    public void clickOnTheSaveAsDraftSwitcher() {
        saveAsDraftSwitcher.isDisplayed();
        saveAsDraftSwitcher.click();
    }

    public void clickSubmitButton() {
        submitButton.isDisplayed();
        submitButton.click();
    }

    public void uploadImageForCreatingPost() {
        imageUploadField.sendKeys(ABSOLUTEPATHFORCREATING);
    }

    public void uploadImageForDeletingPost() {
        imageUploadField.sendKeys(ABSOLUTEPATHFORDELETING);
    }

}
