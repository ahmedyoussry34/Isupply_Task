package utilis;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class browserActions {

    public static RemoteWebDriver remoteWebDriver;
    public static Map<String, RemoteWebDriver> driverMap = new HashMap<>();
    public static void addWebDriverToMapOfDrivers(browser browser, String uniqueKey) {
        if (browser == browser.Chrome) {
            ChromeDriver driver = new ChromeDriver();
            if (!driverMap.containsKey(uniqueKey)) {
                driverMap.put(uniqueKey, driver);
            } else {
                driverMap.replace(uniqueKey, driver);
            }
            driver.manage().window().maximize();

        }
    }
    public static void closeDriverAndRemoveFromMap(String key) {
        if (driverMap.containsKey(key)) {
            driverMap.get(key).quit();
            driverMap.remove(key);
        }
    }

    public enum browser{
        Chrome, Firefox, Edge;
    }
}
