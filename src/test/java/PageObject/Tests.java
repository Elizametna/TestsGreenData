package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
    public ChromeDriver driver;
    public LoginPage loginPage;
    @BeforeMethod
    public void openPage() {
        driver.get("https://2-0-x.k8s.greendatasoft.ru/auth/login");
        loginPage = new LoginPage(driver);
    }
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }
    @Test
    public void EntranceToTheStandSuccessfully () {
        loginPage.typeUsername("admin");
        loginPage.submitLogin();
        loginPage.isApplicationPage(3);
        loginPage.typePassword("adminka");
        loginPage.submitPassword();
        Assert.assertTrue(loginPage.isApplicationPage(20), "It is not ...");
    }
    @Test
    public void InvalidLogin () {
        loginPage.typeUsername("12345");
        loginPage.submitLogin();
        loginPage.isApplicationPage(3);
        loginPage.typePassword("adminka");
        loginPage.submitPassword();
        Assert.assertFalse(loginPage.isApplicationPage(20), "It is not ...");

    }
    @Test
    public void InvalidPassword () {
        loginPage.typeUsername("admin");
        loginPage.submitLogin();
        loginPage.isApplicationPage(3);
        loginPage.typePassword("admin");
        loginPage.submitPassword();
        Assert.assertFalse(loginPage.isApplicationPage(20), "It is not ...");

    }
    @Test
    public void WorkButtonNext () {
        loginPage.typeUsername("admin");
        loginPage.submitLogin();
        loginPage.isApplicationPage(3);
        Assert.assertTrue(loginPage.isPasswordPage(1), "It is not ...");

    }
    @Test
    public void WorkButtonInput () {
        loginPage.typeUsername("admin");
        loginPage.submitLogin();
        loginPage.isApplicationPage(3);
        loginPage.typePassword("adminka");
        loginPage.submitPassword();
        Assert.assertTrue(loginPage.isApplicationPage(20), "It is not ...");

    }
    @Test
    public void CheckMessageLoginNotEntered () {
        loginPage.typeUsername("");
        loginPage.submitLogin();
        loginPage.isApplicationPage(3);
        //WebElement elem = driver.findElementByCssSelector("div#message-box.modal__footer").findElement(By.linkText("Введите логин"));
        Assert.assertTrue(loginPage.checkMessage(2), "It is not ...");

    }
    @Test
    public void CheckMessagePasswordNotEntered () {
        loginPage.typeUsername("admin");
        loginPage.submitLogin();
        loginPage.isApplicationPage(2);
        loginPage.typePassword("");
        loginPage.submitPassword();
        //WebElement elem = driver.findElementByCssSelector("div#message-box.modal__footer").findElement(By.linkText("Введите пароль"));
        Assert.assertTrue(loginPage.checkMessage(2), "It is not ...");

    }
    @Test
    public void CheckMessagePassworOrLogindIsEnterdIncorrectly () {
        loginPage.typeUsername("admin");
        loginPage.submitLogin();
        loginPage.isApplicationPage(2);
        loginPage.typePassword("admin");
        loginPage.submitPassword();
        Assert.assertTrue(loginPage.checkMessage(2), "It is not ...");

    }
    @Test
    public void CheckButtonBack () {
        loginPage.typeUsername("admin");
        loginPage.submitLogin();
        loginPage.checkButtonBack(5);
        loginPage.submitBack();
        loginPage.checkButtonBack(5);
        Assert.assertTrue(loginPage.checkButtonBack(2), "It is not ...");
    }
    @Test
    public void StringCheckWelcome() {
        loginPage.typeUsername("admin");
        loginPage.submitLogin();
        loginPage.isApplicationPage(3);
        
        Assert.assertEquals(loginPage.passwordPageWork(1), "Далее");
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }
}
