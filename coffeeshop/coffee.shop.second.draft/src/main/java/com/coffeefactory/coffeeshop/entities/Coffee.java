package com.coffeefactory.coffeeshop.entities;

/**
 * This class contains the attributes of coffee
 *
 */

public class Coffee {
	private int id;
	private String name;
	private String description;
	private String region;
	private int countryFromId;
	private String processed;
	private int weight;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getCountryFromId() {
		return countryFromId;
	}

	public void setCountryFromId(int countryFromId) {
		this.countryFromId = countryFromId;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Coffee with " +
				"id: " + id + ", " + 
				"name: " + name + ", " +
				"description: " + description + ", " +
				"region: " + region +  ", " +
				"country: " + countryFromId +  ", " +
				"processed: " + processed +  ", " +
				"weight: " + weight;
	}
}
