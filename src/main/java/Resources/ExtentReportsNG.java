package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
    public static ExtentReports config(){

        //ExtentReport ExtentSparkReport

        String file = System.getProperty("user.dir")+"\\Reports\\Report.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(file);
        reporter.config().setReportName("Automation Result");
        reporter.config().setDocumentTitle("Test Result");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Pradyum");
        return extent;


    }

}
