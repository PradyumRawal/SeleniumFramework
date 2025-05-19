package PageObjectModel;

import ResuableComponents.Reuse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderDetailsPage extends Reuse {
    WebDriver driver;
    public orderDetailsPage(WebDriver driver) {
        super(driver);

        this.driver = driver;


        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".hero-primary")
    WebElement confrimMessage;


    public String orderMessage(){

       String message = confrimMessage.getText();
       return message;





    }


    }


