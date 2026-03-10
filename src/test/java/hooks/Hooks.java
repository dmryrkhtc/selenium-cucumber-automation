package hooks;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import utilities.DriverManager;

public class Hooks {

    public static WebDriver driver;

    @BeforeAll

    public static void setUp(){


    driver= DriverManager.getDriver();
    }

    @AfterAll
    public static void tearDown() {
        DriverManager.quitDriver();
    }
}