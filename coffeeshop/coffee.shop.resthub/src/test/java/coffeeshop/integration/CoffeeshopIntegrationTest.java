package coffeeshop.integration;

import java.util.Random;

import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coffeeshop.integration.util.TestUtil;

public class CoffeeshopIntegrationTest extends TestCase {
    private final Logger slf4jLogger = LoggerFactory.getLogger(getClass());
	private WebDriver driver;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		slf4jLogger.info("Setting up");
		// Setup driver
		driver = new FirefoxDriver();
		slf4jLogger.info("Finished Setting up");
	}

	@Override
	protected void tearDown() throws Exception {
		slf4jLogger.info("Tearing down");
		// Quit driver
		driver.quit();
		super.tearDown();
		slf4jLogger.info("Finished Tearing down");
	}

	public void testEditCoffee() {

		driver.get("http://localhost:8080/");

		TestUtil.navigateToEditFirstRecord(driver);

		// Now we are in Edit Coffee Page
		//NAME ================================================================================================================================             
		final By conditionName = By.id("name");
		WebElement nameInputElement = TestUtil.findElementWithWait(driver, conditionName);
		String nameEditValue = "ABCDE" + System.currentTimeMillis();
		TestUtil.updateInputText(driver, nameInputElement, nameEditValue);

		//DESCRIPTION =========================================================================================================================            
		final By conditionDescription = By.id("description");
		WebElement descriptionInputElement = TestUtil.findElementWithWait(driver, conditionDescription);
		String descriptionEditValue = "DEF" + System.currentTimeMillis();
		TestUtil.updateInputText(driver, descriptionInputElement, descriptionEditValue);

		//REGION ==============================================================================================================================
		final By conditionRegion = By.id("region");
		WebElement regionInputElement = TestUtil.findElementWithWait(driver, conditionRegion);
		String regionEditValue = "GHI" + System.currentTimeMillis();
		TestUtil.updateInputText(driver, regionInputElement, regionEditValue);

		//COUNTRY ============================================================================================================================        
			WebElement countryFromElement = TestUtil.findElementWithWait(driver, By.id("countryFrom"));	
			TestUtil.updateSelection(driver, countryFromElement, "Peru");

		//PROCESSED ============================================================================================================================
		final By conditionProcessed = By.id("processed");
		WebElement processedInputElement = TestUtil.findElementWithWait(driver, conditionProcessed);        
		String processedEditValue = "WXYZ" + System.currentTimeMillis();
		TestUtil.updateInputText(driver, processedInputElement, processedEditValue);

		//WEIGHT ================================================================================================================================
		final By conditionWeight = By.id("weight");
		WebElement weightInputElement = TestUtil.findElementWithWait(driver, conditionWeight);        
		int max = 10;
		int min = 1;
		String weightEditValue = "" + new Random().nextInt((max  - min) + 1) + min;
		TestUtil.updateInputText(driver, weightInputElement, weightEditValue);

		//END, SAVE =============================================================================================================================       
		// Now it's time to save
		WebElement saveButtonElement = TestUtil.findElementWithWait(driver, By.className("save"));
		saveButtonElement.click();

		By condition = By.tagName("h3");
		String message = "Save was not successful: page did not match expected";
		String expected = "Welcome to the Coffee Selection list";
		TestUtil.findAndAssertText(driver, condition, message, expected);
		
		// Going back to do verification
		TestUtil.navigateToEditFirstRecord(driver);
		String verificationMessage = "The value did not match saved value";
		// Verify that name was properly updated
		TestUtil.findAndAssertInputText(driver, conditionName, verificationMessage, nameEditValue);
		
		// Verify that description was properly updated
		TestUtil.findAndAssertInputText(driver, conditionDescription, verificationMessage, descriptionEditValue);
		
		// Verify that region was properly updated
		TestUtil.findAndAssertInputText(driver, conditionRegion, verificationMessage, regionEditValue);
		
		// Verify that processed was properly updated
		TestUtil.findAndAssertInputText(driver, conditionProcessed, verificationMessage, processedEditValue);
		
		// Verify that weight was properly updated
		TestUtil.findAndAssertInputText(driver, conditionWeight, verificationMessage, weightEditValue);
	}
}