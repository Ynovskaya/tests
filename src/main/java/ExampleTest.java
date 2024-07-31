import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ExampleTest {
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

    /*@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/

    @Description("ВОССТАНОВЛЕНИЕ ПАРОЛЯ отображение уведомления об ошибке, проверка текста")
    @Test
    public void testLoginPageOne() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickRestorePassword();
        loginPage.enterEmail("email@gmail.com");
        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessageText();
        Assert.assertNotNull("Уведомление об ошибке не найдено", errorMessage);
        Assert.assertEquals("Текст уведомления об ошибке не соответствует ожидаемому", "Не найдено сотрудников с введенным email", errorMessage);
    }

    @Description("ВОССТАНОВЛЕНИЕ ПАРОЛЯ отображение уведомления об ошибке, проверка есть ли оно вообще")
    @Test
    public void testLoginPageTwo(){
        LoginPage loginPage = new LoginPage(driver);
        String email = "email@gmail.com";
        loginPage.openLoginPage();
        loginPage.clickRestorePassword();
        loginPage.enterEmail(email);
        loginPage.clickLoginButton();
        boolean errorMessagePresent = loginPage.checkErrorMessage();
        Assert.assertTrue("Уведомление об ошибке не найдено", errorMessagePresent);
    }

    @Description("АВТОРИЗАЦИЯ проверка уведомления на некорректные данные")
    @Test
    public void testLoginPageThree(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        GeneralMethod generalMethod = new GeneralMethod(driver);
        generalMethod.login("email@gmail.com", "1234567fsdfadfsafd");
        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessageText();
        Assert.assertNotNull("Уведомление об ошибке не найдено", errorMessage);
        Assert.assertEquals("Логин или пароль неверны", errorMessage);
    }

    @Description("РЕГИСТРАЦИЯ проверяет кликабельна ли кнопка при пустом поле ввода")
    @Test
    public void testLoginPageRegistration(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.registrationLink();
        WebElement button = driver.findElement(By.cssSelector("button.button-primary.disabled"));
        String classes = button.getAttribute("class");
        assertTrue(classes.contains("button-primary") && classes.contains("disabled"));
    }
    @Description("АВТОРИЗАЦИЯ проверяет кликабельна ли кнопка при пустых полях ввода")
    @Test
    public void testLoginPageFive(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        WebElement button = driver.findElement(By.cssSelector("button.button-primary.disabled"));
        String classes = button.getAttribute("class");
        assertTrue(classes.contains("button-primary") && classes.contains("disabled"));
    }
    @Description("АВТОРИЗАЦИЯ проверяет кликабельна ли кнопка при вводе данных только одного поля из двух")
    @Test
    public void testLoginPageFour(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterLogin("email@gmail.com");
        WebElement button = driver.findElement(By.cssSelector("button.button-primary.disabled"));
        String classes = button.getAttribute("class");
        assertTrue(classes.contains("button-primary") && classes.contains("disabled"));
    }
    @Description("АВТОРИЗАЦИЯ проверяет успешный вход в систему (на странице бронирования находит стрелку, которая указывает на выбор офиса)")
    @Test
    public void testLoginPageSuccessfully(){
        LoginPage loginPage = new LoginPage(driver);
        GeneralMethod generalMethod = new GeneralMethod(driver);
        generalMethod.login("1", "1");
        WebElement div = driver.findElement(By.cssSelector("div.PlacesFilterPanel__reminder__arrows"));
        String classes = div.getAttribute("class");
        assertTrue(classes.contains("PlacesFilterPanel__reminder__arrows"));
    }

    @Test
    public void testLoginPageEight(){
        SearchPage searchPage = new SearchPage(driver);
        GeneralMethod generalMethod = new GeneralMethod(driver);
        generalMethod.testLogin();
        searchPage.clickSearch();
        searchPage.inputSearch("сыантович");
        searchPage.clickChel();
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Бронирования не найдены')]"));
        String actualText = element.getText();
        String expectedText = "Бронирования не найдены";
        Assert.assertEquals("Текст на странице не соответствует ожидаемому", expectedText, actualText);
    }

    @Test
    public void testBronVodorodFourFloorRM(){
        BookingPage bookingPage = new BookingPage(driver);
        GeneralMethod generalMethod = new GeneralMethod(driver);
        BookingClass bookingClass = new BookingClass(driver);
        generalMethod.login("1", "1");
        bookingClass.clickCheckBox();
        generalMethod.clickRandomButton();
        bookingPage.clickCreateEventRM();
        bookingPage.clickOfficeChoice();
        bookingClass.choiseFourFloor();
        bookingClass.randomPlaceButton();
        bookingClass.clickSave();
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Рабочее место забронировано')]"));
        String actualText = element.getText();
        String expectedText = "Рабочее место забронировано";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testBronVodorodFourFloorPeregovorka(){
        GeneralMethod generalMethod = new GeneralMethod(driver);
        generalMethod.login("1", "1");
        generalMethod.clickRandomButton();
        PeregovorkaBooking peregovorkaBooking = new PeregovorkaBooking(driver);
        peregovorkaBooking.clickReservationPeregovorki();
        peregovorkaBooking.checkBox();
        peregovorkaBooking.clickFloorChoice();
        peregovorkaBooking.clickFloorFour();
        peregovorkaBooking.clickRandom();
        peregovorkaBooking.clickSave();
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Переговорка забронирована')]"));
        String actualText = element.getText();
        String expectedText = "Переговорка забронирована";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testBronVodorodFourFloorRM1() {
        GeneralMethod generalMethod = new GeneralMethod(driver);
        generalMethod.login("1", "1");
        generalMethod.clickRandomButton();
    }





}