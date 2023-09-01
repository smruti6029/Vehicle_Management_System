package com.vechileManagementSystem.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vechileManagementSystem.DAO.VehicleAssignShowroomDao;
import com.vechileManagementSystem.DAO.VehicleSubBrandDAO;
import com.vechileManagementSystem.DTO.AssignVehicleShowroomDto;
import com.vechileManagementSystem.DTO.ShowAvilabeDetalis;
import com.vechileManagementSystem.Entity.*;
import com.vechileManagementSystem.enums.VehicleType;

@Service
public class AssignVehicleInShowroom {

	@Autowired
	private VehicleAssignShowroomDao assignShowroomDao;

	@Autowired
	private VehicleSubBrandDAO subbrandDAO;

	public Integer assignVehicle(AssignVehicleShowroomDto assignVehicle) {
		try {

			String vehicle_number;

			while (true) {
				int count = 1;
				LocalDate currentDate = LocalDate.now();
				String currentYear = String.valueOf(currentDate.getYear());
				vehicle_number = assignVehicle.getVechile_name() + "-" + currentYear + "-" + String.valueOf(count);
				try {
					AssignVehicleForSubbranch vehicleNumber = assignShowroomDao.getVehicleNumber(vehicle_number);
					break;
				} catch (Exception e) {
					count++;
				}
			}
			
			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedDateTime = currentDateTime.format(formatter);

			AssignVehicleForSubbranch obj = new AssignVehicleForSubbranch();

			obj.setAssignDate(formattedDateTime);
			obj.setAvilable(true);
			obj.setColour(assignVehicle.getColour());
			obj.setVehicle_number(vehicle_number);
			obj.setBrandLocaton(assignVehicle.getBrandLocaton());
			obj.setVechile_name(assignVehicle.getVechile_name());
			obj.setVehicle_type(assignVehicle.getVehicle_type());
			obj.setVehicle_chechis_number(assignVehicle.getVehicle_chechis_number());
			Integer insertAssignvehicle = assignShowroomDao.insertAssignvehicle(obj);
			return insertAssignvehicle;
		} catch (Exception e) {
			return 0;

		}

	}

	public List<ShowAvilabeDetalis> getbyShowroomid(Integer id, String type)

	{
		System.out.println("Inside Sub Brand");
		try {
			List<AssignVehicleForSubbranch> avilabeVehicle = assignShowroomDao.getAvilableAll();

			List<ShowAvilabeDetalis> avilabeDetalis = new ArrayList<>();

			if (avilabeVehicle != null) {
				for (AssignVehicleForSubbranch vehicle : avilabeVehicle) {
					
					if(vehicle.getAvilable()==true)
					{

					if (vehicle.getBrandLocaton().getSubbrand_id() == id) {

						VehicleType typeofVehicle = vehicle.getVehicle_type();
						String vehicletype = typeofVehicle.toString();
						if (vehicletype.equalsIgnoreCase(type)) {
							ShowAvilabeDetalis obj = new ShowAvilabeDetalis();
							obj.setVehicle_name(vehicle.getVechile_name());
							obj.setColour(vehicle.getColour());
							obj.setShowroom(vehicle.getBrandLocaton().getSubbrand_name());
							obj.setType(vehicle.getVehicle_type());
							obj.setBrand_name(vehicle.getBrandLocaton().getVehicleBrand_id().getVehicle_brand_name());
							obj.setLocation(vehicle.getBrandLocaton().getLocation());
							
							
							avilabeDetalis.add(obj);

						}
					}
				}
				}
				return avilabeDetalis;

			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	public List<AssignVehicleForSubbranch> getAlldetalis() {
		
		List<AssignVehicleForSubbranch> avilableAll = assignShowroomDao.getAvilableAll();
		return avilableAll;
	}

}
