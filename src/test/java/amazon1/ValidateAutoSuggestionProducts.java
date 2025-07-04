package amazon1;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;

import browser.BrowserInitialization;
import amazon.HomePage;
import amazon.Login;
import amazon.PasswordPage;

public class ValidateAutoSuggestionProducts 
{
@Test(dataProvider="AmazonLogins", dataProviderClass=data.ReadDataFromExcel.class)
public void loginsValidation(HashMap<String, String> logins) throws IOException 
	{
		WebDriver driver = BrowserInitialization.browserOpen("FF");
		Login login = new Login(driver);
		login.verifySignInPage();
		login.enterEmailAndClickContinue(logins.get("EmailId"));
		PasswordPage password = new PasswordPage(driver);
		password.verifyPasswordPage();
		password.enterPasswordAndClickSignIn(logins.get("Password"));
		HomePage home = new HomePage(driver);
		
		home.verifyLogo();
		home.enterProduct();
		home.validateAutoSuggestionText();
		driver.quit();
	}
}
