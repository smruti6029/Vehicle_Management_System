package com.vechileManagementSystem.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vechileManagementSystem.Entity.Customer;

@Repository
@Transactional
public class CustomerDAO {
	
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Integer saveCustomer(Customer customer)
	{
		
		
		try
		{
		hibernateTemplate.save(customer);
		return 1;
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	
		public Customer getBygmail(String gmail) {
		
		try
		{
		List<Customer> students = (List<Customer>) hibernateTemplate.findByNamedParam("from Customer where gmail = :gmail",
				"gmail", gmail);
				return students.get(0);
		}
		catch(Exception e)
		{
			return null;
		}

	}
		
		
		public Customer getNumber(String vehicle_number) {
			
			try
			{
			List<Customer> customer = (List<Customer>) hibernateTemplate.findByNamedParam("from Customer where vehicle_number = :vehicle_number",
					"vehicle_number", vehicle_number);
			
//					System.out.println(students);
			return customer.get(0);
			}
			catch(Exception e)
			{
				return null;
			}

		}
		
		public Customer getById(Integer id)
		{
			Customer customer = hibernateTemplate.get(Customer.class, id);
			
			return customer;
		}
	

}
