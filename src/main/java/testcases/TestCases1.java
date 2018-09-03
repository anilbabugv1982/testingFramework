package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.fileUtilities.fileCommons;
import utilities.selenium.TestBrowser;

import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCases1 {
    public static String testHost = "xxxxxxxxxxxxxxxxxx";
    public static CopyOnWriteArrayList<String> myList = new CopyOnWriteArrayList();

    public static void addUlr(List<String> nayalist) {

        for (String temp : nayalist) {
            if (myList.contains(temp) || myList.contains(temp.toLowerCase())) {
                continue;
            }
            myList.add(temp);
        }

    }

    public static void navigateUrl(WebDriver driver, String url) {
        driver.get(url.replace("https://", "http://"));
    }

    public static CopyOnWriteArrayList<String> allUniqueUrls(WebDriver driver) {
        Set<String> tempUrls = new HashSet<>();

        List<WebElement> allElements = driver.findElements(By.tagName("a"));

        for (WebElement element : allElements) {
            try {
                URL tempurl = new URL(element.getAttribute("href"));
                tempUrls.add("http://" + tempurl.getHost() + tempurl.getFile());
            } catch (Exception e) {
                continue;
            }
        }
        return new CopyOnWriteArrayList(tempUrls);
    }

    @Test
    public void testCase1() {
        WebDriver driver = TestBrowser.getBrowser("chrome");
        navigateUrl(driver, "http://" + testHost);

        myList = allUniqueUrls(driver);

        Iterator<String> it = myList.iterator();

        while (it.hasNext()) {
            String tt = it.next();
            System.out.println(tt + "\t" + myList.size());
            try {
                URL vurl = new URL(tt);
                if (!vurl.getHost().equalsIgnoreCase(testHost)) {
                    continue;
                }
            } catch (Exception e) {
                System.out.println(tt + "\terror");
                continue;
            }

            driver.get(tt);
            addUlr(allUniqueUrls(driver));
        }

        fileCommons.writeData(myList, "outputfile.txt");

    }

}
