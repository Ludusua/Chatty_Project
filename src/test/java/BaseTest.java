
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    ChromeDriver driver;
    String BASE_URL = "http://chatty.telran-edu.de:8089/login";
    public static final String VALID_EMAIL = "Virthunter@gmail.com";
    public static final String EMPTY_EMAIL = "";
    public static final String INVALID_EMAIL = "Virthuntergmail.com";
    public static final String VALID_PASSWORD = "Chatty12";
    public static final String INVALID_EMPTY_PASSWORD = "";
    public static final String INVALID_SHORT_PASSWORD = "invalid";
    public static final String INVALID_NO_DIGIT_PASSWORD = "invalidPasswordNoDigit";
    public static final String INVALID_NO_LETTER_PASSWORD = "123456789";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
