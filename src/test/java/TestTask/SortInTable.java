package TestTask;

import PageObject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SortInTable {
    By getNameObjectLocator = By.xpath("//*[@id=\"SJvnt9qCyv_NAME_filterbarcell\"]");
            //By.id("BJfgY8co3JP_NAME_filterbarcell");
    By getIdObjectLocator = By.id("rJjo6NshyP_IDENT_filterbarcell");
    By getNameTableLocator = By.id("BJfgY8co3JP_TABLE_NAME_filterbarcell");
    By getSystemObjectButton = By.id("rJjo6NshyP_SYS_OBJ_TYPE_IS_SYSTEM_filterbarcell_dropdown");
    By getSystemObjectButtonYes = By.xpath("//*[@id=\"SJvnt9qCyv_SYS_OBJ_TYPE_IS_SYSTEM_filterbarcell_popup\"]/div/ul/li[2]");
    By getSystemObjectButtonNo = By.xpath("//*[@id=\"SJvnt9qCyv_SYS_OBJ_TYPE_IS_SYSTEM_filterbarcell_popup\"]/div/ul/li[3]");
    By getSystemObjectButtonClean = By.xpath("//*[@id=\"SJvnt9qCyv_SYS_OBJ_TYPE_IS_SYSTEM_filterbarcell_popup\"]/div/ul/li[4]");

    public static WebDriver driver;

    public SortInTable(WebDriver driver) {
        this.driver = driver;
        if (!driver.getCurrentUrl().contains("login")) {
            throw new IllegalStateException("This is not the login page");
        }
    }
    public SortInTable objectName(String objectname) {
        driver.findElement(getNameObjectLocator).sendKeys(objectname);
        return this;
    }

    public SortInTable idObjectNumber(String num) {
        driver.findElement(getIdObjectLocator).sendKeys(num);
        return this;
    }

    public SortInTable tableName(String tablename) {
        driver.findElement(getNameTableLocator).sendKeys(tablename);
        return this;
    }

    public void submitSystemObject() {
        driver.findElement(getSystemObjectButton).click();
    }

    public void submitSystemObjectButtonYes() {
        driver.findElement(getSystemObjectButtonYes).click();
    }

    public void submitSystemObjectButtonNo() {
        driver.findElement(getSystemObjectButtonNo).click();
    }

    public void submitSystemObjectButtonClean() {
        driver.findElement(getSystemObjectButtonClean).click();
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
