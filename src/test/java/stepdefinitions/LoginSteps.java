package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginSteps {
    LoginPage loginPage =new LoginPage(
            //hooks uzerinden gelen tek bir static driver kullanıyoruz
            Hooks.driver
    );
    @Given("user is on login page")
    public void user_on_login_page(){
        Hooks.driver.get(ConfigReader.get("url"));
    }
    //tek senaryo birden fazla kullanici
    @When("user enters valid {string} and {string}")
    public void user_enters_credentials(String username, String password){
        //sayfa giris bilgileri
        loginPage.login(username,password);
    }
    @Then("user should see homepage")
    public void verify_homepage(){
        String actualTitle = loginPage.getProductsTitle();
        Assertions.assertEquals("Products", actualTitle);

    }
    @When("user enters invalid {string} and {string}")
    public void user_enters_invalid_credentials(String username,String password){
        loginPage.login(username,password);
    }
    @Then("user should see error message")
    public void user_should_see_error_message(){

        String err = loginPage.getErrorMessage();
        Assertions.assertTrue(err.contains("Username and password do not match")|| err.contains("locked out"),"Hata mesajı beklenen içeriği barındırmıyor!");

    }
}
