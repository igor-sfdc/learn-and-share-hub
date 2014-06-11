package coffeeshop.integration.util;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;

/**
 * A collection of reusable test utilities
 *
 */
public class TestUtil {
    private final static Logger slf4jLogger = LoggerFactory.getLogger(TestUtil.class);
    
    /**
     * Navigates to give Tab and verifies tab heading
     * 
     * @param driver
     * @param tabText
     * @param headingText
     */
	public static void navigateToTab(WebDriver driver, String tabText, String headingText) {
		WebElement tabLinkElement = findElementWithWait(driver, By.linkText(tabText));
		slf4jLogger.info("found link " + tabText + " " + tabLinkElement);				
		tabLinkElement.click();	
		WebElement pageSubHeadingElement = findElementWithWait(driver, By.tagName("h3"));
		slf4jLogger.info("found element subHeading " + pageSubHeadingElement);
		assertEquals("Tab subheader did not match", headingText, pageSubHeadingElement.getText());
	}

	/**
	 * Updates text input field
	 * 
	 * @param driver
	 * @param inputTextWebElement
	 * @param newText
	 */
	public static void updateInputText(WebDriver driver,
			WebElement inputTextWebElement, String newText) {
		inputTextWebElement.clear();
		Actions descriptionBuilder = new Actions(driver);
		Actions seriesOfActionsDescription = descriptionBuilder.moveToElement(inputTextWebElement).click().sendKeys(inputTextWebElement, newText);
		seriesOfActionsDescription.perform();
	}

	/**
	 * Updates selection choice
	 * 
	 * @param driver
	 * @param inputSelectionElement
	 * @param visibleText
	 */
	public static void updateSelection(WebDriver driver,
			WebElement inputSelectionElement, String visibleText) {
		Select countryFromElementSelect = new Select(inputSelectionElement);
		countryFromElementSelect.selectByVisibleText(visibleText);
	}

	/**
	 * Finds element and if the element is not there waits tries again a few times
	 * 
	 * @param driver
	 * @param condition
	 * @return
	 */
	public static WebElement findElementWithWait(WebDriver driver, final By condition) {
		// Waiting 5 seconds for an element to be present on the page, checking
		// for its presence once every 100 milliseconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(5, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement nameInputElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(condition);
			}
		});
		return nameInputElement;
	}

	/**
	 * Use this method to verify text in element if you get StaleElementReferenceException b/c of being in transition b/w pages
	 * 
	 * @param driver 
	 * @param condition
	 * @param message
	 * @param expected
	 */
	public static void findAndAssertText(WebDriver driver, By condition, String message, String expected) {
		int attemptNum = 0;
		int maxNumAttempts = 3;
		while (attemptNum < maxNumAttempts) {
			try {
				WebElement elementToAssert = TestUtil.findElementWithWait(driver, condition);
				assertEquals(message, expected, elementToAssert.getText());
				return;
			} catch (StaleElementReferenceException e) {
				if (attemptNum < maxNumAttempts) {
					attemptNum++;
				} else {
					throw e;
				}
			}
		}
	}

	/**
	 * Use this method to verify value of input if you get StaleElementReferenceException b/c of being in transition b/w pages
	 * 
	 * @param driver 
	 * @param condition
	 * @param message
	 * @param expected
	 */
	public static void findAndAssertInputText(WebDriver driver, By condition, String message, String expected) {
		int attemptNum = 0;
		int maxNumAttempts = 3;
		while (attemptNum < maxNumAttempts) {
			try {
				WebElement elementToAssert = TestUtil.findElementWithWait(driver, condition);
				assertEquals(message, expected, elementToAssert.getAttribute("value"));
				return;
			} catch (StaleElementReferenceException e) {
				if (attemptNum < maxNumAttempts) {
					attemptNum++;
				} else {
					throw e;
				}
			}
		}
	}

	/**
	 * A helper method to navigate to the first Coffee record edit page
	 * 
	 * @param driver
	 */
	public static void navigateToEditFirstRecord(WebDriver driver) {
		TestUtil.navigateToTab(driver, "Coffees", "Welcome to the Coffee Selection list");
		//TODO: finding elements needs to be done with findElementsWithWait (not critical at this point)
		List<WebElement> editLinkElements = driver.findElements(By.linkText("Edit")); 
		assertTrue("editLinkElements is empty", !editLinkElements.isEmpty());
		// This is how you get the first element of the list
		WebElement theFirstElement = editLinkElements.get(0);
		theFirstElement.click();
	}
}
