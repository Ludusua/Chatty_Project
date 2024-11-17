import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostPage extends BasePage {
    public PostPage(WebDriver driver) {
        super(driver);
    }

    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String ABSOLUTEPATH = "C:"+ FILE_SEPARATOR +"Users"+FILE_SEPARATOR +"Dell"+FILE_SEPARATOR +"IdeaProjects"+FILE_SEPARATOR +"Chatty_Project"+FILE_SEPARATOR +"src"+FILE_SEPARATOR +"main"+FILE_SEPARATOR +"resources"+FILE_SEPARATOR +"books.png";
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

    public void waitForLoadingAllFields() {
        getWait().forVisibility(titleInputField);
        assertTrue(titleInputField.isDisplayed());
        getWait().forVisibility(descriptionInputField);
        assertTrue(descriptionInputField.isDisplayed());
        getWait().forVisibility(contentDescriptionInputField);
        assertTrue(contentDescriptionInputField.isDisplayed());
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

    public void uploadImage() {
        imageUploadField.sendKeys(ABSOLUTEPATH);
    }

}
