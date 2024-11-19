import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnePostPage extends BasePage{
    public OnePostPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='post-content__top']/h3")
    private WebElement titleOfMyPost;

    public String getNameOfPost(){
        getWait().forVisibility(titleOfMyPost);
        return titleOfMyPost.getText();
    }
}
