import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='user__img']")
    private WebElement userImage;
    @FindBy(xpath = "//p[contains(text(),'Create a post')]")
    private WebElement createPostTitle;
    @FindBy(xpath = "//*[@class='header__logo']")
    private WebElement headerLogo;

    @FindBy(xpath = "//span[normalize-space()='News Feed']")
    private WebElement newsFeed;
    @FindBy(xpath = "//span[normalize-space()='My drafts']")
    private WebElement myDrafts;
    @FindBy(xpath = "//*[@data-test='post-header__plus']")
    private WebElement createPostButton;
    @FindBy(xpath = "//h3[normalize-space()='Create Post With Selenium For Deleting']")
    private WebElement createdForDeletingPost;

    @FindBy(xpath = "//*[@for='myPostsId']")
    private WebElement myPostsSwitcher;

    public void clickOnMyPostsSwitcher() {
        myPostsSwitcher.isDisplayed();
        myPostsSwitcher.click();
    }

    public boolean homePageIsVisible(){
        return driver.getCurrentUrl().endsWith("/homeblog");
    }
    public void clickOnCreatedForDeletingPost() {
        createdForDeletingPost.click();
    }

    public void waitForLoadingHomePage() {
        getWait().forVisibility(userImage);
        assertTrue(userImage.isDisplayed());
        getWait().forVisibility(createPostTitle);
        assertTrue(createPostTitle.isDisplayed());
    }

    public boolean createPostTitleIsDisplayed() {
        return createPostTitle.isDisplayed();
    }


    public void clickOnHeaderLogo() {
        getWait().forVisibility(headerLogo);
        assertTrue(headerLogo.isDisplayed());
        headerLogo.click();
    }

    public void clickOnMyDrafts() {
        getWait().forVisibility(myDrafts);
        assertTrue(myDrafts.isDisplayed());
        myDrafts.click();
    }

    public void clickOnCreatePostButton() {
        getWait().forVisibility(createPostButton);
        assertTrue(createPostButton.isDisplayed());
        createPostButton.click();
    }
}
