package utilities.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.common.Constant;
import utilities.common.Details;

public class TestBrowser {
    private static Boolean isExtendedRequired = true;

    public static WebDriver getBrowser() {
        if (Details.isWindows() && isExtendedRequired) {
            System.setProperty("webdriver.gecko.driver", Constant.extendedPath + Constant.path_gecko_windows);
        } else if (Details.isWindows() && !isExtendedRequired) {
            System.setProperty("webdriver.gecko.driver", Constant.path_gecko_windows);
        } else if (Details.isMac() && isExtendedRequired) {
            System.setProperty("webdriver.gecko.driver", Constant.extendedPath + Constant.path_gecko_mac);
        } else if (Details.isMac()) {
            System.setProperty("webdriver.gecko.driver", Constant.path_gecko_mac);
        } else if (isExtendedRequired) {
            System.setProperty("webdriver.gecko.driver", Constant.extendedPath + Constant.path_gecko_mac);
        } else {
            System.setProperty("webdriver.gecko.driver", Constant.path_gecko_linux);
        }
        return new FirefoxDriver();
    }

}
