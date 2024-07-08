import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ExampleTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ekaterina.yanovskaya\\Desktop\\AUTO\\chromedriver.exe");

        // Инициализация экземпляра WebDriver для браузера Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginPageOne() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickRestorePassword();
        loginPage.enterEmail("email@gmail.com");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isNotificationDisplayed("Не найдено сотрудников с введенным email (email@gmail.com)"));

    }

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

    @Test
    public void testLoginPageThree(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterLogin("email@gmail.com");
        loginPage.enterPassword("1234567fsdfadfsafd");
        loginPage.clickLoginButton();
        String errorMessage = loginPage.getErrorMessageText();
        Assert.assertNotNull("Уведомление об ошибке не найдено", errorMessage);
        Assert.assertEquals("Текст уведомления об ошибке не соответствует ожидаемому", "Логин или пароль неверны", errorMessage);
    }

    @Test //проверяет кликабельна ли кнопка при вводе данных только одного поля из двух
    public void testLoginPageFour(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterLogin("email@gmail.com");
        boolean isButtonClickable = loginPage.isLoginButtonClickable();
        if (isButtonClickable) {
            loginPage.clickLoginButton();
        } else {
            System.out.println("Кнопка недоступна для нажатия.");
        }
    }

    @Test
    public void testLoginPageFive(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterLogin("email@gmail.com");
    }


}

