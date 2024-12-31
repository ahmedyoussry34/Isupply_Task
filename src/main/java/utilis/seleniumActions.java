package utilis;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class seleniumActions {
    RemoteWebDriver driver;
    public static final Duration tenSeconds = Duration.of(10, ChronoUnit.SECONDS);

    public seleniumActions(String key) {
        this.driver = browserActions.driverMap.get(key);

    }

    public seleniumActions() {
        this.driver = browserActions.remoteWebDriver;
    }
    public void click(By path, boolean waitUntilClickable){
        if (waitUntilClickable) {
            WebDriverWait wait = new WebDriverWait(driver, tenSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(path));
        }
        driver.findElement(path).click();
    }
    public String getText(By path, boolean waitUntilPresent){
        if (waitUntilPresent) {
            WebDriverWait wait = new WebDriverWait(driver, tenSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(path));
        }
        return driver.findElement(path).getText().toString();
    }
    public void sendKeys(By path, String keys, boolean waitUntilPresent){
        if (waitUntilPresent) {
            WebDriverWait wait = new WebDriverWait(driver, tenSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(path));
        }
            driver.findElement(path).sendKeys(keys);
    }

    public void sendEnterKey(By path, boolean waitUntilPresent){
        if (waitUntilPresent) {
            WebDriverWait wait = new WebDriverWait(driver, tenSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(path));
        }
            driver.findElement(path).sendKeys(Keys.ENTER);
    }

    public void navigateTo(String path , boolean waitUntilPageLoads){
        if (waitUntilPageLoads) {
            WebDriverWait wait = new WebDriverWait(driver, tenSeconds);
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }
        driver.get(path);
    }
}
