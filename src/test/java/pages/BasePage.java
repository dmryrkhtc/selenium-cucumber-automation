package pages;
import org.openqa.selenium.WebDriver;
//ortak altyapi tiklama-girme
public class BasePage {

    //tum sayfalar driveri kullanabilecek
    protected WebDriver driver;

    //(constructor) web driveri alt siniflara aktarir ve pagefactory baslatir-ilk calisan metot
    public BasePage(WebDriver driver){
        this.driver=driver;

    }

}
