import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.selenium.TestBrowser;

public class TempTest {

    private WebDriver driver;
    @Test
    private void testEasy() {
        System.out.println("Awesome");
    }
    @BeforeTest
    public void beforeTest() {
        driver = TestBrowser.getBrowser();
        driver.get("http://www.google.com");
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
