package com.coffeefactory.coffeeshop.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coffeefactory.coffeeshop.entities.Coffee;

public class CoffeeDAO extends BaseDAO {
	public static List<Coffee> readCoffeeList() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionHelper.getConnection();
			// Statements allow to issue SQL queries to the database
			preparedStatement = connection.prepareStatement("SELECT * FROM Coffee");
			// Result set get the result of the SQL query
			resultSet = preparedStatement.executeQuery();
			return resultSetToCoffeeList(resultSet);
		} finally {
			close(resultSet, preparedStatement, connection);
		}
	}

	public static Coffee readCoffee(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionHelper.getConnection();
			// Statements allow to issue SQL queries to the database
			preparedStatement = connection.prepareStatement("SELECT * FROM Coffee WHERE coffeeId=?");
			preparedStatement.setInt(1, id);
			// Result set get the result of the SQL query
			//this line says to the SQL:
			//Select coffeeId FROM Coffee WHERE coffeeID = (Id in param above)
			resultSet = preparedStatement.executeQuery();
			return resultSetToCoffee(resultSet);
		} finally {
			close(resultSet, preparedStatement, connection);
		}

	}


	public static Coffee addCoffee(Coffee coffee) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionHelper.getConnection();

			preparedStatement = connection.prepareStatement("INSERT INTO coffee (name, description, region, countryFromId, processed, weight) VALUES (?, ?, ?, ?, ?, ?)",
					new String[] { "coffeeId" });
			preparedStatement.setString(1, coffee.getName());
			preparedStatement.setString(2, coffee.getDescription());
			preparedStatement.setString(3, coffee.getRegion());
			preparedStatement.setInt(4, coffee.getCountryFromId());
			preparedStatement.setString(5, coffee.getProcessed());
			preparedStatement.setInt(6, coffee.getWeight());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this value must be returned to the client.
			int id = rs.getInt(1);
			coffee.setId(id);
			return coffee;
		} finally {
			close(null, preparedStatement, connection);
		}
	}

	public static Coffee updateCoffee(Coffee coffee) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionHelper.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE coffee SET name=?, description=?, region=?, countryFromId=?, processed=?, weight=? WHERE coffeeId=?");					
			preparedStatement.setString(1, coffee.getName());
			preparedStatement.setString(2, coffee.getDescription());
			preparedStatement.setString(3, coffee.getRegion());
			preparedStatement.setInt(4, coffee.getCountryFromId());
			preparedStatement.setString(5, coffee.getProcessed());
			preparedStatement.setInt(6, coffee.getWeight());
			preparedStatement.setInt(7, coffee.getId());
			preparedStatement.executeUpdate();
			return coffee;
		} finally {
			close(null, preparedStatement, connection);
		}
	}
	
	public static int deleteCoffee(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionHelper.getConnection();
			// Statements allow to issue SQL queries to the database
			preparedStatement = connection.prepareStatement("DELETE FROM Coffee WHERE coffeeId=?");
			preparedStatement.setInt(1, id);
			// Result set get the result of the SQL query
			//this line says to the SQL:
			//Select coffeeId FROM Coffee WHERE coffeeID = (Id in param above)
			return preparedStatement.executeUpdate();

		} finally {
			close(null, preparedStatement, connection);
		}
	}

	private static Coffee resultSetToCoffee(ResultSet resultSet) throws SQLException {
		Coffee coffeeItem = null;
		//at best we only return 0 or 1 coffee
		if (resultSet.next()) {
			//initialize coffeeItem and return it
			coffeeItem = createCoffeeObjectFromDatabaseRecord(resultSet);
		}

		return coffeeItem;
	}

	private static List<Coffee> resultSetToCoffeeList(ResultSet resultSet) throws SQLException {
		List <Coffee> coffeeList = new ArrayList<Coffee>(); 
		while (resultSet.next()) {
			Coffee coffeeItem = createCoffeeObjectFromDatabaseRecord(resultSet);
			coffeeList.add(coffeeItem);
		}
		return coffeeList;
	}

	private static Coffee createCoffeeObjectFromDatabaseRecord(ResultSet resultSet) throws SQLException {
		Coffee coffeeItem = new Coffee();
		coffeeItem.setId(resultSet.getInt("coffeeId"));
		coffeeItem.setName(resultSet.getString("name"));
		coffeeItem.setDescription(resultSet.getString("description"));
		coffeeItem.setRegion(resultSet.getString("region"));
		coffeeItem.setCountryFromId(resultSet.getInt("countryFromId"));
		coffeeItem.setProcessed(resultSet.getString("processed"));
		coffeeItem.setWeight(resultSet.getInt("weight"));
		return coffeeItem;
	}

} 