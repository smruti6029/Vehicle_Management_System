package com.vechileManagementSystem.DTO;

public class CustomerDto {

	private String name;

	private String gmail;

	private String address;
	
	private Integer vehicle_id;
	
	private String dateof_bookVehicle;
	
	
	
	public String getDateof_bookVehicle() {
		return dateof_bookVehicle;
	}

	public void setDateof_bookVehicle(String dateof_bookVehicle) {
		this.dateof_bookVehicle = dateof_bookVehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(Integer vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(String name, String gmail, String address, Integer vehicle_id) {
		super();
		this.name = name;
		this.gmail = gmail;
		this.address = address;
		this.vehicle_id = vehicle_id;
	}

	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", gmail=" + gmail + ", address=" + address + ", vehicle_id=" + vehicle_id
				+ "]";
	}
	
	
	
	
	
	

}
