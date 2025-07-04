package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ReusableFunctions;

public class PasswordPage 
{
	@FindBy(xpath="//label[contains(text(),'Password')]") WebElement txt_password;
	@FindBy(name="password") WebElement tb_pwd;
	@FindBy(id="signInSubmit") WebElement btn_signIn;
	
	ReusableFunctions reuse = new ReusableFunctions();
	
	WebDriver driver;
	public PasswordPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPasswordPage()
	{
		reuse.verifyElementDisplay(txt_password, "password text");
	}
	
	public void enterPasswordAndClickSignIn(String pw)
	{
		reuse.enterText(tb_pwd, "Password text box", pw);
		reuse.clickElement(btn_signIn, "Sign in button");
	}
}
