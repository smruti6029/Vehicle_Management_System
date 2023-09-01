package com.vechileManagementSystem.Controllel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vechileManagementSystem.DTO.LocationWithVehicleDTO;
import com.vechileManagementSystem.Service.VehicleLocationService;
import com.vechileManagementSystem.enums.VehicleType;

@RestController
@RequestMapping("/search")
public class VehicleDetalisWithTypeLocation {

	@Autowired
	private VehicleLocationService locationService;

	@PostMapping("/location")
	public ResponseEntity<?> searchVehicle(
	        @RequestParam(required = false) Integer location,
	        @RequestParam(required = false) VehicleType type,
	        @RequestParam(required = false) Integer brand) {

	   
	    List<LocationWithVehicleDTO> vehicle = locationService.getVehicle(brand, location, type);
	    
	    if(vehicle.isEmpty())
	    {
	    	return new ResponseEntity<String>("Not Avilabe",HttpStatus.BAD_REQUEST);
	    	 
	    	
	    }
	    else
	    {
	    	 return new ResponseEntity<List<LocationWithVehicleDTO>>(vehicle,HttpStatus.OK);
	  
	    }
	}

}
