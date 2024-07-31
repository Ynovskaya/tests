import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BookingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String URL = "https://booky-test.service-it.by/sd/booking";

    @FindBy(xpath = "//div[text()='Целый день']")
    private WebElement checkBox;
    public void clickCheckBox() {
        clickElement(checkBox);
    }

    @FindBy(xpath = "//div[@class='input-field icon-under height-auto']")
    private WebElement office;

    @FindBy(xpath = "//div[text()='г. Минск, пр-т Независимости 32а (новый офис)']")
    private WebElement vodorod;

    @FindBy(xpath = "//div[@class='input-field icon-under height-auto  ']")
    private WebElement flooorr;

    @FindBy(xpath = "//label[text()='4-й этаж']")
    private WebElement finButton;

    @FindBy(xpath = "//button[text()='2 этаж']")
    private WebElement floorTwo;

    @FindBy(xpath = "//div[text()='Переговорка']")
    private WebElement peregovorka11;

    @FindBy(xpath = "//text[text()='Small room']")
    private WebElement peregovorka;

    @FindBy(xpath = "//span[text()='Создать мероприятие']")
    private WebElement createEvent;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div[2]/header/div[3]/div[1]/div[2]/div/span[2]")
    private WebElement createEventRM;
    public void clickCreateEventRM() { clickElement(createEventRM); }


    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div[1]/div/div/div[2]/div[1]/div[2]/div/div/div[1]")
    private WebElement floorChoice;
    public void clickOfficeChoice() { clickElement(floorChoice);    }

    @FindBy(xpath = "//div[@class='input-field icon-under height-auto']")
    private WebElement floorChoicee;
    public void clickFloorChoice() { clickElement(floorChoicee);    }

    @FindBy(xpath = "//div[text()='ЗАО «Водород»']")
    private WebElement clickOffice;
    public void clickOfficeVodorod() { clickElement(clickOffice);    }

    @FindBy(xpath = "//div[text()='Выберите этаж']")
    private WebElement clickFloor;
    public void clickChoiseFloor() { clickElement(clickFloor);    }

    @FindBy(xpath = "(//div[contains(@class, 'CheckboxComponent__checkbox')])[2]")
    private WebElement floorFour;
    public void clickFloorFour() {
        clickElement(floorFour);
    }

    @FindBy(xpath = "//button[@class='button-secondary ']")
    private WebElement buttonRandom;

    @FindBy(xpath = "//button[text()='Сохранить']")
    private WebElement saveButton;
    public void clickSave() { clickElement(saveButton); }

    @FindBy(xpath = "//button[@class='button-primary']")
    private WebElement goToMyEvent;

    @FindBy(xpath = "//input[@id='place']")
    private WebElement placeInput;

    @FindBy(xpath = "//circle[@class='placeStatus-2']")
    private WebElement placeCircle;


    public void openBookingPage() {
        driver.get(URL);
    }

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickOffice() {
        clickElement(office);
    }

    public void clickVodorod() {
        clickElement(vodorod);
    }

    public void clickFloor() { clickElement(flooorr);  }

    public void clickFlooorr() {clickElement(finButton);}

    public void clickFin() {
        clickElement(finButton);
    }

    public void clickFloorTwo() {
        clickElement(floorTwo);
    }

    public void clickCreateEvent() {
        clickElement(createEvent);
    }

    public void clickButtonRandom() { clickElement(buttonRandom); }

    public void clickGoToMyEvent() { clickElement(goToMyEvent); }

    public String getInputPlaceValue() {
        return placeInput.getAttribute("value");
    }

    public void clickPlaceCircle() {
        clickElement(placeCircle);
    }


}