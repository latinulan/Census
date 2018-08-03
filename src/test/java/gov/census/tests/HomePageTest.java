package gov.census.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import gov.census.pages.HomePage;
import gov.census.utilities.Driver;
import gov.census.utilities.Utils;

public class HomePageTest extends TestBase {
	HomePage homePage = new HomePage();
	Select select;

	// Home Page Test-1 "Verify Home Page Link" TC001
	@Test
	public void homePageLink() {
		String actual = Driver.getDriver().getCurrentUrl();
		String expected = "https://census.gov/";
		System.out.println(actual);
		assertTrue(actual.equals(expected), "url should be : https://www.census.gov/");
	}

	@Test
	// Home Page Test-2 "Verify Home Page Title"TC002
	public void homePageTitleTest() {
		String actual = Driver.getDriver().getTitle();
		String expected = "Census.gov";
		assertTrue(actual.equals(expected), "Title should be : Census.gov");
	}

	// Drop Menu Test-1 "Library Link. Drop&Down Functionality"TC003
	@Test
	public void libraryDropDownTest() {
		String actual = Driver.getDriver().getTitle();
		String expected = "Census.gov";
		assertEquals(actual, expected, "Title should be : Census.gov");
		Utils.clickJSE(homePage.libraryLink);
		List<String> actualList = new ArrayList<>();
		List<String> expectedList = Arrays.asList("Library Main","America Counts: Stories","Audio",
				"Photos","Publications","Videos","Infographics & Visualizations","Working Papers");
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        String script = "return arguments[0].text";
		for (WebElement el : homePage.libraryListPart1) {
			actualList.add(((String) jse.executeScript(script, el)).trim());
		}
		for (WebElement el : homePage.libraryListPart2) {
			actualList.add(((String) jse.executeScript(script, el)).trim());
		}
        System.out.println(actualList);
        assertTrue(expected.contains(actual));
	}

}
