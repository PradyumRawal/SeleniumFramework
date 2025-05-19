package Selenium.Framework;

import PageObjectModel.*;
import Selenium.Framework.TestComponents.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
   // String productName = "ZARA COAT 3";
    @Test(dataProvider = "getData",groups = {"Purchase"})
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {



        landingPage.loginWebsite(input.get("email"), input.get("password"));
        ProductCatalogs productCatalogs = new ProductCatalogs(driver);
        List<WebElement> items = productCatalogs.itemsList();
        productCatalogs.addtoCart(input.get("productName"));
        Thread.sleep(1000);
        productCatalogs.goToCart();
        CartPage cartPage = new CartPage(driver);
        List<WebElement> cartproducts = cartPage.cartItemsList();
        boolean match = cartPage.verifyProducts(input.get("productName"));
        Assert.assertTrue(match);
        cartPage.clickCheckOut();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterCountry();
        checkout.placeOrder();

        orderDetailsPage orderPage = new orderDetailsPage(driver);

        String message = orderPage.orderMessage();
        System.out.println(message);
        Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
    }

    @Test(dependsOnMethods = {"submitOrder"},dataProvider = "getData",groups = {"Purchase"})
    public void orderHistory(HashMap<String,String> input){

        landingPage.loginWebsite(input.get("email"), input.get("password"));
        ProductCatalogs productCatalogs = new ProductCatalogs(driver);
        OrderPage orders = new OrderPage(driver);
        orders.gotoOrders();
        Assert.assertTrue(orders.verifyOrder(input.get("productName")));

    }



    @DataProvider
    public HashMap[][] getData() throws IOException {
       List<HashMap<String,String>> data = jsonGetDataToMap();
        return new HashMap[][]{ {data.get(0)},{data.get(1)}};

        //return new Object[] [] {{"Austin@gmail.com","Kill@dog1234","ZARA COAT 3"},{"Bunty10@gmail.com","B@12345678b","ADIDAS ORIGINAL"} };

    }



    }

