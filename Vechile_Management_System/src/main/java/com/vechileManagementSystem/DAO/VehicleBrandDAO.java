package com.vechileManagementSystem.DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vechileManagementSystem.Entity.VehicleBrand;

@Repository
@Transactional
public class VehicleBrandDAO {

//	@Autowired
//	private HibernateTemplate hibernateTemplate;

	@Autowired
	private SessionFactory sessionFactory;

//	public Integer saveBrandVehicle(VehicleBrand brand)
//	{
//		try
//		{
//		int save =(Integer) hibernateTemplate.save(brand);
//		return save;
//		}
//		catch (Exception e) {
//			return 0;
//		}
//		
//	}
//	
//	public List<VehicleBrand> getAllbrands()
//	{
//		try
//		{
//		List<VehicleBrand> allBrands = hibernateTemplate.loadAll(VehicleBrand.class);
//		return allBrands;
//		}
//		catch (Exception e) {
//			return null;
//		}
//		
//	}

	public Integer saveBrandVehicle(VehicleBrand brand) {
		try {
			Session currentSession = this.sessionFactory.getCurrentSession();
			int save = (Integer) currentSession.save(brand);
			return save;
		} catch (Exception e) {
			return 0;
		}

	}

	public List<VehicleBrand> getAllbrands() {
//		Session currentSession = this.sessionFactory.getCurrentSession();
//		List<VehicleBrand> list = currentSession.createQuery("From VehicleBrand", VehicleBrand.class).getResultList();
//		return list;

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(VehicleBrand.class);
		return criteria.list();
	}

}
