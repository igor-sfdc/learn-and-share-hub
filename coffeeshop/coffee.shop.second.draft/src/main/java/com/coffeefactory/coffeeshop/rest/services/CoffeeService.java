package com.coffeefactory.coffeeshop.rest.services;

import java.sql.SQLException;
import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.coffeefactory.coffeeshop.dao.CoffeeDAO;
import com.coffeefactory.coffeeshop.entities.Coffee;

/**
 * Restful service for coffee records
 */
@Path("/coffee")
public class CoffeeService {
	/**
	 * Responds to http GET looking for coffee id parameter and returns coffee 
	 * record in JSON. Example of the URL:
	 * http://localhost:8080/rest/coffee/1, 
	 * where 1 is the id.
	 * 
	 * @param id - coffee id
	 * @return Response
	 * @throws SQLException
	 */
	@GET
	@Path("/{param}")
	public Response getFetchCoffee(@PathParam("param") int id) throws SQLException {
		Coffee coffee = CoffeeDAO.readCoffee(id);
		if(coffee != null) {
			System.out.println("fetched coffee " + coffee);
			return Response.status(200).entity(coffee).build();
		} else {
			System.out.println("could not find coffee for id: " + id);
			return Response.status(404).entity(coffee).build();
		}
	}

	/**
	 * This is made to get the list of coffees listening on the following url: http://localhost:8080/rest/coffee
	 * @return
	 * @throws SQLException
	 */
	@GET
	public Response getFetchCoffeeList() throws SQLException {
		Collection<Coffee> coffeeList = CoffeeDAO.readCoffeeList();

		System.out.println("fetched coffee list of size: " + coffeeList.size());
		return Response.status(200).entity(coffeeList).build();
	} 	

	/**
	 * This function adds a new coffee.
	 * record in JSON. Example of the URL:
	 * http://localhost:8080/rest/coffee/
	 * @param coffee
	 * @return
	 * @throws SQLException
	 */
	@POST
	public Response postAddCoffee(Coffee coffee) throws SQLException {
		if (coffee.getId() != 0) {
			throw new IllegalArgumentException("When adding new entity ID must be 0 (" + coffee.getId() + ")");
		}
		System.out.println("about to add coffee " + coffee);
		Coffee coffeeAdded = CoffeeDAO.addCoffee(coffee);
		System.out.println("added coffee " + coffeeAdded);

		return Response.status(200).entity(coffeeAdded).build();
	}
	 /**
	 * This function  updates a new coffee.
	 * update in JSON. Example of the URL:
	 * http://localhost:8080/rest/coffee/
	 * @param coffee
	 * @return
	 * @throws SQLException
	 */
	@PUT
	@Path("/{param}")	// For some reason Backbone.js had ID at the end, so we had add this or otherwise the pattern would not match (405 "method not allowed" error)
	public Response putUpdateCoffee(Coffee coffee) throws SQLException {
		if (coffee.getId() <= 0) {
			throw new IllegalArgumentException("When updating an entity ID must be greater than 0 (" + coffee.getId() + ")");
		}
		CoffeeDAO.updateCoffee(coffee);
		System.out.println("updated coffee " + coffee);

		return Response.status(200).entity(coffee).build();
	}
	/**
	 * This function deletes the coffee by id.
	 * delete in JSON. Example of the URL:
	 * http://localhost:8080/rest/coffee/
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@DELETE
	@Path("/{param}")
	public Response deleteDestroyUser(@PathParam("param") int id) throws SQLException {
		Coffee coffeeToBeDeleted = CoffeeDAO.readCoffee(id);
		int rowsDeleted = CoffeeDAO.deleteCoffee(id);
		System.out.println("deleted coffee id: " + id + " and rows deleted: " + rowsDeleted);
		return Response.status(200).entity(coffeeToBeDeleted).build();
	}
}
