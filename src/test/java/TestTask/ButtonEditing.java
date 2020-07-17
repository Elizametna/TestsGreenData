package TestTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonEditing {

    By getEditingModeLocator = By.cssSelector("");
    By getSaveButtonLocator = By.cssSelector("");
    By getUpdateButtonLocator = By.cssSelector("");

    public static WebDriver driver;

    public ButtonEditing(WebDriver driver) {
        this.driver = driver;
        if (!driver.getCurrentUrl().contains("login")) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public void submitEditingMode() {
        driver.findElement(getEditingModeLocator).findElement(By.cssSelector("button")).click();
    }
    public void submitSaveButton() {
        driver.findElement(getSaveButtonLocator).findElement(By.cssSelector("button")).click();
    }
    public void submitUpdateButton() {
        driver.findElement(getUpdateButtonLocator).findElement(By.cssSelector("button")).click();
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



}
