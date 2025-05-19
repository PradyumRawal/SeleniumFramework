package Selenium.Framework;

import PageObjectModel.CartPage;
import PageObjectModel.ProductCatalogs;
import Selenium.Framework.TestComponents.BaseTest;
import Selenium.Framework.TestComponents.Retry;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends BaseTest {
    String productName = "ZARA COAT 3";
    @Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
    public void loginErrorValidation() throws IOException, InterruptedException {



        landingPage.loginWebsite("1Austin@gmail.com", "1Kill@dog1234");
        Assert.assertEquals("Incorrect email or Password.",landingPage.errorMessage());;



    }
     @Test(groups = {"ErrorHandling"})
    public void productErrorValidation() throws InterruptedException {

        landingPage.loginWebsite("Bunty10@gmail.com", "B@12345678b");
        ProductCatalogs productCatalogs = new ProductCatalogs(driver);
        List<WebElement> items = productCatalogs.itemsList();
        productCatalogs.addtoCart(productName);
        Thread.sleep(1000);
        productCatalogs.goToCart();
        CartPage cartPage = new CartPage(driver);
        List<WebElement> cartproducts = cartPage.cartItemsList();
        boolean match = cartPage.verifyProducts("ZaraCoat 33");
        Assert.assertFalse(match);

    }
}

