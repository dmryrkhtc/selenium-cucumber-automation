package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//driverı tek yerden yonetme amaci
public class DriverManager {
    private static WebDriver driver;
//driver olusturma-tek bir driver ornegi urettik
    public static WebDriver getDriver(){
        if (driver==null){
            String browserType=ConfigReader.get("browser").toLowerCase();
            switch(browserType){
                case "chrome":
                    ChromeOptions options =new ChromeOptions();
                    //tarayici tam ekran acar
                    options.addArguments("--start-maximized");
                    //notification popup cikarmaz
                    options.addArguments("--disable-notifications");
                    //tarayici gizli modta acilir
                    options.addArguments("--incognito");
            /* test çalışır ama tarayıcı görünmez
             options.addArguments("--headless"); */
                    driver = new ChromeDriver(options);
                    break;

                case "firefox":
                    //firefox driveri baslatir
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                case "edge":
                    //microsoft edge driver baslatir
                    driver=new EdgeDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    //yamlda yanlis yazım olursa hata firlat
                    throw new RuntimeException("Desteklenmeyen tarayıcı tipi: " + browserType);
            }




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
