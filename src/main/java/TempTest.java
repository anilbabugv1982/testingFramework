import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

        driver = new FirefoxDriver();
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
