package amazon;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import data.ReadDataFromPropertiesFile;
import utility.ReusableFunctions;

public class HomePage 
{
	
	@FindBy(id="nav-logo-sprites") WebElement logo;
	@FindBy(id="twotabsearchtextbox") WebElement tb_search;
	@FindBy(xpath="//div[@class='s-suggestion s-suggestion-ellipsis-direction']") 
	List<WebElement> txt_AutoSuggresionResults;
	
	ReusableFunctions reuse = new ReusableFunctions();
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void verifyLogo()
	{
		reuse.verifyElementDisplay(logo, "Amazon logo");
	}
	
	public void enterProduct() throws IOException
	{
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.clear();
		reuse.enterText(tb_search, "Seach box", ReadDataFromPropertiesFile.readFromPropertyFile("product"));
	}
	
	public void validateAutoSuggestionText() throws IOException
	{
		String product = ReadDataFromPropertiesFile.readFromPropertyFile("product");
		product = product.toLowerCase();
		for(WebElement eachProduct: txt_AutoSuggresionResults)
		{
			String suggestedProduct = eachProduct.getText();
			String subSuggested = suggestedProduct.substring(0, product.length());
			if(product.equals(subSuggested))
				System.out.println(product+" is matched with "+suggestedProduct);
			else
				System.out.println(product+" is not matched with "+suggestedProduct);
		}
	}
}
