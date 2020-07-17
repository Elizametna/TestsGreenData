package TestTask;

import PageObject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewObject {

    By getButtonAddNewObjectLocator = By.xpath("//*[@id=\"page_content\"]/main/div/div[1]/div/div[1]/div[1]/div[1]/span/button");
    By getLineNameLocator = By.xpath("//*[@id=\"page_content\"]/main/div/div[2]/div[1]/div/div/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div/div/div[1]/input");
    By getButtonCreateLocator = By.cssSelector("#page_content > main > div > div.object-header.flex-container.ObjectCardHeader__cardHeader--lXivi > div.CustomFlexAuto__custom-flex-auto--1gHGX.card-buttons-wrapper > div > span:nth-child(2) > span > button");
    //*[@id="page_content"]/main/div/div[1]/div[2]/div/span[2]/span/button
    //
    //    #page_content > main > div > div.scrollbar-container.ps-container.ps-theme-default.ps-active-y > div.object-main.visual-root-content > div > div > div:nth-child(1) > div > div > div > div > div > div > div.panel-content.visual-groupbox-wrapper > div > div:nth-child(2) > div > div > div > div > div > div:nth-child(1) > div > div:nth-child(1) > div.control-wrapper > div > div > div.BaseMaterialControlStyle__controlContent--2J1hs > input
    public static WebDriver driver;

    public CreateNewObject(WebDriver driver) {
        this.driver = driver;
        if (!driver.getCurrentUrl().contains("login")) {
            throw new IllegalStateException("This is not the registry page");
        }
    }

    public CreateNewObject LineName(String objectname) {
        driver.findElement(getLineNameLocator).sendKeys(objectname);
        return this;
    }

    public void submitAddObject() {
        // driver.findElement(getButtonAddNewObjectLocator).findElement(By.cssSelector("button")).click();
        driver.findElement(getButtonAddNewObjectLocator).click();
    }
    public void submitCreateObject(){
        driver.findElement(getButtonCreateLocator).click();
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

    public boolean objectCreated(int time) {
        By app = By.cssSelector(".e-cell");
        return waitUntilVisible( app, time);
    }
}


