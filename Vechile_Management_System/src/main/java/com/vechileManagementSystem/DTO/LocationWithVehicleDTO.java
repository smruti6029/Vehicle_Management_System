package com.vechileManagementSystem.DTO;

import com.vechileManagementSystem.enums.VehicleType;

public class LocationWithVehicleDTO {
	
	
	private String location;
	
	private String showroom;
	
	private String vehicle_model;
	
	private String brand;
	
	private VehicleType vehicle_type;
	
	private String vehicle_colour;
	
			
	
	
	public String getVehicle_colour() {
		return vehicle_colour;
	}

	public void setVehicle_colour(String vehicle_colour) {
		this.vehicle_colour = vehicle_colour;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getShowroom() {
		return showroom;
	}

	public void setShowroom(String showroom) {
		this.showroom = showroom;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public VehicleType getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(VehicleType vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	
	



	public String getVehicle_model() {
		return vehicle_model;
	}

	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}

	public LocationWithVehicleDTO(String location, String showroom, String brand, VehicleType vehicle_type) {
		super();
		this.location = location;
		this.showroom = showroom;
		this.brand = brand;
		this.vehicle_type = vehicle_type;
	}

	public LocationWithVehicleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
