package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitManager;

import java.util.List;

//ortak altyapi tiklama-girme
public class BasePage {

    //tum sayfalar driveri kullanabilecek
    protected WebDriver driver;

    //(constructor) web driveri alt siniflara aktarir ve pagefactory baslatir-ilk calisan metot
    public BasePage(WebDriver driver){
        this.driver=driver;

    }
protected void click(By locator){
    WaitManager.waitForVisibility(locator);
    driver.findElement(locator).click();
}
protected void sendKeys(By locator, String text){
        WaitManager.waitForVisibility(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);

}
 protected String getText(By locator){
        WaitManager.waitForVisibility(locator);
        return driver.findElement(locator).getText(); }

    // List<WebElement> kullandığımız için
    protected List<WebElement> findElements(By locator){
        WaitManager.waitForVisibility(locator);
        return driver.findElements(locator);
    }



}

