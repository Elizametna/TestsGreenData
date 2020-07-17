package TestTask;

import PageObject.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {

    public ChromeDriver driver;
    public CreateNewObject newObject;
    public UnloadingInExcel unloadingInExcel;
    public ButtonDelete buttonDelete;
    public RegistriesPreference registriesPreference;
    public LoginPage loginPage;
    public SortInTable sort;

    public void EntranceToTheStand () {
        loginPage = new LoginPage(driver);
        loginPage.typeUsername("admin");
        loginPage.submitLogin();
        loginPage.isApplicationPage(3);
        loginPage.typePassword("adminka");
        loginPage.submitPassword();
        loginPage.isApplicationPage(20);
    }

    @BeforeMethod
    public void openPage() {
        driver.get("https://2-x-x.k8s.greendatasoft.ru/auth/login");
        newObject = new CreateNewObject(driver);
        unloadingInExcel = new UnloadingInExcel(driver);
        buttonDelete = new ButtonDelete(driver);
        registriesPreference = new RegistriesPreference(driver);
        sort = new SortInTable(driver);
    }
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void ObjectCreation () {
        EntranceToTheStand();
        newObject.submitAddObject();
        newObject.objectCreated(10);
        newObject.LineName("test9990");
        newObject.submitCreateObject();
        Assert.assertEquals(newObject.objectCreated(2),"test9990");
    }

    @Test
    public void UnloadingObjectsInExcel () {
        EntranceToTheStand();
        unloadingInExcel.submitUnloadingInExcel();
        unloadingInExcel.submitSetting();
        unloadingInExcel.submitDownloads();
        Assert.assertTrue(unloadingInExcel.isDownloads(2), "It is not ...");
    }

    @Test
    public void DeleteObject() {
        EntranceToTheStand();
        buttonDelete.submitObject();
        buttonDelete.submitDeleteObject();
        buttonDelete.submitConfirmDelete();
        Assert.assertNotEquals(buttonDelete.isDeletionObject(3), "test9990");
    }

    @Test
    public void DeleteObjectWithAttribute() {
        EntranceToTheStand();
        buttonDelete.submitObject();
        buttonDelete.submitDeleteObject();
        buttonDelete.submitConfirmDelete();
        buttonDelete.submitAttribute();
        buttonDelete.submitDeleteAttribute();
        buttonDelete.submitConfirmDeleteAttribute();
        Assert.assertNotEquals(buttonDelete.isDeletionObjectWithAttribute(3), "");
    }

    @Test
    public void CheckingFolderRegister(){
        EntranceToTheStand();
        registriesPreference.submitButtonRegistriesPreference();
        registriesPreference.submitFolderRegistry();
        Assert.assertEquals(registriesPreference.IsFolderRegistry(3), "");
    }

    @Test
    public void CheckingTiledRegister() {
        EntranceToTheStand();
        registriesPreference.submitButtonRegistriesPreference();
        registriesPreference.submitTiledRegistry();
        Assert.assertEquals(registriesPreference.IsTiledRegistry(3), "");
    }

    @Test
    public void CheckingPageTiledRegister() {
        EntranceToTheStand();
        registriesPreference.submitButtonRegistriesPreference();
        registriesPreference.submitTiledRegistry();
        Assert.assertEquals(registriesPreference.CountPages(5),"735");
    }

    @Test
    public void CheckingElemTiledRegister() {
        EntranceToTheStand();
        registriesPreference.submitButtonRegistriesPreference();
        registriesPreference.submitTiledRegistry();
        Assert.assertEquals(registriesPreference.CountElem(5),"3761");
    }

    @Test
    public void CheckingDeleteRegister() {
        EntranceToTheStand();
        registriesPreference.submitButtonRegistriesPreference();
        registriesPreference.submitDeleteRegistryButton();
       // Assert.assertEquals(,"");
    }

    @Test
    public void CheckingSortByName() {
        EntranceToTheStand();
        sort.objectName("test");
    }

    @Test
    public void CheckingSortById() {
        EntranceToTheStand();
        sort.idObjectNumber("TEST_36726");
    }

    @Test
    public void CheckingSortByTableName() {
        EntranceToTheStand();
        sort.tableName("TEST_36726");
    }

    @Test
    public void CheckingSortSystemYes() {
        EntranceToTheStand();
        sort.submitSystemObject();
        sort.submitSystemObjectButtonYes();
    }

    @Test
    public void CheckingSortSystemNo() {
        EntranceToTheStand();
        sort.submitSystemObject();
        sort.submitSystemObjectButtonNo();
    }

    @Test
    public void CheckingSortSystemClean() {
        EntranceToTheStand();
        sort.submitSystemObject();
        sort.submitSystemObjectButtonClean();
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }
}
