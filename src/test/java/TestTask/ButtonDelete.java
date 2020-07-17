package TestTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonDelete {

    By getObjectLocator = By.linkText("test9990");
    By getDeleteObjectLocator = By.cssSelector(".a-button.one-child.circle");
    By getConfirmDeleteObjectLocator = By.cssSelector("button-control.buttons__primaryButton--3KnGC.button-control.btn.btn-sm.with-transition");
    By getAttributeLocator = By.id("HyGZrPs3yD_headerCheckbox");
    By getDeleteAttributeLocator = By.cssSelector("radio-btn.colors__radioColor--3L-LN");
    By getConfirmDeleteAttributeLocator = By.linkText("Подтвердить");

    public static WebDriver driver;

    public ButtonDelete(WebDriver driver) {
        this.driver = driver;
        if (!driver.getCurrentUrl().contains("login")) {
            throw new IllegalStateException("This is not the istry page");
        }
    }

    public void submitObject() {
        driver.findElement(getObjectLocator).findElement(By.cssSelector("button")).click();
    }

    public void submitDeleteObject() {
        driver.findElement(getDeleteObjectLocator).findElement(By.cssSelector("button")).click();
    }

    public void submitConfirmDelete() {
        driver.findElement(getConfirmDeleteObjectLocator).findElement(By.cssSelector("button")).click();
    }

    public void submitAttribute() {
        driver.findElement(getAttributeLocator).findElement(By.cssSelector("button")).click();
    }

    public void submitDeleteAttribute() {
        driver.findElement(getDeleteAttributeLocator).findElement(By.cssSelector("button")).click();
    }

    public void submitConfirmDeleteAttribute() {
        driver.findElement(getConfirmDeleteAttributeLocator).findElement(By.cssSelector("button")).click();
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
    public boolean isDeletionObject(int time) {
        By app = By.cssSelector(".greendata-material-theme");
        return waitUntilVisible( app, time);
    }
    public boolean isDeletionObjectWithAttribute(int time) {
        By pas = By.cssSelector(".greendata-material-theme");
        return waitUntilVisible(pas, time);
    }
}
