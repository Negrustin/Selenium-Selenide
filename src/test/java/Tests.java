import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {

        driver.get("http://localhost:9999");

        driver.findElement(By.xpath("//input[@name = \"name\"]"))
                .sendKeys("Иванов Иван");

        driver.findElement(By.xpath("//input[@name = \"phone\"]"))
                .sendKeys("+79111111111");

        driver.findElement(By.cssSelector(".checkbox__text"))
                .click();

        driver.findElement(By.cssSelector(".button__text"))
                .click();

        driver.findElement(By.xpath("//p[@data-test-id ][contains(text(), \"Ваша заявка успешно отправлена!\")]"));

    }

}

