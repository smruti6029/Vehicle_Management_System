package com.vechileManagementSystem.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VehicleBrand {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vehicle_id;
	
	
	private String vehicle_brand_name;
	
	private String gmail;
	
	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}


	@OneToMany(mappedBy = "vehicleBrand_id")
	private List<SubShowRoom> brandLocaton;


	public Integer getVehicle_id() {
		return vehicle_id;
	}


	public void setVehicle_id(Integer vehicle_id) {
		this.vehicle_id = vehicle_id;
	}


	public String getVehicle_brand_name() {
		return vehicle_brand_name;
	}


	public void setVehicle_brand_name(String vehicle_brand_name) {
		this.vehicle_brand_name = vehicle_brand_name;
	}


	


	public VehicleBrand(Integer vehicle_id, String vehicle_brand_name, String gmail
			) {
		super();
		this.vehicle_id = vehicle_id;
		this.vehicle_brand_name = vehicle_brand_name;
		this.gmail = gmail;
	
	}


	public VehicleBrand() {
		super();
	}
	
	
	

}
