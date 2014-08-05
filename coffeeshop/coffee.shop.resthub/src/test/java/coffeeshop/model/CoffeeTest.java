package coffeeshop.model;

import junit.framework.TestCase;

public class CoffeeTest extends TestCase {

	private coffeeshop.model.Coffee coffee;
	
	protected void setUp() throws Exception {
		coffee = new Coffee();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
//not sure how to test
//	public void testGetCountryFrom() {
//		fail("Not yet implemented");
//	}
//not sure how to test
//	public void testCoffee() {
//		fail("Not yet implemented");
//	}
//not sure how to test
//	public void testCoffeeString() {
//		fail("Not yet implemented");
//	}
//======================================
	public void testGetId() {
		Long coffeeId = coffee.getId();
		//Coffee id is a long, but we're using a cast to Long with an int id.
		assertNull(null, coffeeId);
	}

	public void testSetId() {
		coffee.setId((long) 10);
		Long coffeeId = coffee.getId();
		assertEquals(new Long(10), coffeeId);
	}
//======================================
	public void testGetName() {
		String coffeeName = coffee.getName();
		assertNull(null, coffeeName);
	}

	public void testSetName() {
		coffee.setName("Bolivian");
		String coffeeName = coffee.getName();
		assertEquals("Bolivian", coffeeName);
	}
//======================================
	public void testGetDescription() {
		String coffeeDescription = coffee.getDescription();
		assertNull(null, coffeeDescription);
	}

	public void testSetDescription() {
		coffee.setDescription("Description Test");
		String coffeeDescription = coffee.getDescription();
		assertEquals("Description Test", coffeeDescription);
	}
//======================================
	public void testGetRegion() {
		String coffeeRegion = coffee.getRegion();
		assertNull(null, coffeeRegion);
	}

	public void testSetRegion() {
		coffee.setRegion("Mountains");
		String coffeeRegion = coffee.getRegion();
		assertEquals("Mountains", coffeeRegion);
	}
//======================================
	public void testGetProcessed() {
		String coffeeProcessed = coffee.getProcessed();
		assertNull(null, coffeeProcessed);
	}

	public void testSetProcessed() {
		coffee.setProcessed("Ground");
		String coffeeProcessed = coffee.getProcessed();
		assertEquals("Ground", coffeeProcessed);
	}
//======================================
	public void testGetWeight() {
		int coffeeWeight = coffee.getWeight();
		//because weight is zero, instead of assertingNull, we assertEquals to 0
		assertEquals(0, coffeeWeight);
	}

	public void testSetWeight() {
		coffee.setWeight(1);
		int coffeeWeight = coffee.getWeight();
		assertEquals(1, coffeeWeight);
	}
//======================================
//	public void testSetCountryFrom() {
//		fail("Not yet implemented");
//	}
//
//	public void testToString() {
//		fail("Not yet implemented");
//	}
//======================================
}
