package com.coffeefactory.coffeeshop.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.coffeefactory.coffeeshop.entities.Coffee;

public class CoffeeDAOTest {

	@Test
	public void testReadCoffeeList() throws SQLException {
		List<Coffee> coffeList = CoffeeDAO.readCoffeeList();
		assertNotNull("coffeeList must not be null", coffeList);
		assertNotNull("coffeeList must not be empty", !coffeList.isEmpty());
	}

	@Test
	public void testReadCoffee() throws SQLException {
		int knownId = 1;
		Coffee firstCoffee = CoffeeDAO.readCoffee(knownId);
		assertNotNull("coffee must not be null", firstCoffee);
		assertEquals("coffee must have ID " + knownId, knownId, firstCoffee.getId());
		String knownName = "Morrocan";
		assertEquals("coffee must have name " + knownName, knownName, firstCoffee.getName());
	}

	@Test
	public void testAddCoffee() throws SQLException {
		Coffee newCoffee = createNewCoffeeObject();
		Coffee coffeeAdded = CoffeeDAO.addCoffee(newCoffee);
		assertNotNull("coffeeAdded must not be null", coffeeAdded);	
		Coffee coffeeAddedRead = CoffeeDAO.readCoffee(coffeeAdded.getId());
		assertEquals(coffeeAddedRead.getName(), newCoffee.getName());
		assertEquals(coffeeAddedRead.getDescription(), newCoffee.getDescription());
		assertEquals(coffeeAddedRead.getRegion(), newCoffee.getRegion());
		assertEquals(coffeeAddedRead.getCountryFromId(), newCoffee.getCountryFromId());
		assertEquals(coffeeAddedRead.getProcessed(), newCoffee.getProcessed());
		assertEquals(coffeeAddedRead.getWeight(), newCoffee.getWeight());
		CoffeeDAO.deleteCoffee(coffeeAdded.getId());
	}
	
	@Test
	public void testUpdateCoffee() throws SQLException {
		Coffee newCoffee = createNewCoffeeObject();
		Coffee coffeeAdded = CoffeeDAO.addCoffee(newCoffee);
		assertNotNull("coffeeAdded must not be null", coffeeAdded);
		// Need to update the coffee Java object first so that we can check if DB update works
		coffeeAdded.setName(coffeeAdded.getName() + 1);
		coffeeAdded.setDescription(coffeeAdded.getDescription() + 1);
		coffeeAdded.setRegion(coffeeAdded.getRegion() + 1);
		coffeeAdded.setCountryFromId(coffeeAdded.getCountryFromId() + 1);
		coffeeAdded.setProcessed(coffeeAdded.getProcessed() + 1);
		coffeeAdded.setWeight(coffeeAdded.getWeight() + 1);
		CoffeeDAO.updateCoffee(coffeeAdded);				
		Coffee coffeeUpdatedRead = CoffeeDAO.readCoffee(coffeeAdded.getId());
		assertEquals(coffeeUpdatedRead.getName(), coffeeAdded.getName());
		assertEquals(coffeeUpdatedRead.getDescription(), coffeeAdded.getDescription());
		assertEquals(coffeeUpdatedRead.getRegion(), coffeeAdded.getRegion());
		assertEquals(coffeeUpdatedRead.getCountryFromId(), coffeeAdded.getCountryFromId());
		assertEquals(coffeeUpdatedRead.getProcessed(), coffeeAdded.getProcessed());
		assertEquals(coffeeUpdatedRead.getWeight(), coffeeAdded.getWeight());
		//this is not part of the test, its just to clean up.
		CoffeeDAO.deleteCoffee(coffeeAdded.getId());
	}

	@Test
	public void testDeleteCoffee() throws SQLException {
		Coffee nuevoCoffee = createNewCoffeeObject();
		Coffee coffeeAdded = CoffeeDAO.addCoffee(nuevoCoffee);
		CoffeeDAO.deleteCoffee(coffeeAdded.getId());
		Coffee coffeeAddedDeletedRead = CoffeeDAO.readCoffee(coffeeAdded.getId());
		assertNull("coffeeAddedDeletedRead must be null", coffeeAddedDeletedRead);
	}

	private static Coffee createNewCoffeeObject() {
		Coffee newCoffee = new Coffee();
		newCoffee.setName("Random");
		newCoffee.setDescription("Exceptionally dark");
		newCoffee.setRegion("Grove Lane");
		newCoffee.setCountryFromId(1);
		newCoffee.setProcessed("roasted");
		newCoffee.setWeight(1);
		return newCoffee;
	}

}
