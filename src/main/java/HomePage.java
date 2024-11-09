import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='user__img']")
    private WebElement userImage;
    @FindBy(xpath = "//p[contains(text(),'Create a post')]")
    private WebElement createPostTitle;

    public void waitForLoadingHomePage(){
        getWait().forVisibility(userImage);
        assertTrue(userImage.isDisplayed());
        getWait().forVisibility(createPostTitle);
        assertTrue(createPostTitle.isDisplayed());
    }
    public boolean createPostTitleIsDisplayed(){
        return createPostTitle.isDisplayed();
    }
}
