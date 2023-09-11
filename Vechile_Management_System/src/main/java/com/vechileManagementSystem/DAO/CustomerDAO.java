package com.vechileManagementSystem.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

	public Integer saveCustomer(Customer customer) {

		try {
			hibernateTemplate.save(customer);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

//		public Customer getBygmail(String gmail) {
//		
//		try
//		{
//		List<Customer> customer = (List<Customer>) hibernateTemplate.findByNamedParam("from Customer where gmail = :gmail",
//				"gmail", gmail);
//				return customer.get(0);
//		}
//		catch(Exception e)
//		{
//			return null;
//		}

//	}

//	public Customer getNumber(String vehicle_number) {
//
//		try {
//			List<Customer> customer = (List<Customer>) hibernateTemplate.findByNamedParam(
//					"from Customer where vehicle_number = :vehicle_number", "vehicle_number", vehicle_number);
//
//			return customer.get(0);
//		} catch (Exception e) {
//			return null;
//		}
//
//	}

//		public Customer getById(Integer id)
//		{
//			Customer customer = hibernateTemplate.get(Customer.class, id);
//			
//			return customer;
//		}

//		-------------------------------------------------------- Criteria Queary Using Session factory-------
	@Autowired
	private SessionFactory sessionFactory;

	public Customer getById(Integer id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("id", id));
		return (Customer) criteria.uniqueResult();

	}

	public Customer getBygmail(String gmail) {

		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Customer.class);
		cr.add(Restrictions.eq("gmail", gmail));
		return (Customer) cr.uniqueResult();
	}

	public Customer getNumber(String vehicle_number) {
		try
		{

		Criteria cr=sessionFactory.getCurrentSession().createCriteria(Customer.class);
		cr.add(Restrictions.eq("vehicle_number",vehicle_number));
		return (Customer) cr.list().get(0);
		}
		catch (Exception e) {
			return null;
		}
		

	}

}

























