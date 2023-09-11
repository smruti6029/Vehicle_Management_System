package com.vechileManagementSystem.Controllel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vechileManagementSystem.DTO.ShowRoomDTO;
import com.vechileManagementSystem.Entity.SubShowRoom;
import com.vechileManagementSystem.Service.SubBrandShowRoomService;

@RestController
@RequestMapping("/showroom")
public class VehicleShowroomController {
	
	
	@Autowired
	private SubBrandShowRoomService brandShowRoomService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveShowroom(@RequestBody SubShowRoom showroom)
	{
		
		
		Integer result = brandShowRoomService.SaveShowRoom(showroom);
		
		if(result>0)
		{
			return new ResponseEntity<String> ("Insert SuccessFully",HttpStatus.OK);
		}			
		return new ResponseEntity<String> ("Inserted Falid",HttpStatus.NO_CONTENT) ;
	}
	
	
//	Get all Showroom With Brand and Location avilable only 
	
	@GetMapping("/brandwithshowroom")
	public ResponseEntity<?> showroomWithBrand()
	{
		
		List<ShowRoomDTO> showrooms = brandShowRoomService.getShowroom();
		return new ResponseEntity<List<ShowRoomDTO>>( showrooms,HttpStatus.OK);
	}
	
	
	//Get All Showroom With Location
	
//	@GetMapping("/location/{locationName}")
//	public ResponseEntity<?> getshowroombyLoaction(@RequestBody String locationName)
//	{
//		
//		
//		return null;
//	}

}
