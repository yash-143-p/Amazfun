package utility;

//import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

public class ReusableFunctions 
{
	public void verifyElementDisplay(WebElement wbe, String desc)
	{
		boolean displayStatus=false;
		try 
		{
			displayStatus = wbe.isDisplayed();
		}
		catch (NoSuchElementException e) 
		{
			System.out.println(desc+" element not displayed");
			assertTrue(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			assertTrue(false);
		}
		if(displayStatus)
			System.out.println(desc+" is displayed");
		else
			assertTrue(false);
	}
	
	public void enterText(WebElement wbe, String desc, String text)
	{
		try 
		{
			wbe.clear();
			wbe.sendKeys(text);
			wbe.click();
		}
		catch (NoSuchElementException e) 
		{
			System.out.println(desc+" element not displayed");
			assertTrue(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			assertTrue(false);
		}
		String actualText = wbe.getAttribute("value");
		if(actualText.length()==0)
		{
			System.out.println(desc+" empty");
			assertTrue(false);
		}
		else if(actualText.equals(text))
			System.out.println(text+" entered correctly");
		else
			System.out.println(text+" not entered correcly");
		
	}
	
	public void clickElement(WebElement wbe, String desc)
	{
		try 
		{
			wbe.click();
		}
		catch (NoSuchElementException e) 
		{
			System.out.println(desc+" element not displayed");
			assertTrue(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
