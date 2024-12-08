import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnePostPage extends BasePage{
    @FindBy(xpath = "//*[@class='post-content__top']/h3")
    private WebElement titleOfMyPost;
    @FindBy(xpath = "//*[@class='post-content__top']/p")
    private WebElement dateOfMyPost;

    @FindBy(xpath = "//*[@data-test='delete-button']")
    private WebElement deleteButton;
    public OnePostPage(WebDriver driver) {
        super(driver);
    }

    public void clickDeleteButton(){
        getWait().forVisibility(deleteButton);
        deleteButton.click();
    }
    public String getNameOfPost(){
        getWait().forVisibility(titleOfMyPost);
        return titleOfMyPost.getText();
    }
}
