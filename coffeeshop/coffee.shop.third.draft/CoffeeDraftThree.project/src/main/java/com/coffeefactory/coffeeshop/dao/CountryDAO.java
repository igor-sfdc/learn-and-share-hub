package com.coffeefactory.coffeeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coffeefactory.coffeeshop.entities.Country;

/**
 * Country Data Access Object that embodies countries 
 *
 */
public class CountryDAO extends BaseDAO {
	public static List<Country> readCountryList() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionHelper.getConnection();
			// Statements allow to issue SQL queries to the database
			preparedStatement = connection.prepareStatement("SELECT * FROM Country");
			// Result set get the result of the SQL query
			resultSet = preparedStatement.executeQuery();
			return resultSetToCountryList(resultSet);
		} finally {
			close(resultSet, preparedStatement, connection);
		}
	}

	/**
	 * Converts resultSet to Country list
	 * 
	 * @param resultSet
	 * @return list of countries
	 * @throws SQLException
	 */
	private static List<Country> resultSetToCountryList(ResultSet resultSet) throws SQLException {
		List <Country> countryList = new ArrayList<Country>();
		//here we expect multiple rows so we loop to be able to fill it. 
		while (resultSet.next()) {
			Country countryItem = createCountryObjectFromDatabaseRecord(resultSet);
			countryList.add(countryItem);
		}
		return countryList;
	}
/**
 * this creates country object
 * @param resultSet
 * @return
 * @throws SQLException
 */
	private static Country createCountryObjectFromDatabaseRecord(ResultSet resultSet) throws SQLException {
		Country countryItem = new Country();
		countryItem.setId(resultSet.getInt("countryId"));
		countryItem.setName(resultSet.getString("name"));
		countryItem.setLatitude(resultSet.getInt("Latitude"));
		countryItem.setLongitude(resultSet.getInt("longitude"));
		countryItem.setZoom(resultSet.getInt("zoom"));

		return countryItem;
	}
/**
 * This function reads the country and throws an UnsupportedOperationException
 * @param knownId
 * @return
 */
	public static Country readCountry(int knownId) {
		throw new UnsupportedOperationException("This method is currently not implemented");
	}
/**
 * This function adds the country and throws an UnsupportedOperationException
 * @param newCountry
 * @return
 */
	public static Country addCountry(Country newCountry) {
		throw new UnsupportedOperationException("This method is currently not implemented");
	}
/**
 * This function deletes the country and throws an UnsupportedOperationException
 * @param id
 */
	public static void deleteCountry(int id) {
		throw new UnsupportedOperationException("This method is currently not implemented");	
	}
} 