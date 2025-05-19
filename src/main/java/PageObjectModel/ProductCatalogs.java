package PageObjectModel;

import ResuableComponents.Reuse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogs extends Reuse {

    WebDriver driver;

    public ProductCatalogs(WebDriver driver){
        super(driver);

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    //List<WebElement> items = (driver.findElements(By.cssSelector(".mb-3")));

    @FindBy(css = ".mb-3")
    List<WebElement> items;

    By productBy = By.cssSelector(".mb-3");
    By addToCart = By.className("w-10");
    By toastMessage = By.cssSelector("#toast-container");

    @FindBy(css = ".ng-animating")
    WebElement waitElement;



    public List<WebElement> itemsList(){
        waitForElement(productBy);
        return items;

    }

    public WebElement getProduct(String productName) {
        WebElement product = items.stream().filter(item -> item.
                findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);

        return product;
    }
    public void addtoCart(String productName){
        WebElement product = getProduct(productName);
        product.findElement(addToCart).click();
        waitForElement(toastMessage);
        waitForElementToDisappear(waitElement);


    }

}
