package TestTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistriesPreference {

    By getButtonRegistriesPreferenceLocator = By.xpath("//*[@id=\"page_content\"]/main/div/div[1]/div/div[1]/div[1]/div[3]/span[3]/span/button");
    By getFolderRegistryLocator = By.xpath("//*[@id=\"page_content\"]/main/div/div[1]/div/div[1]/div[1]/div[3]/span[3]/div/ul/li[8]/div[1]/a");
    By getTiledRegistryLocator = By.xpath("//*[@id=\"page_content\"]/main/div/div[1]/div/div[1]/div[1]/div[3]/span[3]/div/ul/li[7]/div[1]/a");
    By getDeleteRegistryButtonLocator = By.cssSelector("");

    public static WebDriver driver;

    public RegistriesPreference(WebDriver driver) {
        this.driver = driver;
        if (!driver.getCurrentUrl().contains("login")) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public void submitButtonRegistriesPreference() {
        driver.findElement(getButtonRegistriesPreferenceLocator).findElement(By.cssSelector("button")).click();
    }
    public void submitFolderRegistry() {
        driver.findElement(getFolderRegistryLocator).findElement(By.cssSelector("button")).click();
    }
    public void submitTiledRegistry() {
        driver.findElement(getTiledRegistryLocator).findElement(By.cssSelector("button")).click();
    }
    public void submitDeleteRegistryButton() {
        driver.findElement(getDeleteRegistryButtonLocator).findElement(By.cssSelector("button")).click();
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

    public boolean IsFolderRegistry(int time) {
        By app = By.linkText("Папочный реестр - WorkFlow");
        return waitUntilVisible( app, time);
    }
    public boolean IsTiledRegistry(int time) {
        By app = By.linkText("Плиточный реестр - WorkFlow");
        return waitUntilVisible( app, time);
    }

    public boolean CountPages(int time) {
        By app = By.cssSelector(".e-pagermsg");
        return waitUntilVisible( app, time);
    }
    public boolean CountElem(int time) {
        By app = By.cssSelector(".e-pagermsg");
        return waitUntilVisible( app, time);
    }

}
