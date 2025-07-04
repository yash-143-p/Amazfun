package utility;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

//import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting {

    @Test
    public void generateReport() throws IOException {
        
        // 1. Create the HTML report file
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./extent-report/extent.html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Testing");
        htmlReporter.config().setTheme(Theme.STANDARD); // Optional: DARK or STANDARD
        
        // 2. Create ExtentReports and attach the HtmlReporter
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // 3. Create a test case
        ExtentTest test = extent.createTest("Login Test", "Test login with valid credentials");
        
        // 4. Log steps
        test.log(Status.INFO, "Opening Browser");
        test.log(Status.INFO, "Navigating to URL");
        test.pass("Login test passed");
        Assert.fail("Validation error shown"); // will mark it as failed
        
        // 5. Attach screenshot (optional - ensure file exists)
        test.addScreenCaptureFromPath("./extent-report/screenshot.png");
        
        // 6. Finalize the report
        extent.flush();
    }
}
