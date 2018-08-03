package gov.census.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gov.census.utilities.Driver;
//hOMEPAGE
public class HomePage {
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(partialLinkText = "Audio")
	public WebElement audio;
	@FindBy(xpath = "//button[@title='Close subscription dialog']")
	public WebElement closeSubDialogPopUp;
	//// E[starts-with(@A, 't')]
	// "https://www.census.gov/library.html"
	// //a[@tabindex='121']
	@FindBy(xpath = "//div[contains(text(),' Library ')]")
	public WebElement libraryLink;

	@FindBy(xpath = "(//ul[@class='nav nav-pills'])[7]//a")
	public List<WebElement> libraryListPart1;
	@FindBy(xpath = "(//ul[@class='nav nav-pills'])[8]//a")
	public List<WebElement> libraryListPart2;
	
    @FindBy(xpath = "(//li[@class='categories subCategoryButton'])[29]//a")
	public WebElement linkInfoAndVisualizations;
    
	// get a text out of library options using javascript executor
	public List<String> getLibraryOptions(List<WebElement> libraryList) {
		List<String> list = new ArrayList();
		JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
		
		for (WebElement el : libraryList) {
			System.out.println(jse.executeScript("return arguments[0].text", el));
		}
		
		return list;
	}

	
	
	
	
	
	
	
}
