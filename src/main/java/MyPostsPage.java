import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyPostsPage extends BasePage {
    public MyPostsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//h3[normalize-space()='Create Post With Selenium For Deleting']")
    private WebElement nameOfPost;
    @FindBy(xpath = "//p[normalize-space()='18.11.2024']")
    private List<WebElement> dataCreatingPost;
    @FindBy(xpath = "//*[@class='post-content']/div/h3")
    private List<WebElement> postsTitleList;
    @FindBy(xpath = "//h3[normalize-space()='Create Post With Selenium For Deleting']")
    private WebElement nameOfPostDeleting;


    public void findMyPostByNameAndClick(String nameThePost) {
        for (WebElement post : postsTitleList) {
            try {
                if (post.getText().contains(nameThePost)) {
                    post.click();
                    break;
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(nameThePost +" is not found");

            }
        }
    }

    public void clickNameOfPostDeleting() {
        getWait().forVisibility(nameOfPostDeleting);
        nameOfPostDeleting.click();
    }

    public void allListOfPostsIsVisible() {
        getWait().forAllVisibility(postsTitleList);
    }

    public boolean nameOfPostIsVisible() {
        getWait().forVisibility(nameOfPost);
        return nameOfPost.isDisplayed();
    }


}
