package com.coffeefactory.coffeeshop.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.coffeefactory.coffeeshop.entities.Country;

public class CountryDAOTest {

	@Test
	public void testReadCountryList() throws SQLException {
		List<Country> coffeList = CountryDAO.readCountryList();
		assertNotNull("coffeeList must not be null", coffeList);
		assertNotNull("coffeeList must not be empty", !coffeList.isEmpty());
	}
	
	// The remaining part is not implemented yet - commented out so that maven does not complain
//
//	@Test
//	public void testReadCountry() throws SQLException {
//		int knownId = 1;
//		Country firstCountry = CountryDAO.readCountry(knownId);
//		assertNotNull("country must not be null", firstCountry);
//		assertEquals("country must have ID " + knownId, knownId, firstCountry.getId());
//		String knownName = "Noveo Zimlya";
//		assertEquals("country must have name " + knownName, knownName, firstCountry.getName());
//	}
//
//	@SuppressWarnings("deprecation") //we are not computing double numbers here so the exact comparison should work
//	@Test
//	public void testAddCountry() throws SQLException {
//		Country newCountry = createNewCountryObject();
//		Country coffeeAdded = CountryDAO.addCountry(newCountry);
//		assertNotNull("country must not be null", coffeeAdded);	
//		Country countryRead = CountryDAO.readCountry(coffeeAdded.getId());
//		assertEquals(countryRead.getName(), newCountry.getName());
//		assertEquals(countryRead.getLatitude(), newCountry.getLatitude());
//		assertEquals(countryRead.getLongitude(), newCountry.getLongitude());
//		assertEquals(countryRead.getZoom(), newCountry.getZoom());
//	}
//	
//	@SuppressWarnings("deprecation") //we are not computing double numbers here so the exact comparison should work
//	@Test
//	public void testUpdateCountry() throws SQLException {
//		Country newCountry = createNewCountryObject();
//		Country coffeeAdded = CountryDAO.addCountry(newCountry);
//		assertNotNull("coffeeAdded must not be null", coffeeAdded);
//			
//		Country coffeeUpdatedRead = CountryDAO.readCountry(coffeeAdded.getId());
//		assertEquals(coffeeUpdatedRead.getName(), coffeeAdded.getName());
//		assertEquals(coffeeUpdatedRead.getLatitude(), coffeeAdded.getLatitude());
//		assertEquals(coffeeUpdatedRead.getLongitude(), coffeeAdded.getLongitude());
//		assertEquals(coffeeUpdatedRead.getZoom(), coffeeAdded.getZoom());
//
//		//this is not part of the test, its just to clean up.
//		CountryDAO.deleteCountry(coffeeAdded.getId());
//	}
//
//	@Test
//	public void testDeleteCountry() throws SQLException {
//		Country nuevoCountry = createNewCountryObject();
//		Country coffeeAdded = CountryDAO.addCountry(nuevoCountry);
//		CountryDAO.deleteCountry(coffeeAdded.getId());
//		Country coffeeAddedDeletedRead = CountryDAO.readCountry(coffeeAdded.getId());
//		assertNull("coffeeAddedDeletedRead must be null", coffeeAddedDeletedRead);
//	}
//
//	private static Country createNewCountryObject() {
//		Country newCountry = new Country();
//		newCountry.setName("Noveo Zimlya");
//		newCountry.setLatitude(69.7012621);
//		newCountry.setLongitude(52.3030044);
//		newCountry.setZoom(8);
//
//		return newCountry;
//	}

}
