package com.vechileManagementSystem.DTO;

public class ShowRoomDTO {

	private String showroom_location;

	private String sub_brandname;

	private String brand;

	public String getShowroom_location() {
		return showroom_location;
	}

	public void setShowroom_location(String showroom_location) {
		this.showroom_location = showroom_location;
	}

	public String getSub_brandname() {
		return sub_brandname;
	}

	public void setSub_brandname(String sub_brandname) {
		this.sub_brandname = sub_brandname;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public ShowRoomDTO(String showroom_location, String sub_brandname, String brand) {
		super();
		this.showroom_location = showroom_location;
		this.sub_brandname = sub_brandname;
		this.brand = brand;
	}

	public ShowRoomDTO() {
		super();

	}

}
