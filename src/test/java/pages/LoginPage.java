package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//BasePage miras aldik
public class LoginPage extends BasePage {

    //elementler tanimlandi-bir degisiklik kolayca degisebilir formu
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By productsTitle = By.className("title");
    private By errorMessage= By.cssSelector("[data-test='error']");

    //basepage constructure cagirdik
    public LoginPage(WebDriver driver) {
        //basepage constructor gidip ayaga kaldiriyor
        super(driver);
    }

    public void login(String user, String pass) {
        //sendkeys metodu icinde bekleme var
        sendKeys(username,user);
        sendKeys(password,pass);
        click(loginBtn);
    }
    public String getProductsTitle() {

       return getText(productsTitle);
    }
    public String getErrorMessage(){

        return getText(errorMessage);
    }
}
