package com.vechileManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vechileManagementSystem.DAO.CustomerDAO;
import com.vechileManagementSystem.DAO.VehicleAssignShowroomDao;
import com.vechileManagementSystem.DTO.CustumerdetaliesWithVehicleDetalis;
import com.vechileManagementSystem.Entity.AssignVehicleForSubbranch;
import com.vechileManagementSystem.Entity.Customer;

@Service
public class GetCustomerDetalisWithVehicle {

	@Autowired
	private VehicleAssignShowroomDao assignVehicle;
	
	@Autowired
	private CustomerDAO customerDAO;

	public CustumerdetaliesWithVehicleDetalis getCustomer(String gmailId) {
		
		Customer custumergmail = customerDAO.getBygmail(gmailId);
		
		if(custumergmail==null)
		{
			return null;
			
		}
		
		AssignVehicleForSubbranch customer = assignVehicle.getCustomer(custumergmail.getCustomer_id());
		
		
		
		System.out.println(customer);

		if (customer != null) {

			CustumerdetaliesWithVehicleDetalis custumerDetalis = new CustumerdetaliesWithVehicleDetalis();
			custumerDetalis.setCustomer_name(customer.getCustomer().getName());
			custumerDetalis.setChechis_number(customer.getVehicle_chechis_number());
			custumerDetalis.setAddress(customer.getCustomer().getAddress());
			custumerDetalis.setBrand(customer.getBrandLocaton().getVehicleBrand_id().getVehicle_brand_name());
			custumerDetalis.setColour(customer.getColour());
			custumerDetalis.setVehicle_enigne_number(customer.getVehicle_number());
			custumerDetalis.setIssue_date(customer.getCustomer().getIssue_date());
			custumerDetalis.setLocation(customer.getBrandLocaton().getLocation());
			custumerDetalis.setVehicle_model(customer.getVechile_name());
			custumerDetalis.setVehicle_type(customer.getVehicle_type());
			custumerDetalis.setVehicle_number(customer.getCustomer().getVehicle_number());
			custumerDetalis.setShowroom(customer.getBrandLocaton().getSubbrand_name());
			return custumerDetalis;

		} else {
			return null;
		}

	}

}
