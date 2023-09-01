package com.vechileManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vechileManagementSystem.DAO.VehicleAssignShowroomDao;
import com.vechileManagementSystem.DTO.LocationWithVehicleDTO;
import com.vechileManagementSystem.Entity.AssignVehicleForSubbranch;
import com.vechileManagementSystem.enums.VehicleType;

@Service
public class VehicleLocationService {

	LocationWithVehicleDTO dto;

	@Autowired
	VehicleAssignShowroomDao vehicleDao;

	public List<LocationWithVehicleDTO> getVehicle(Integer brand_id, Integer location_id, VehicleType vehicle_type) {
		
		
		List<LocationWithVehicleDTO> listVehicle = new ArrayList<>();
		if(location_id == null && brand_id == null && vehicle_type == null)
		{
			List<AssignVehicleForSubbranch> avilableAll = vehicleDao.getAvilableAll();
			for(AssignVehicleForSubbranch add:avilableAll)
			{
				if(add.getAvilable())
				{
					LocationWithVehicleDTO convertToDto = convertToDto(add);
					listVehicle.add(convertToDto);
				}
			}
			
			
			return listVehicle;
			
		}
		if(location_id == null && brand_id != null && vehicle_type == null)
		{
			List<AssignVehicleForSubbranch> avilableAll = vehicleDao.getAvilableAll();
			for(AssignVehicleForSubbranch add:avilableAll)
			{
				if(add.getBrandLocaton().getVehicleBrand_id().getVehicle_id()==brand_id)
				{
				if(add.getAvilable())
				{
					LocationWithVehicleDTO convertToDto = convertToDto(add);
					listVehicle.add(convertToDto);
				}
				}
			}
			
			
			return listVehicle;
			
		}
		
		
		if(location_id == null && brand_id == null && vehicle_type != null)
		{
			List<AssignVehicleForSubbranch> avilableAll = vehicleDao.getAvilableAll();
			for(AssignVehicleForSubbranch add:avilableAll)
			{
				if(add.getVehicle_type()==vehicle_type)
				{
				if(add.getAvilable())
				{
					LocationWithVehicleDTO convertToDto = convertToDto(add);
					listVehicle.add(convertToDto);
				}
				}
			}
			
			
			return listVehicle;
			
		}
		
		
		
		
		
		
		
		
		

		

		List<AssignVehicleForSubbranch> vehicleWithLocation = vehicleDao.getVehicleWithLocation(location_id);
		
		
		

		if (vehicleWithLocation == null) {
			return null;
		}
		;

		if (location_id != null && brand_id != null && vehicle_type != null) {
			for (AssignVehicleForSubbranch add : vehicleWithLocation) {
				if (add.getAvilable() != false) {
					if (add.getVehicle_type() == vehicle_type) {
						if (add.getBrandLocaton().getVehicleBrand_id().getVehicle_id() == brand_id) {
							LocationWithVehicleDTO convertToDto = convertToDto(add);
							listVehicle.add(convertToDto);
						}
					}

				}

			}
			return listVehicle;
		} else if (location_id != null && vehicle_type != null) {
			for (AssignVehicleForSubbranch add : vehicleWithLocation) {
				if (add.getAvilable() != false) {
					if (add.getVehicle_type() == vehicle_type) {
						LocationWithVehicleDTO convertToDto = convertToDto(add);
						listVehicle.add(convertToDto);
					}

				}

			}

			return listVehicle;
		} else {

			for (AssignVehicleForSubbranch add : vehicleWithLocation) {
				LocationWithVehicleDTO convertToDto = convertToDto(add);
				listVehicle.add(convertToDto);

			}

			return listVehicle;
		}

	}

	public LocationWithVehicleDTO convertToDto(AssignVehicleForSubbranch add) {
		LocationWithVehicleDTO obj = new LocationWithVehicleDTO();
		obj.setBrand(add.getBrandLocaton().getVehicleBrand_id().getVehicle_brand_name());
		obj.setLocation(add.getBrandLocaton().getLocation());
		obj.setShowroom(add.getBrandLocaton().getSubbrand_name());
		obj.setVehicle_type(add.getVehicle_type());
		obj.setVehicle_model(add.getVechile_name());
		obj.setVehicle_colour(add.getColour());

		return obj;
	}

}
