package com.coffeefactory.coffeeshop.rest.services;

import java.sql.SQLException;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.coffeefactory.coffeeshop.dao.CountryDAO;
import com.coffeefactory.coffeeshop.entities.Country;

/**
 * Restful service for country records
 */
@Path("/country")
public class CountryService {
	/**
	 * this is made to get the list of countries listening on the following url: http://localhost:8080/rest/country
	 * @return
	 * @throws SQLException
	 */
	@GET
	public Response getFetchCountryList() throws SQLException {
		Collection<Country> countryList = CountryDAO.readCountryList();

		System.out.println("fetched country list of size: " + countryList.size());
		return Response.status(200).entity(countryList).build();
	} 	
}
