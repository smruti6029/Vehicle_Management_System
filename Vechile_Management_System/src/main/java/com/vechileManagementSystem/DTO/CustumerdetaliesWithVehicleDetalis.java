package com.vechileManagementSystem.DTO;

import com.vechileManagementSystem.enums.VehicleType;

public class CustumerdetaliesWithVehicleDetalis 
{
	
	
	
	private String customer_name;
	
	private String brand;
	
	private String showroom;
	
	private String location;
	
	private String colour;
	
	private String vehicle_model;
	
	private String chechis_number;
	
	private VehicleType vehicle_type;
	
	private String vehicle_enigne_number;
	
	private String vehicle_number;
	
	private String issue_date;
	
	private String Address;

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getShowroom() {
		return showroom;
	}

	public void setShowroom(String showroom) {
		this.showroom = showroom;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getVehicle_model() {
		return vehicle_model;
	}

	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}

	public String getChechis_number() {
		return chechis_number;
	}

	public void setChechis_number(String chechis_number) {
		this.chechis_number = chechis_number;
	}




	public void setVehicle_enigne_number(String vehicle_enigne_number) {
		this.vehicle_enigne_number = vehicle_enigne_number;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	
	
	
	public String getVehicle_enigne_number() {
		return vehicle_enigne_number;
	}

	public void setVehicle_type(VehicleType vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public CustumerdetaliesWithVehicleDetalis(String customer_name, String brand, String showroom, String location,
			String colour, String vehicle_model, String chechis_number, VehicleType vehicle_type,
			String vehicle_enigne_number, String vehicle_number, String issue_date, String address) {
		super();
		this.customer_name = customer_name;
		this.brand = brand;
		this.showroom = showroom;
		this.location = location;
		this.colour = colour;
		this.vehicle_model = vehicle_model;
		this.chechis_number = chechis_number;
		this.vehicle_type = vehicle_type;
		this.vehicle_enigne_number = vehicle_enigne_number;
		this.vehicle_number = vehicle_number;
		this.issue_date = issue_date;
		Address = address;
	}

	public CustumerdetaliesWithVehicleDetalis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	

}
