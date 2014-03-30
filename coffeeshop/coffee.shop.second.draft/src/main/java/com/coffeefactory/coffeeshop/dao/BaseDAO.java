package com.coffeefactory.coffeeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {

	protected static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection)
			throws SQLException {

		if (resultSet != null) {
			resultSet.close();
		}

		if (preparedStatement != null) {
			preparedStatement.close();
		}

		if (connection != null) {
			connection.close();
		}
	}

}
