package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//driverı tek yerden yonetme amaci
public class DriverManager {
    private static WebDriver driver;
//driver olusturma-tek bir driver ornegi urettik
    public static WebDriver getDriver(){
        if (driver==null){
            ChromeOptions options= new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        return  driver;
    }
//driver kapatma
    public static void quitDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

    }
