import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EnglishLang {
    private WebDriver driver;
    private String URL = "https://booky-test.service-it.by/sd/booking";

    @Before
    public void setUp() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ekaterina.yanovskaya\\Desktop\\AUTO\\chromedriver.exe");

        // Инициализация экземпляра WebDriver для браузера Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void start(){
        GeneralMethod generalMethod = new GeneralMethod(driver);
        generalMethod.login("1", "1");
        generalMethod.clickChangeLanguageEng();
    }

    public  void exit(){
        GeneralMethod generalMethod = new GeneralMethod(driver);
        generalMethod.clickChangeLanguageEngAndExit();
    }

    public void clickRegistration(){
        PeregovorkaBooking peregovorkaBooking = new PeregovorkaBooking(driver);
        peregovorkaBooking.clickRegistration();
    }

    public void clickRestorePassword(){
        PeregovorkaBooking peregovorkaBooking = new PeregovorkaBooking(driver);
        peregovorkaBooking.clickRestorePass();
    }

    public void clickMyEvents(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.myEvents();
    }

    public void reserveRMRandomButton(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.reservePlace();
        loginPage.reserveRM();
    }

    public void reserveMeetRoomRandomButton(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.reservePlace();
        loginPage.reserveMeetRoom();
    }

    public void checkText(){
        String pageSource = driver.getPageSource();
        Pattern russianPattern = Pattern.compile("[А-Яа-яЁё]");
        boolean containsRussian = russianPattern.matcher(pageSource).find();
        assertTrue("The page does not contain Russian characters", containsRussian);
    }

    public void checkTextExeptButtonGoogle(){
        String pageSource = driver.getPageSource();
        List<WebElement> elementsToExclude = driver.findElements(By.xpath("//span[text()='Вход с аккаунтом Google']"));
        for (WebElement element : elementsToExclude) {
            pageSource = pageSource.replace(element.getText(), "");
        }
        Pattern russianPattern = Pattern.compile("[А-Яа-яЁё]");
        boolean containsRussian = russianPattern.matcher(pageSource).find();
        assertTrue("The page does not contain Russian characters, excluding the 'Вход с аккаунтом Google' button", containsRussian);
    }

    public void checkTextExeptTextSyantovich(){
        String pageSource = driver.getPageSource();
        List<WebElement> elementsToExclude = driver.findElements(By.xpath("//h3[text()='Сыантович Алексей Сергеевич']"));
        for (WebElement element : elementsToExclude) {
            pageSource = pageSource.replace(element.getText(), "");
        }
        Pattern russianPattern = Pattern.compile("[А-Яа-яЁё]");
        boolean containsRussian = russianPattern.matcher(pageSource).find();
        assertTrue("The page does not contain Russian characters, excluding the 'Вход с аккаунтом Google' button", containsRussian);
    }

    public void checkNotificationAuthorization(){
        LoginPage loginPage = new LoginPage(driver);
        GeneralMethod generalMethod = new GeneralMethod(driver);
        generalMethod.login("111", "111");
        loginPage.clickLoginButton();
    }

    public void checkNotificationRegistration(){
        GeneralMethod generalMethod = new GeneralMethod(driver);
        generalMethod.krashEmail("email@service-it.by");
    }

    public  void checkNotificationAuth(){
        LoginPage loginPage = new LoginPage(driver);
        String errorMessagePresent = loginPage.getErrorMessageText();
        Assert.assertNotNull("Уведомление об ошибке не найдено", errorMessagePresent);
        Assert.assertEquals("Login or password is incorrect", errorMessagePresent);
    }

    public  void checkNotificationRestorePass(){
        LoginPage loginPage = new LoginPage(driver);
        String errorMessagePresent = loginPage.getErrorMessageText();
        Assert.assertNotNull("Уведомление об ошибке не найдено", errorMessagePresent);
        Assert.assertEquals("No employees found with the entered email", errorMessagePresent);
    }


    @Test
    public void testRussianLanguagePresenceAuth() {
        start();
        exit();
        checkTextExeptButtonGoogle();
    }

    @Test
    public void testRussianLanguagePresenceAuthKrash() {
        LoginPage loginPage = new LoginPage(driver);
        start();
        exit();
        checkNotificationAuthorization();
        checkTextExeptButtonGoogle();
    }

    @Test
    public void testRussianLanguagePresenceAuthKrashText() {
        start();
        exit();
        checkNotificationAuthorization();
        checkNotificationAuth();
    }

        @Test
    public void testRussianLanguagePresenceRegistration() {
        start();
        exit();
        clickRegistration();
        checkTextExeptButtonGoogle();
    }

    @Test
    public void testRussianLanguagePresenceRestorePassword() {
        start();
        exit();
        clickRestorePassword();
        checkTextExeptButtonGoogle();
    }

    @Test
    public void testRussianLanguagePresencenRestorePasswordKrash() {
        start();
        exit();
        clickRestorePassword();
        checkNotificationRegistration();
        checkTextExeptButtonGoogle();
    }

    @Test
    public void testRussianLanguagePresenceAuthRestorePasswordText() {
        start();
        exit();
        clickRestorePassword();
        checkNotificationRegistration();
        checkNotificationRestorePass();
    }

        @Test
    public void testRussianLanguagePresenceMyEvents() {
        start();
        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        Pattern russianPattern = Pattern.compile("[А-Яа-яЁё]");
        assertTrue(russianPattern.matcher(bodyText).find());
    }

    @Test
    public void testRussianLanguagePresenceBron() {
        start();
        clickMyEvents();
        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        Pattern russianPattern = Pattern.compile("[А-Яа-яЁё]");
        assertTrue(russianPattern.matcher(bodyText).find());
    }

    @Test
    public void testRussianLanguagePresenceSearch() {
        SearchPage searchPage = new SearchPage(driver);
        start();
        searchPage.clickSearchEng();
        searchPage.inputSearch("сыантович");
        searchPage.clickChel();
        checkTextExeptTextSyantovich();
    }

    @Test
    public void testRussianLanguagePresenceReserveRM() {
        start();
        reserveRMRandomButton();
        checkText();}

    @Test
    public void testRussianLanguagePresenceReserveMeetRoom() {
        start();
        reserveMeetRoomRandomButton();
        checkText();
    }


}

