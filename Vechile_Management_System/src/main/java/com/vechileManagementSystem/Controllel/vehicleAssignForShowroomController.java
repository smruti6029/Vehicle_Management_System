package com.vechileManagementSystem.Controllel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vechileManagementSystem.DTO.AssignVehicleShowroomDto;
import com.vechileManagementSystem.DTO.ShowAvilabeDetalis;
import com.vechileManagementSystem.Entity.AssignVehicleForSubbranch;
import com.vechileManagementSystem.Service.AssignVehicleInShowroom;

@RestController
@RequestMapping("/Assignvehicle")
public class vehicleAssignForShowroomController {

	@Autowired
	private AssignVehicleInShowroom assignVehicleInShowroom;

	@PostMapping("/addvehicle")
	public ResponseEntity<?> AssignVehicle(@RequestBody AssignVehicleShowroomDto asignVehicle) {
		Integer assignVehicle = assignVehicleInShowroom.assignVehicle(asignVehicle);
		if (assignVehicle > 0) {
			return new ResponseEntity<String>(" Vehicle AddSucssfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Inviled Input", HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/avilable/{showroomID}/{type}")
	public ResponseEntity<?> ShowroomWithStock(@PathVariable("showroomID") Integer showroomID,
			@PathVariable("type") String type) {
		try {
			List<ShowAvilabeDetalis> getbyShowroomid = assignVehicleInShowroom.getbyShowroomid(showroomID, type);

			if (getbyShowroomid != null) {
				return new ResponseEntity<List<ShowAvilabeDetalis>>(getbyShowroomid, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Not Avilavble", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("Fallid", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("/getalldetalis")
	public ResponseEntity<?> allVechileWithShowroom() {
		try {
			List<AssignVehicleForSubbranch> alldetalis = assignVehicleInShowroom.getAlldetalis();
			if (alldetalis != null) {
				return new ResponseEntity<List<AssignVehicleForSubbranch>>(alldetalis, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No Content", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	
	@GetMapping("/number/{number}")
	public ResponseEntity<?> engineNumberDetalis(@PathVariable("number") String number)
	{
		System.out.println(number);
		
		
		AssignVehicleForSubbranch vehicleWithNumber = assignVehicleInShowroom.getvehicleWithNumber(number);
		
		if(vehicleWithNumber!=null)
		{
			return new ResponseEntity<AssignVehicleForSubbranch>(vehicleWithNumber,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Vehicle Not Present",HttpStatus.BAD_REQUEST);
		}
		
		
	}

	@GetMapping("/assigncount")
	public ResponseEntity<?> assignVechileCount() {
		try {
			String assignornotassign = assignVehicleInShowroom.getAssignornotassign();
			if (assignornotassign != null) {
				return new ResponseEntity<String>(assignornotassign, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No Content", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	
	
	
	
	
	
	
	
	
	
}
