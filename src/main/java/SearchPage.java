import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private WebDriver driver;

    SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openBookingPage() {
        driver.get("https://booky-test.service-it.by/sd/booking");
    }

    public void clickSearch() {
        WebElement checkBox = driver.findElement(By.xpath("//span[text()='Поиск']"));
        checkBox.click();
    }

    public void clickSearchEng() {
        WebElement checkBox = driver.findElement(By.xpath("//span[text()='Search']"));
        checkBox.click();
    }

    public void inputSearch(String text) {
        WebElement inputSearch = driver.findElement(By.xpath("//input[@class='input-field']"));
        inputSearch.sendKeys(text);
    }

    public void clickChel() {
        WebElement clickChel = driver.findElement(By.xpath("//div[text()='Сыантович Алексей Сергеевич']"));
        clickChel.click();
    }

    public  void check(){
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'Бронирования не найдены')]"));

    }
}