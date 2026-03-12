package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitManager;

import java.util.List;

public class ProductsPage extends BasePage{

    private By products = By.className("inventory_item");
    private By productNames= By.className("inventory_item_name");
    public ProductsPage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> getAllProducts(){
        WaitManager.waitForVisibility(products);
       return findElements(products);

    }
    public List<WebElement> getProductNames(){
        WaitManager.waitForVisibility(productNames);
        return findElements(productNames);
    }
public int getProductCount(){
        return getAllProducts().size();
}
}

