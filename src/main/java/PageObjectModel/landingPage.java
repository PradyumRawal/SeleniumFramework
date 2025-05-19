package PageObjectModel;

import ResuableComponents.Reuse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage extends Reuse {

    WebDriver driver;

    public landingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    //WebElement userEmail = driver.findElement(By.id("userEmail"));

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement submit;

    @FindBy(css = "[class*='flyInOut']")
    WebElement error;

    public void loginWebsite(String email, String password){

        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submit.click();
    }

    public String errorMessage(){
        waitElement(error);
        return error.getText();

    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }


}
