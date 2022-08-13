import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class Tests {
    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void HappyPath() {

        driver.get("http://localhost:9999");

        driver.findElement(By.xpath("//input[@name = \"name\"]"))
                .sendKeys("Иванов Иван");

        driver.findElement(By.xpath("//input[@name = \"phone\"]"))
                .sendKeys("+79111111111");

        driver.findElement(By.cssSelector(".checkbox__text"))
                .click();

        driver.findElement(By.cssSelector(".button__text"))
                .click();



//        Assertions.assertTrue(driver.findElement(By.xpath("//p[@data-test-id ]"))
//                .getText().contains("Ваша заявка успешно отправлена!"));

        boolean excepted = true;
        boolean actual = driver.findElement(By.xpath("//p[@data-test-id ]"))
                .getText().contains("Ваша заявка успешно отправлена!");

        Assertions.assertEquals(excepted,actual);

    }

}


