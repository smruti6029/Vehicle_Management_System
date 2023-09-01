package com.vechileManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vechileManagementSystem.DAO.VehicleBrandDAO;
import com.vechileManagementSystem.Entity.VehicleBrand;

@Service
public class VehicleBrandService {
	
	
	@Autowired
	private VehicleBrandDAO vehiclebrand;
	
	public Integer saveBrand(VehicleBrand brand)
	{
		Integer saveBrandVehicle = vehiclebrand.saveBrandVehicle(brand);
		return saveBrandVehicle;
	}
	
	public List<VehicleBrand> getAllBrands()
	{
		List<VehicleBrand> allbrands = vehiclebrand.getAllbrands();
		return allbrands;
	}

}
