package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ReusableFunctions;

public class Login 
{
	@FindBy(xpath="//h1[contains(text(),'Sign in')]") WebElement txt_SignIn;
	@FindBy(name="email") WebElement tb_email;
	@FindBy(id="continue") WebElement btn_continue;
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	ReusableFunctions reuse = new ReusableFunctions();
	public void verifySignInPage()
	{
		reuse.verifyElementDisplay(txt_SignIn, "Sign In text");
	}
	
	public void enterEmailAndClickContinue(String un)
	{
		reuse.enterText(tb_email, "Email text box", un);
		reuse.clickElement(btn_continue, "Continue button");
	}
}
