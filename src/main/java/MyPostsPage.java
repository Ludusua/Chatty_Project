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
    @FindBy(xpath = "//*[@class='post-content']")
    private List<WebElement> postsList;

    public boolean findMyPostByNameAndDate(String nameThePost, String date) {
        boolean isDisplayed = false;
        for (WebElement post : postsList) {
            if (post.getText().equals(date) && post.getText().contains(nameThePost)) {
                post.click();
                isDisplayed=true;
                break;
            }
        }return isDisplayed;
    }

    public void findMyPostByName(String nameThePost) {
        try {
            for (WebElement post : postsList) {
                if (post.getText().contains(nameThePost)) {
                    post.click();
                    break;
                }
            }
        } catch (Exception exception) {
            System.out.println("Post not found");
        }
    }

    public boolean nameOfPostIsVisible() {
        getWait().forVisibility(nameOfPost);
        return nameOfPost.isDisplayed();
    }
}
