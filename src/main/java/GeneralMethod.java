import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.WebElement;

public class GeneralMethod {

    private WebDriver driver;
    private WebDriverWait wait;

    public GeneralMethod(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openLoginPage() {
        driver.get("https://booky-test.service-it.by/sd/booking");
    }

    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.enterLogin(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    public void krashEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.registrationInput(email);
        loginPage.clickLoginButton();
    }

    public void vodorodOfice() {
        login("1", "1");
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.clickCheckBox();
        bookingPage.clickOffice();
        bookingPage.clickVodorod();
    }

    public void testLogin() {
        login("1", "1");
    }

    public void vodorodFourFloor() {
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.clickCheckBox();
        bookingPage.clickOffice();
        bookingPage.clickVodorod();
        bookingPage.clickFloorChoice();
        bookingPage.clickFloorFour();

    }

    public void choiceFloor(){
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.clickCheckBox();
        bookingPage.clickOffice();
        bookingPage.clickVodorod();
        bookingPage.clickFloor();
        bookingPage.clickFlooorr();
        bookingPage.clickFloorTwo();
        bookingPage.clickPlaceCircle();
    }

    public void createEventRM() {
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.clickChoiseFloor();
        bookingPage.clickFloorFour();
        bookingPage.clickCheckBox();
        bookingPage.clickButtonRandom();
        bookingPage.clickSave();
        bookingPage.clickGoToMyEvent();
    }

    public void createEventRMRandom(){
        BookingClass bookingClass = new BookingClass(driver);
        bookingClass.clickCheckBox();
        bookingClass.choiseFloor();
        bookingClass.choiseFourFloor();
        bookingClass.randomPlaceButton();
        bookingClass.clickSave();
    }

    public void clickRandomButton(){
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.clickFloorChoice();
        bookingPage.clickOfficeVodorod();
        bookingPage.clickCreateEvent();
    }

    public void reservationPeregovorka(){
        PeregovorkaBooking peregovorkaBooking = new PeregovorkaBooking(driver);
        peregovorkaBooking.clickReservationPeregovorki();
        peregovorkaBooking.checkBox();
        peregovorkaBooking.clickOfficePeregovorki();
        peregovorkaBooking.clickVodorod();
        peregovorkaBooking.checkBox();
        peregovorkaBooking.clickFloorChoice();
        peregovorkaBooking.clickFloorFour();
        peregovorkaBooking.clickRandom();
        peregovorkaBooking.clickSave();
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clickChangeLanguageEng() {
        PeregovorkaBooking peregovorkaBooking = new PeregovorkaBooking(driver);
        peregovorkaBooking.clickAvatar();
        peregovorkaBooking.clickChangeLanguage();
        peregovorkaBooking.clickChangeLanguageEnglish();
    }

    public void clickChangeLanguageEngAndExit() {
        PeregovorkaBooking peregovorkaBooking = new PeregovorkaBooking(driver);
        peregovorkaBooking.clickAvatar();
        peregovorkaBooking.clickExit();
    }


}