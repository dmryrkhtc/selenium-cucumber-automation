package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage =new LoginPage(Hooks.driver);
    @Given("user is on login page")
    public void user_on_login_page(){
        Hooks.driver.get("https://www.saucedemo.com/");
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
}
