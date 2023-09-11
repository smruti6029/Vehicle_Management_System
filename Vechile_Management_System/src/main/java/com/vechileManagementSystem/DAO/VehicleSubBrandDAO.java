package com.vechileManagementSystem.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vechileManagementSystem.Entity.SubShowRoom;

@Repository
@Transactional
public class VehicleSubBrandDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;

	public Integer saveSubBrand(SubShowRoom subBrandLocation) {

		try {
			hibernateTemplate.save(subBrandLocation);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	public List<SubShowRoom> getAllshowroom() {
//		try {
//			List<SubShowRoom> showrooms = hibernateTemplate.loadAll(SubShowRoom.class);
//			return showrooms;
//		} catch (Exception e) {
//			return null;
//		}
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(SubShowRoom.class);
		
		return criteria.list();

	}

	public SubShowRoom getSUbshowroom(Integer id) {
		return null;
	}
	
}
