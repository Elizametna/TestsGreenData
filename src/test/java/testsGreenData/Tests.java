package testsGreenData;


import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;


public class Tests {
    public void clickElemByText(String text) {
        WebElement element = driver.findElement(By.linkText(text));
        element.click();
    }
    public void changeActiveWindow () {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(2));
    }
    public  ChromeDriver driver;
    @BeforeClass
    public  void setUp() {
       // System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() {
        driver.get("https://yandex.ru/");
        clickElemByText("Погода");
        changeActiveWindow();
        String url = driver.getCurrentUrl();
       Assert.assertEquals(url, "https://yandex.ru/pogoda/perm");
    }
    @Test
    public void secondTest() {
        driver.get("https://yandex.ru/");
        clickElemByText("Пермский край");
        changeActiveWindow();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Коронавирус: статистика");
    }

    @AfterClass
    public void close () {
        driver.close();
    }
}
