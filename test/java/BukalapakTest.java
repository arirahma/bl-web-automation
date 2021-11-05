import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BukalapakTest {
    WebDriver driver;
    WebDriverWait wait;

    By loginBtn = By.xpath("//*[@class='sigil-header__nav te-header-login']");
    By loginText = By.xpath("//*[.='Login dulu, yuk']");
    By emailTextField = By.xpath("//*[@id='user_identity_textfield']");
    By lanjutBtn = By.xpath("//*[@id='submit_button']");
    By verifikasiText = By.xpath("//*[@class='Verifikasi Login']");
    By errorText = By.xpath("//*[@class='bl-text-field__message']");

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,15);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void login() {
        driver.get("https://www.bukalapak.com/");
        driver.findElement(loginBtn).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginText)));
        driver.findElement(emailTextField).click();
        driver.findElement(emailTextField).sendKeys("081316877754");
        driver.findElement(lanjutBtn).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(verifikasiText)));
        //need OTP for access login. if you need automated this test case you need whitelist OTP process.
    }

    @Test
    public void loginIvalidEmail() {
        driver.get("https://www.bukalapak.com/");
        driver.findElement(loginBtn).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginText)));
        driver.findElement(emailTextField).click();
        driver.findElement(emailTextField).sendKeys("test@test");
        driver.findElement(lanjutBtn).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorText)));
    }
}
