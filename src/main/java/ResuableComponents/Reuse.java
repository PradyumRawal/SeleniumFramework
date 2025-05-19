package ResuableComponents;

import PageObjectModel.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Reuse {
    WebDriver driver;

    public Reuse(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement goCart;
    @FindBy (css = "[routerlink*='myorders']")
    WebElement orderHeader;

    public void waitForElement(By findby){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));

    }

    public void waitElement(WebElement findby) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findby));


    }
    public void waitForElementToDisappear(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele));

    }
    public void goToCart(){
        goCart.click();
    }

    public void gotoOrders(){
        orderHeader.click();

    }


    public void actions(WebElement ele){
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).click().build().perform();




    }


    }



    
