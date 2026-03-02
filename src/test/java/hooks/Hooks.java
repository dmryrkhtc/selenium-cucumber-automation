package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;
    // her senaryodan once otomatik calis
    @Before
    public void setUp() {
        //WebDriver referansı ChromeDriver objesini tuttu
        driver = new ChromeDriver();
        //hedef site
        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}