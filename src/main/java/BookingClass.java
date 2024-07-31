import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BookingClass {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String URL = "https://booky-test.service-it.by/sd/booking";

    public void openBookingPage() {
        driver.get(URL);
    }

    public BookingClass(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    @FindBy(xpath = "//label[text()='Целый день']")
    private WebElement checkBox;
    public void clickCheckBox() {
        clickElement(checkBox);
    }

    @FindBy(xpath = "//div[text()='Выберите этаж']")
    private WebElement choiseFloor;
    public void choiseFloor() {
        clickElement(choiseFloor);
    }

    @FindBy(xpath = "//label[text()='Выбрать все']")
    private WebElement choiseFourFloor;
    public void choiseFourFloor() {
        clickElement(choiseFourFloor);
    }

    @FindBy(xpath = "//button[text()='свободное место']")
    private WebElement randomPlaceButton;
    public void randomPlaceButton() {
        clickElement(randomPlaceButton);
    }

    @FindBy(xpath = "//button[text()='Сохранить']")
    private WebElement clickSave;
    public void clickSave() {
        clickElement(clickSave);
    }


}