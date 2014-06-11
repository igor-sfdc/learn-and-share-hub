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


public class SeleniumHelloIntegrationTest {
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
		// Quit driver
		driver.quit();
		slf4jLogger.info("Finished Tearing down");
	}
	
	/**
	 * Test Hello message
	 */
	@Test
	public void testHello() {

		driver.get("http://localhost:8080/index.html");

		slf4jLogger.info("Loaded index.html page");
		final By conditionHello = By.id("hello");
		WebElement helloElement = driver.findElement(conditionHello);
		slf4jLogger.info("Located the element");
		assertEquals("Hello element did not match expected.", "Hello World", helloElement.getText()); 
	}
}
