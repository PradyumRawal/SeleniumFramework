package PageObjectModel;

import ResuableComponents.Reuse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends Reuse {
    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        super(driver);

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement selectCountry;

    @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]" )
    WebElement select;

    @FindBy(xpath = "//a[contains(.,'Place Order')]")
    WebElement placeOrder;

    public void enterCountry(){
        selectCountry.sendKeys("Ind");
        actions(select);
    }
    public void placeOrder(){
        actions(placeOrder);
    }



}
