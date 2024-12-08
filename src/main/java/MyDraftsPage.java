import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyDraftsPage extends BasePage {
    @FindBy(xpath = "//p[contains(text(),'My drafts')]")
    private WebElement myDraftsTitle;
    @FindBy(xpath = "//p[contains(text(),'Here can be your posts...')]")
    private WebElement emptyDraftsMessage;

    public MyDraftsPage(WebDriver driver) {
        super(driver);
    }

    public boolean emptyDraftsMessageIsDisplayed() {
        return emptyDraftsMessage.isDisplayed();
    }

    public void waitForLoadingMyDraftsPage() {
        getWait().forVisibility(myDraftsTitle);
    }

    public boolean myDraftsTitleIsDisplayed() {
        return myDraftsTitle.isDisplayed();
    }
}
