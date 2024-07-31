import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PeregovorkaBooking {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String URL = "https://booky-test.service-it.by/sd/booking";

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div[2]/header/div[3]/div[1]/div[2]/div/span[1]")
    private WebElement clickOfficePeregovorki;
    public void clickOfficePeregovorki() {
        clickElement(clickOfficePeregovorki);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div[2]/header/div[3]/div[1]/div[2]/div/span[1]")
    private WebElement bronPeregovorki;
    public void clickReservationPeregovorki() {
        clickElement(bronPeregovorki);
    }

    @FindBy(xpath = "//div[text()='г. Минск, пр-т Независимости 32а (новый офис)']")
    private WebElement vodorod;
    public void clickVodorod() {
        clickElement(vodorod);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div[1]/div/div/div[2]/div[1]/div[5]/div/div/div[1]/div")
    private WebElement floorChoice;
    public void clickFloorChoice() {
        clickElement(floorChoice);
    }

    @FindBy(xpath = "//label[text()='4-й этаж']")
    private WebElement floorFour;
    public void clickFloorFour() {
        clickElement(floorFour);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div[1]/div/div/div[2]/div[1]/div[7]/div[2]/div/label")
    private WebElement checkBox;
    public void checkBox () { clickElement(checkBox);}

    @FindBy(xpath = "//button[@class='button-secondary ']")
    private WebElement clickRandom;
    public void clickRandom() { clickElement(clickRandom);}

    @FindBy(xpath = "//button[text()='Сохранить']")
    private WebElement clickSave;
    public void clickSave() { clickElement(clickSave);}

    @FindBy(xpath = "//span[text()='tt']")
    private WebElement clickAvatar;
    public void clickAvatar() { clickElement(clickAvatar); }

    @FindBy(xpath = "//span[text()='Сменить язык']")
    private WebElement clickChangeLanguage;
    public void clickChangeLanguage() { clickElement(clickChangeLanguage); }

    @FindBy(xpath = "//div[text()='English']")
    private WebElement clickChangeLanguageEng;
    public void clickChangeLanguageEnglish() { clickElement(clickChangeLanguageEng); }

    @FindBy(xpath = "//span[text()='Exit']")
    private WebElement clickExit;
    public void clickExit() { clickElement(clickExit); }

    @FindBy(xpath = "//span[text()='Registration']")
    private WebElement clickRegistration;
    public void clickRegistration() { clickElement(clickRegistration); }

    @FindBy(xpath = "//span[text()='Password recovery']")
    private WebElement clickRestorePass;
    public void clickRestorePass() { clickElement(clickRestorePass); }

    public void openBookingPage() {
        driver.get(URL);
    }

    public PeregovorkaBooking(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

}
