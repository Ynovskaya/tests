import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String URL = "https://booky-test.service-it.by/sd/booking";

    @FindBy(id = "login")
    private WebElement emailField;
    public void enterLogin(String email) {
        enterText(emailField, email);
    }

    @FindBy(id = "password")
    private WebElement passwordField;
    public void enterPassword(String pass) {
        enterText(passwordField, pass);
    }

    @FindBy(xpath = "//button[@class='button-primary ']")
    private WebElement loginButton;
    public void clickLoginButton() {
        clickElement(loginButton);
    }

    @FindBy(xpath = "//span[text()='Восстановление пароля']")
    private WebElement restorePasswordLink;

    @FindBy(xpath = "//span[text()='Password recovery']")
    private WebElement restorePassLink;
    public void restorePassLink() { clickElement(restorePassLink);}


    @FindBy(xpath = "//span[text()='Регистрация']")
    private WebElement registrationLink;
    public void registrationLink() { clickElement(registrationLink);}

    @FindBy(id="email")
    private WebElement registrationInput;
    public void registrationInput(String email) { enterText(registrationInput, email);}


    @FindBy(id = "email")
    private WebElement emailFieldForRestore;

    @FindBy(xpath = "//div[@class='notification']")
    private WebElement notification;

    @FindBy(xpath = "//div[contains(@class, 'PopUpError__error-message')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[text()='My events']")
    private WebElement myEvents;
    public void myEvents() { clickElement(myEvents);}

    @FindBy(xpath = "//span[text()='Create an event']")
    private WebElement reservePlace;
    public void reservePlace() { clickElement(reservePlace);}

    @FindBy(xpath = "//span[text()='Book Meeting room']")
    private WebElement reserveRM;
    public void reserveRM() { clickElement(reserveRM);}

    @FindBy(xpath = "//span[text()='Book Working place']")
    private WebElement reserveMeetRoom;
    public void reserveMeetRoom() { clickElement(reserveMeetRoom);}

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        driver.get(URL);
    }

    private void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickRestorePassword() {
        clickElement(restorePasswordLink);
    }

    public void enterEmail(String email) {
        enterText(emailFieldForRestore, email);
    }

    public boolean isNotificationDisplayed(String expectedText) {
        try {
            wait.until(ExpectedConditions.visibilityOf(notification));
            return notification.getText().contains(expectedText);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getEmailValue() {
        return wait.until(ExpectedConditions.visibilityOf(emailFieldForRestore)).getAttribute("value");
    }

    public boolean checkErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            System.out.println("Уведомление об ошибке: " + errorMessage.getText());
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Уведомление об ошибке не найдено");
            return false;
        }
    }

    public String getErrorMessageText() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

}