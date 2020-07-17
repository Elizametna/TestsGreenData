package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    By usernameLocator = By.id("login-input");
    By passwordLocator = By.id("password-input");
    By NextButtonLocator = By.cssSelector(".form__button.next_button");
    By InputButtonLocator = By.cssSelector(".form__button.enter_button");
    By BackButtonLocator = By.cssSelector(".back-button back-button_to-login");

    public static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getCurrentUrl().contains("login")) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public void submitLogin() {
        driver.findElement(NextButtonLocator).findElement(By.cssSelector("button")).click();
    }
    public void submitPassword() {
        driver.findElement(InputButtonLocator).findElement(By.cssSelector("button")).click();
    }
    public void submitBack() {
        driver.findElement(BackButtonLocator).findElement(By.cssSelector("button")).click();
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
    public boolean isApplicationPage(int time) {
        By app = By.cssSelector("div.application");
        return waitUntilVisible( app, time);
    }
    public boolean isPasswordPage(int time) {
        By pas = passwordLocator;
        return waitUntilVisible(pas, time);
    }
    public boolean passwordPageWork(int time) {
        By check = By.cssSelector("div#form__title.p");
        return waitUntilVisible(check,time);
    }

    public boolean checkMessage(int time) {
        By check = By.cssSelector("div#message-box.modal__footer");
        return waitUntilVisible(check,time);
    }
    public boolean checkButtonBack(int time) {
        By check = By.cssSelector(".form__button.next_button");
        return waitUntilVisible(check,time);
    }

}
