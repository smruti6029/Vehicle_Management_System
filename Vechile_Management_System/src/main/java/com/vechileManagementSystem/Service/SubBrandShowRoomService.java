package com.vechileManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.vechileManagementSystem.DAO.VehicleSubBrandDAO;
import com.vechileManagementSystem.DTO.ShowRoomDTO;
import com.vechileManagementSystem.Entity.SubShowRoom;

@Service
public class SubBrandShowRoomService {

	@Autowired
	private VehicleSubBrandDAO subbrandDAO;

	public Integer SaveShowRoom(SubShowRoom showroom) {
		Integer insert = subbrandDAO.saveSubBrand(showroom);

		return insert;

	}

	public List<ShowRoomDTO> getShowroom() {
		List<SubShowRoom> allshowroom = subbrandDAO.getAllshowroom();

		List<ShowRoomDTO> allShorooms = new ArrayList<>();
//			for(SubShowRoom showrooms:allshowroom)
//			{
//				ShowRoomDTO obj=new ShowRoomDTO();
//				obj.setBrand(showrooms.getVehicleBrand_id().getVehicle_brand_name());
//				obj.setShowroom_location(showrooms.getLocation());
//				
//				
//				obj.setSub_brandname(showrooms.getSubbrand_name());
//				
//				allShorooms.add(obj);
//			}

		allShorooms = allshowroom.stream().map(check -> new ShowRoomDTO(check.getLocation(), check.getSubbrand_name(),
				check.getVehicleBrand_id().getVehicle_brand_name())).collect(Collectors.toList());

		return allShorooms;
	}
}
