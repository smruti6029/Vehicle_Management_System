package com.vechileManagementSystem.DTO;

import com.vechileManagementSystem.Entity.SubShowRoom;
import com.vechileManagementSystem.enums.VehicleType;


public class AssignVehicleShowroomDto

{

	private String vechile_name;

	private String colour;

	private VehicleType vehicle_type;

	private String vehicle_chechis_number;


	private SubShowRoom brandLocaton;

	public String getVechile_name() {
		return vechile_name;
	}

	public void setVechile_name(String vechile_name) {
		this.vechile_name = vechile_name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public VehicleType getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(VehicleType vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getVehicle_chechis_number() {
		return vehicle_chechis_number;
	}

	public void setVehicle_chechis_number(String vehicle_chechis_number) {
		this.vehicle_chechis_number = vehicle_chechis_number;
	}

	public SubShowRoom getBrandLocaton() {
		return brandLocaton;
	}

	public void setBrandLocaton(SubShowRoom brandLocaton) {
		this.brandLocaton = brandLocaton;
	}

	public AssignVehicleShowroomDto(String vechile_name, String colour, VehicleType vehicle_type,
			String vehicle_chechis_number, SubShowRoom brandLocaton) {
		super();
		this.vechile_name = vechile_name;
		this.colour = colour;
		this.vehicle_type = vehicle_type;
		this.vehicle_chechis_number = vehicle_chechis_number;
		this.brandLocaton = brandLocaton;
	}

	public AssignVehicleShowroomDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AssignVehicleShowroomDto [vechile_name=" + vechile_name + ", colour=" + colour + ", vehicle_type="
				+ vehicle_type + ", vehicle_chechis_number=" + vehicle_chechis_number + ", brandLocaton=" + brandLocaton
				+ "]";
	}


	
	
	

}
