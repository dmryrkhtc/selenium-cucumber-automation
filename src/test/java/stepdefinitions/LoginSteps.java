package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage =new LoginPage(Hooks.driver);
    @Given("user is on login page")
    public void user_on_login_page(){
        //zaten hook acti
    }
    @When("user enters valid username and password")
    public void user_enters_credentials(){
        //sayfa giris bilgileri
        loginPage.login("standard_user","secret_sauce");
    }
    @Then("user should see homepage")
    public void verify_homepage(){
        System.out.println("Login Başarılı!");
    }
}
