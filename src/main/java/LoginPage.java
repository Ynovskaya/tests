import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class LoginPage {
    private WebDriver driver;

    LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get("https://booky.service-it.by/sd/booking");
    }

    public void enterLogin(String email) {
        WebElement emailField = driver.findElement(By.id("login"));
        emailField.sendKeys(email);
    }

    public void enterPassword(String pass) {
        WebElement inputPass = driver.findElement(By.id("password"));
        inputPass.sendKeys(pass);
    }
    public void clickRestorePassword() {
        WebElement spanElement = driver.findElement(By.xpath("//span[text()='Восстановление пароля']"));
        spanElement.click();
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-primary ']"));
        loginButton.click();
    }

    public boolean isNotificationDisplayed(String expectedText) {
        try {
            WebElement notification = driver.findElement(By.xpath("//div[@class='notification']"));
            return notification.getText().contains(expectedText);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getEmailValue() {
        WebElement emailField = driver.findElement(By.id("email"));
        return emailField.getAttribute("value");
    }

    public boolean  checkErrorMessage() {
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'PopUpError__error-message')]"));
            System.out.println("Уведомление об ошибке: " + errorMessage.getText());
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Уведомление об ошибке не найдено");
            return false;
        }
    }

    public String getErrorMessageText() {
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'PopUpError__error-message')]"));
            return errorMessage.getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean isLoginButtonClickable() {
        try {
            WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-primary ']"));
            return loginButton.isEnabled() && loginButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }



}
