package com.vechileManagementSystem.DTO;

import com.vechileManagementSystem.enums.VehicleType;

public class ShowAvilabeDetalis {
	
	
	private String  brand_name;
	
	private String colour;
	
	private String showroom;
	
	private VehicleType Type;
	
	private String location;
	
	private String vehicle_name;
	
	
	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getShowroom() {
		return showroom;
	}

	public void setShowroom(String showroom) {
		this.showroom = showroom;
	}

	public VehicleType getType() {
		return Type;
	}

	public void setType(VehicleType type) {
		Type = type;
	}

	public ShowAvilabeDetalis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getVehicle_name() {
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	public ShowAvilabeDetalis(String brand_name, String colour, String showroom, VehicleType type, String location,
			String vehicle_name) {
		super();
		this.brand_name = brand_name;
		this.colour = colour;
		this.showroom = showroom;
		Type = type;
		this.location = location;
		this.vehicle_name = vehicle_name;
	}




	
	
	
	

}
