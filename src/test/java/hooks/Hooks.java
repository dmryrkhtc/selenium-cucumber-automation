package hooks;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.DriverManager;

public class Hooks {

    public static WebDriver driver;

    @BeforeAll

    public static void setUp(){

// tum testler baslamadan bir kez calisir
    driver= DriverManager.getDriver();
    }
    @After
    public void takeScreenshotOnFailure(Scenario scenario){
        //her senaryo sonunda calisir
        //tarayici kapatmaz,hata varsa fotograf ceker
        if(scenario.isFailed()){
            final byte[] screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }
    }

    @AfterAll
    public static void tearDown() {
        // tum testler bittikten sonra bir kez calisir
        DriverManager.quitDriver();
    }
}