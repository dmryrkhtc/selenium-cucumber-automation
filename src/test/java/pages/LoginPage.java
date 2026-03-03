package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//BasePage miras aldik
public class LoginPage extends BasePage{

    //elementler tanimlandi-bir degisiklik kolayca degisebilir formu
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");

//basepage constructure cagirdik
public LoginPage(WebDriver driver){
    super(driver);
}

public void login (String user, String pass){
    driver.findElement(username).sendKeys(user);
    driver.findElement(password).sendKeys(pass);
    driver.findElement(loginBtn).click();
}

}
