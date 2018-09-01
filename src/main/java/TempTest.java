import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TempTest {

    private WebDriver driver;
    @Test
    private void testEasy() {
        System.out.println("Awesome");
    }
    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.gecko.driver", "/home/loclhost/IdeaProjects/basicFramework/src/main/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://www.google.com");
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
