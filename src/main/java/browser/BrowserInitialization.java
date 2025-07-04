package browser;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import data.ReadDataFromPropertiesFile;

public class BrowserInitialization {
	 public static WebDriver browserOpen(String browserName) throws IOException {
	        WebDriver driver;
	        
	        if (browserName.equalsIgnoreCase("chrome")) {
	            driver = new ChromeDriver();
	        } else if (browserName.equalsIgnoreCase("edge")) {
	            driver = new EdgeDriver();
	        } else if (browserName.equalsIgnoreCase("ff")) {
	            driver = new FirefoxDriver();
	        } else {
	            throw new IllegalArgumentException("Unsupported browser: " + browserName);
	        }
	        
	        driver.get(ReadDataFromPropertiesFile.readFromPropertyFile("url"));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        
	        return driver;
	 }

}
