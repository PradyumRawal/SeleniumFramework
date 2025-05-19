package Selenium.Framework.TestComponents;

import PageObjectModel.landingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;

public class BaseTest {

    public WebDriver driver;
    public landingPage landingPage;

    public WebDriver initilizeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\New folder (10)\\New folder (2)\\Programs\\SeleniumFramework\\src\\main\\java\\Resources\\Gobal.properties");
        prop.load(fis);
        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
        //String browserName = prop.getProperty("browser");

        if (browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }

             driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));



        } else if (browserName.equalsIgnoreCase("edge")) {





            driver = new EdgeDriver();


        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return  driver;


    }
    public List<HashMap<String, String>> jsonGetDataToMap() throws IOException {
       String jsonContent =  FileUtils.readFileToString(new File("D:\\New folder (10)\\New folder (2)\\Programs\\SeleniumFramework\\src\\main\\java\\Resources\\LoginData.json"), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {});

        return data;

    }

    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
            TakesScreenshot ts = (TakesScreenshot) driver;

            // Get Base64 string of the screenshot
            String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);

            // Optionally, save the file to disk (if you still want to keep the file)
            File source = ts.getScreenshotAs(OutputType.FILE);
            File file = new File("D:\\New folder (10)\\New folder (2)\\Programs\\SeleniumFramework\\src\\main\\java\\Screenshots\\" + testCaseName + ".png");
            FileUtils.copyFile(source, file);

            // Return Base64 string
            return base64Screenshot;

    }




    @BeforeMethod(alwaysRun = true)
    public landingPage launchApplication() throws IOException {

        driver = initilizeDriver();
        landingPage = new landingPage(driver);
        landingPage.goTo();
        return landingPage;


    }
    @AfterMethod(alwaysRun = true)
    public void close(){

        driver.quit();


    }
}
