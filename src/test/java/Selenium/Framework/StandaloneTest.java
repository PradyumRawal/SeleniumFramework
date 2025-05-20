package Selenium.Framework;

import PageObjectModel.landingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandaloneTest {

    public static void main(String[] args) {
        String productName = "ZARA COAT 3";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));;
        driver.get("https://rahulshettyacademy.com/client");
        landingPage landingPage = new landingPage(driver);


        driver.findElement(By.id("userEmail")).sendKeys("Austin@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Kill@dog1234");
        driver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        List<WebElement> items = (driver.findElements(By.cssSelector(".mb-3")));

        WebElement product = items.stream().filter(item->item.
                findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        product.findElement(By.className("w-10")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

       // WebElement product1 = items.stream().filter(item->item.
               // findElement(By.tagName("b")).getText().equalsIgnoreCase("ADIDAS ORIGINAL")).findFirst().orElse(null);
       // product1.findElement(By.className("w-10")).click();

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

       // wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

       // WebElement product2 = items.stream().filter(item->item.
                ///findElement(By.tagName("b")).getText().equalsIgnoreCase("IPHONE 13 PRO")).findFirst().orElse(null);
        //product2.findElement(By.className("w-10")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));

       boolean match  =   cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
       Assert.assertTrue(match);

       driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();

       //driver.findElement(By.xpath("//div[@class='form__cc']/div[@class='row'][2]/li[2")).sendKeys("123");
       //driver.findElement(By.xpath("//div[@class='form__cc']//div[1]//div[1]//input[1]")).sendKeys("Austin");

       driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");

        Actions actions = new Actions(driver);
       // actions.moveToElement(driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)"))).click().build().perform();
        actions.moveToElement(driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]"))).click().build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Place Order')]"))).click().build().perform();


        //for (int i = 0 ; i< items.size();i++){
         //String itemName =  items.get(i).findElement(By.tagName("b")).getText();
        // System.out.println(itemName);
        //if (itemName.equalsIgnoreCase("ZARA COAT 3")){
        //  driver.findElement(By.className("w-10")).click();

         }



        }


