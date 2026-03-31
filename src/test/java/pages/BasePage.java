package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//ortak altyapi tiklama-girme
public class BasePage {

    //tum sayfalar driveri kullanabilecek
    protected WebDriver driver;
    //bekleme obejemiz
    protected WebDriverWait wait;

    //(constructor) web driveri alt siniflara aktarir ve pagefactory baslatir-ilk calisan metot
    public BasePage(WebDriver driver){
        this.driver=driver;
        //yaml timeout suresi alıyoruz
        int timeout=Integer.parseInt(ConfigReader.get("timeout"));
        //webdriverwait objesini burada bir kez olusturuyoruz
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));

    }
    //tiklama metodu
protected void click(By locator){
wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
}
//yazi yazma metodu gorunur olana kadar bekle temizle yaz
protected void sendKeys(By locator, String text){
        WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);

}
 protected String getText(By locator){
 //element domda var mi ve gorunur mu
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    // List<WebElement> kullandığımız için
    protected List<WebElement> findElements(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
protected WebElement findElement(By locator){
return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    //element yoksa false don ve devam et
    protected boolean isDisplayed(By locator){
      try{
          return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
      }catch(Exception e){
          return false;
      }
    }
protected List<String> getElementsText(By locator){
        List<WebElement> elements = findElements(locator);
        List<String> texts= new ArrayList<>();
        for(WebElement element:elements){
            texts.add(element.getText());
        }
        return texts;

}

}

