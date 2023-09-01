package com.vechileManagementSystem.DAO;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vechileManagementSystem.Entity.VehicleBrand;

@Repository
@Transactional
public class VehicleBrandDAO {
		
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Integer saveBrandVehicle(VehicleBrand brand)
	{
		try
		{
		int save =(Integer) hibernateTemplate.save(brand);
		return save;
		}
		catch (Exception e) {
			return 0;
		}
		
	}
	
	public List<VehicleBrand> getAllbrands()
	{
		try
		{
		List<VehicleBrand> allBrands = hibernateTemplate.loadAll(VehicleBrand.class);
		return allBrands;
		}
		catch (Exception e) {
			return null;
		}
		
	}
	
	
	
}
