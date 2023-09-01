package com.vechileManagementSystem.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vechileManagementSystem.DAO.CustomerDAO;
import com.vechileManagementSystem.DAO.VehicleAssignShowroomDao;
import com.vechileManagementSystem.DTO.CustomerDto;
import com.vechileManagementSystem.Entity.AssignVehicleForSubbranch;
import com.vechileManagementSystem.Entity.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private VehicleAssignShowroomDao assignDao;

	public Integer addCustumer(CustomerDto customer) {

		System.out.println(customer.getGmail());

		Customer bygmail = customerDAO.getBygmail(customer.getGmail());
		System.out.println(bygmail);
		String formattedDateTime;
		if (bygmail == null) {
			
			String vehicle_number_assign = "OD-33";
			int count = 0;
			Customer addCustomer = new Customer();
			
			
			if(customer.getDateof_bookVehicle()==null)
			{
			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			 formattedDateTime = currentDateTime.format(formatter);
			}
			else
			{
				formattedDateTime=customer.getDateof_bookVehicle();
			}

			while (true) {
				String number="";
				int num1 = 2013;
				count++;
				number += num1 += count;

				Customer number2 = customerDAO.getNumber(number);
				if (number2 == null) {
					vehicle_number_assign=number;
					break;
				}
			}

			addCustomer.setAddress(customer.getAddress());

			addCustomer.setName(customer.getName());

			addCustomer.setVehicle_number(vehicle_number_assign);

			addCustomer.setIssue_date(formattedDateTime);

			addCustomer.setGmail(customer.getGmail());

			System.out.println("master");

			Integer saveCustomer = customerDAO.saveCustomer(addCustomer);

			if (saveCustomer > 0) {
				AssignVehicleForSubbranch assignVehicleForShowroom = assignDao.getbyId(customer.getVehicle_id());

				if (assignVehicleForShowroom != null) {
					assignVehicleForShowroom.setAvilable(false);
					assignVehicleForShowroom.setSoldDate(formattedDateTime);
					assignVehicleForShowroom.setCustomer(addCustomer);

					Integer updateVehicleStatus = assignDao.updateVehicleStatus(assignVehicleForShowroom);
					return 1;
				}

			}

		} else {
			return 0;
		}
		return 0;

	}
}
