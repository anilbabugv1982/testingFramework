package utilities.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import utilities.common.Constant;
import utilities.common.Details;

public class TestBrowser {

    public static WebDriver getBrowser() {
        if (Details.isWindows()) {
            System.setProperty("webdriver.gecko.driver", Constant.path_gecko_windows);
        } else if (Details.isMac()) {
            System.setProperty("webdriver.gecko.driver", Constant.path_gecko_mac);
        } else {
            System.setProperty("webdriver.gecko.driver", Constant.path_gecko_linux);
        }
        return new FirefoxDriver();
    }

    public static WebDriver getBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            return getChromeBrowser();
        } else if (browserName.equalsIgnoreCase("opera")) {
            return getOperaBrowser();
        }
        return getBrowser();
    }

    public static WebDriver getChromeBrowser() {
        if (Details.isWindows()) {
            System.setProperty("webdriver.chrome.driver", Constant.path_chrome_windows);
        } else if (Details.isMac()) {
            System.setProperty("webdriver.chrome.driver", Constant.path_chrome_mac);
        } else {
            System.setProperty("webdriver.chrome.driver", Constant.path_chrome_linux);
        }
        return new ChromeDriver();
    }

    public static WebDriver getOperaBrowser() {
        if (Details.isWindows()) {
            System.setProperty("webdriver.opera.driver", Constant.path_opera_windows);
        } else if (Details.isMac()) {
            System.setProperty("webdriver.opera.driver", Constant.path_opera_mac);
        } else {
            System.setProperty("webdriver.opera.driver", Constant.path_opera_linux);
        }
        return new OperaDriver();
    }




}
