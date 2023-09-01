package com.vechileManagementSystem.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vechileManagementSystem.enums.VehicleType;

@Entity
@Table(name = "assignvehicle")
public class AssignVehicleForSubbranch {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vehile_id;
	
	private String vechile_name;

	private String colour;

	private VehicleType vehicle_type;

	private String vehicle_chechis_number;

	
	private String vehicle_number;

	private Boolean avilable = null;

	private String assignDate;

	private String soldDate = null;

	@ManyToOne
	private SubShowRoom brandLocaton;
	
	@ManyToOne
	private Customer customer=null;

	public String getVechile_name() {
		return vechile_name;
	}

	public void setVechile_name(String vechile_name) {
		this.vechile_name = vechile_name;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
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

	public Boolean getAvilable() {
		return avilable;
	}

	public void setAvilable(Boolean avilable) {
		this.avilable = avilable;
	}

	public SubShowRoom getBrandLocaton() {
		return brandLocaton;
	}

	public void setBrandLocaton(SubShowRoom brandLocaton) {
		this.brandLocaton = brandLocaton;
	}

	public String getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(String assignDate) {
		this.assignDate = assignDate;
	}

	public AssignVehicleForSubbranch(String vechile_name, String vehicle_number, String colour, VehicleType vehicle_type,
			String vehicle_chechis_number, Boolean avilable, String assignDate, SubShowRoom brandLocaton) {
		super();
		this.vechile_name = vechile_name;
		this.vehicle_number = vehicle_number;
		this.colour = colour;
		this.vehicle_type = vehicle_type;
		this.vehicle_chechis_number = vehicle_chechis_number;
		this.avilable = avilable;
		this.assignDate = assignDate;
		this.brandLocaton = brandLocaton;
	}

	public AssignVehicleForSubbranch() {
		super();

	}

	public String getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(String soldDate) {
		this.soldDate = soldDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
}
