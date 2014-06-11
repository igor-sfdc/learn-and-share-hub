package coffeeshot.integration;

import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coffeeshop.integration.util.TestUtil;

public class CoffeeshopIntegrationErrorTest extends TestCase {
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
//==================================================================================================================================================

	/**
	 * Test Name error message
	 */
	public void testEditCoffeeNameError() {

		driver.get("http://localhost:8080/");

		TestUtil.navigateToEditFirstRecord(driver);

		// Now we are in Edit Coffee Page
		//NAME ================================================================================================================================             
		final By conditionName = By.id("name");
		WebElement nameInputElement = TestUtil.findElementWithWait(driver, conditionName);
		TestUtil.updateInputText(driver, nameInputElement, "ABC");
	
		//END, SAVE =============================================================================================================================       
		// Now it's time to save
		WebElement saveButtonElement = TestUtil.findElementWithWait(driver, By.className("save"));
		saveButtonElement.click();

		//for faulty name
		By condition = By.id("error-messages");
		String message = "Missing error message";
		String expected = "name: Country name must be between 4 and 32 letters";
		TestUtil.findAndAssertText(driver, condition, message, expected);		
	}

	/**
	 * Test Country error message
	 */
	public void testEditCoffeeCountryError() {		
		
		driver.get("http://localhost:8080/");
		
		TestUtil.navigateToEditFirstRecord(driver);
		
		// COUNTRY =============================================================================================================================
		final By conditionCountry = By.id("countryFrom");
		WebElement countryInputElement = TestUtil.findElementWithWait(driver, conditionCountry);
		TestUtil.updateSelection(driver, countryInputElement, "--select a country--");
		
		//END, SAVE =============================================================================================================================       
		// Now it's time to save
		WebElement saveButtonElement = TestUtil.findElementWithWait(driver, By.className("save"));
		saveButtonElement.click();
		
		//for faulty country
		By condition = By.id("error-messages");
		String message = "Missing error message";
		String expected = "countryFrom: Country must be selected";
		TestUtil.findAndAssertText(driver, condition, message, expected);
	}
}