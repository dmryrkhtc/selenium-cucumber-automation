package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

public class ProductSteps {
    ProductsPage productsPage= new ProductsPage(Hooks.driver);
    LoginPage loginPage = new LoginPage(Hooks.driver);
    @Given("user logged as {string} and {string}")
    public void user_logged_in_products_page(String user,String pass){

        Hooks.driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user","secret_sauce");

    }
    @Then("all products should be visible on the page")
    public void verify_productPage(){

        int productCount = productsPage.getProductCount();
     Assertions.assertEquals(6,productCount);
    }

    @Then("user should see product {string}")

    public void user_should_see_productNames(String productName){


        List<WebElement> products = productsPage.getProductNames();
        boolean found = false;

        for(WebElement product : products){

            if(product.getText().equals(productName)){
                found = true;
                break;
            }
        }

        Assertions.assertTrue(found);
        Assertions.assertTrue(found, "Product not found: " + productName);

    }

}

