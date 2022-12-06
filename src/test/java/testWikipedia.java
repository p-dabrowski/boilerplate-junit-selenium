import org.example.pages.WikipediaPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testWikipedia {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testOpenWikipedia() {
        driver.get("https://www.wikipedia.org");
        WikipediaPage wikipediaPage = new WikipediaPage(driver);

        //Assertions.assertTrue(driver.getTitle().equals("Wikipedia"));
        Assertions.assertTrue(wikipediaPage.isMainPageLoaded());
    }
}
