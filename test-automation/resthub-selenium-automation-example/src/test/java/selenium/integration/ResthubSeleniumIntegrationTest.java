package selenium.integration;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ResthubSeleniumIntegrationTest {
	private final Logger slf4jLogger = LoggerFactory.getLogger(getClass());
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		slf4jLogger.info("Setting up");
		// Setup driver
		driver = new FirefoxDriver();
		slf4jLogger.info("Finished Setting up");
	}

	@After
	public void tearDown() throws Exception {
		slf4jLogger.info("Tearing down");
		// Give it some time finish download before shutting down driver
		Thread.sleep(300);
		// Quit driver
		driver.quit();
		slf4jLogger.info("Finished Tearing down");
	}
	
	/**
	 * Test RESThub message
	 */
	@Test
	public void testRESThubMessage() {
		String testPort = System.getProperty("jetty.integration.test.port", "9080");
		driver.get("http://localhost:" + testPort  + "/");

		slf4jLogger.info("Loaded index.html page");
		By conditionTemplate = By.tagName("h1");
		WebElement templateElement = driver.findElement(conditionTemplate);
		slf4jLogger.info("Located the element");
		assertEquals("The element did not match expected.", "RESThub Backbone Bootstrap starter template", templateElement.getText()); 
	}
}
