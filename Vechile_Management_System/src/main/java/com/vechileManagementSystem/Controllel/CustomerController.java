package com.vechileManagementSystem.Controllel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vechileManagementSystem.DTO.CustomerDto;
import com.vechileManagementSystem.DTO.CustumerdetaliesWithVehicleDetalis;
import com.vechileManagementSystem.Entity.AssignVehicleForSubbranch;
import com.vechileManagementSystem.Service.CustomerService;
import com.vechileManagementSystem.Service.GetCustomerDetalisWithVehicle;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/save")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerDto customer) {

		try {
			Integer addCustumer = customerService.addCustumer(customer);
			if (addCustumer > 0) {

				return new ResponseEntity<String>("Booked SuccessFully", HttpStatus.CREATED);

			} else {
				return new ResponseEntity<String>("Booked Fallid", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("Try again", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@Autowired
	private GetCustomerDetalisWithVehicle customerDetalisWithVehicle;

	@GetMapping("/get/vehicle/{id}")
	public ResponseEntity<?> getCustomerWithVehicle(@PathVariable("id") String customer_gmail) {

		try {
			CustumerdetaliesWithVehicleDetalis customer = customerDetalisWithVehicle.getCustomer(customer_gmail);
			if (customer != null) {
				return new ResponseEntity<CustumerdetaliesWithVehicleDetalis>(customer, HttpStatus.OK);
			} else {

				return new ResponseEntity<String>("Custumer Not Present", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception e) {

			return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
		}
	}
	
		@GetMapping("/number/{number}")
			public ResponseEntity<?> custumerdetalisInnumber(@PathVariable("number") String number)
			{
				
			AssignVehicleForSubbranch custumeNumberwithDetalis = customerDetalisWithVehicle.custumeNumberwithDetalis(number);
			if(custumeNumberwithDetalis!=null)
			{
				return new ResponseEntity<>(custumeNumberwithDetalis,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>("No User Found",HttpStatus.BAD_REQUEST);
			}
			
			}

}
