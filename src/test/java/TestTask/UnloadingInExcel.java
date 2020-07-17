package TestTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnloadingInExcel {

    By getUnloadingInExcelLocator = By.xpath("//*[@id=\"page_content\"]/main/div/div[1]/div/div[1]/div[1]/div[2]/span[5]/span/button");
    By getSettingLocator = By.cssSelector("");
    By getDownloadsLocator = By.cssSelector("");

    public static WebDriver driver;

    public UnloadingInExcel(WebDriver driver) {
        this.driver = driver;
        if (!driver.getCurrentUrl().contains("login")) {
            throw new IllegalStateException("This is not the reg page");
        }
    }

    public void submitUnloadingInExcel() {
        driver.findElement(getUnloadingInExcelLocator).click();
    }

    public void submitSetting() {
        driver.findElement(getSettingLocator).findElement(By.cssSelector("button")).click();
    }

    public void submitDownloads() {
        driver.findElement(getDownloadsLocator).findElement(By.cssSelector("button")).click();
    }

    public static boolean waitUntilVisible(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isDownloads(int time) {
        By app = By.cssSelector(".Реестр- Тип объекта.xlsx");
        return waitUntilVisible( app, time);
    }
}
