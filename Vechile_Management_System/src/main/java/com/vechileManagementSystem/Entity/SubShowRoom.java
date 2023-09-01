package com.vechileManagementSystem.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SubShowRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subbrand_id;
	
	private String subbrand_name;
	
	private String location;
	
	
	@ManyToOne
	@JoinColumn(name = "Brand_id")
	private VehicleBrand vehicleBrand_id;
	
	
	
	public VehicleBrand getVehicleBrand_id() {
		return vehicleBrand_id;
	}

	public void setVehicleBrand_id(VehicleBrand vehicleBrand_id) {
		this.vehicleBrand_id = vehicleBrand_id;
	}

	@OneToMany(mappedBy = "brandLocaton")
	private List<AssignVehicleForSubbranch> assignVehicleForSubbranch;

	public Integer getSubbrand_id() {
		return subbrand_id;
	}

	public void setSubbrand_id(Integer subbrand_id) {
		this.subbrand_id = subbrand_id;
	}

	public String getSubbrand_name() {
		return subbrand_name;
	}

	public void setSubbrand_name(String subbrand_name) {
		this.subbrand_name = subbrand_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public SubShowRoom( String subbrand_name, String location,
			VehicleBrand vehicleBrand_id) {
		super();
	
		this.subbrand_name = subbrand_name;
		this.location = location;
		this.vehicleBrand_id = vehicleBrand_id;
	}

	public SubShowRoom() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	

	
	
	
	
	
	
	


	
	
	

}
