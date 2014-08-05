package coffeeshop.model;

import junit.framework.TestCase;

public class CountryTest extends TestCase {
	private coffeeshop.model.Country country;

	protected void setUp() throws Exception {
		country = new Country();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

//	public void testCountryString() {
//		fail("Not yet implemented");
//	}
//
//	public void testCountry() {
//		fail("Not yet implemented");
//	}
//====================================
	public void testSetId() {
		country.getId();
		Long countryID = country.getId();
		assertEquals(null, countryID);
	}
	
	public void testGetId() {
		Long countryID = country.getId();
		assertEquals(null, countryID);
	}

	//====================================
	//Due to float being a large number with a decimal point, we need a margin of error called delta.
	//Delta is the third parameter
	public void testSetLatitude() {
		country.setLatitude(0.01010);
		double latitude = country.getLatitude();
		assertEquals(0.01010, latitude, 0.001);
	}
	
	public void testGetLatitude() {
		double latitude = country.getLatitude();
		assertEquals(0.0, latitude, 0.001);
	}
	//====================================
	public void testSetLongitude() {
		country.setLongitude(0.01010);
		float longitude = country.getLongitude();
		assertEquals(0.01010, longitude, 0.001);
	}
	
	public void testGetLongitude() {
		float longitude = country.getLongitude();
		assertEquals(0.0, longitude, 0.001);
	}
	//====================================
	public void testSetZoom() {
		country.setZoom(0);
		int zoom = country.getZoom();
		assertEquals(0, zoom);
	}
	
	public void testGetZoom() {
		int zoom = country.getZoom();
		assertEquals(0, zoom);
	}
	//====================================
	public void testSetName() {
		country.setName("Bolivia");
		String countryName = country.getName();
		assertEquals("Bolivia", countryName);
	}
	
	public void testGetName() {
		String countryName = country.getName();
		assertNull(null, countryName);
	}
	//====================================	
//	public void testToString() {
//		fail("Not yet implemented");
//	}

}
