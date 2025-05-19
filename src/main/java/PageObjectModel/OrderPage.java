package PageObjectModel;

import ResuableComponents.Reuse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends Reuse {

WebDriver driver;

public OrderPage(WebDriver driver){
    super (driver);

    this.driver = driver;
    PageFactory.initElements(driver,this);

}
@FindBy (css = "tr td:nth-child(3)")
    List<WebElement> orderProduct;



    public boolean verifyOrder(String productName){
        boolean match  = orderProduct.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
        return match;

    }


}
