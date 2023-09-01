package com.vechileManagementSystem.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vechileManagementSystem.Entity.AssignVehicleForSubbranch;

@Repository
@Transactional
public class VehicleAssignShowroomDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public Integer insertAssignvehicle(AssignVehicleForSubbranch obj) {

		try {
			hibernateTemplate.save(obj);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	public AssignVehicleForSubbranch getVehicleNumber(String vehicle_number) {

		try {
			List<AssignVehicleForSubbranch> assignVehicleForSubbranchs = (List<AssignVehicleForSubbranch>) hibernateTemplate
					.findByNamedParam("from AssignVehicleForSubbranch where vehicle_number = :vehicle_number",
							"vehicle_number", vehicle_number);

			return assignVehicleForSubbranchs.get(0);
		} catch (Exception e) {
			return null;
		}

	}

	public List<AssignVehicleForSubbranch> getAvilableAll() {
		{
			try {
				return hibernateTemplate.loadAll(AssignVehicleForSubbranch.class);
			} catch (Exception e) {
				return null;
			}
		}
	}

	public AssignVehicleForSubbranch getbyId(Integer id) {
		try {
			AssignVehicleForSubbranch Vehicle = hibernateTemplate.get(AssignVehicleForSubbranch.class, id);
			return Vehicle;
		} catch (Exception e) {
			return null;
		}
	}

	public Integer updateVehicleStatus(AssignVehicleForSubbranch obj) {
		try {
			hibernateTemplate.update(obj);
			return 1;
		} catch (Exception e) {
			return null;
		}

	}
	
	
	
	
	
	
	
	
	
	public AssignVehicleForSubbranch getCustomer(Integer customerId) {

		  try {
	            String hql = "FROM AssignVehicleForSubbranch avfs WHERE avfs.customer.customer_id = :customerId";
	            List<AssignVehicleForSubbranch> assignVehicleForSubbranchs = (List<AssignVehicleForSubbranch>) hibernateTemplate.findByNamedParam(hql, "customerId", customerId);

	            if (!assignVehicleForSubbranchs.isEmpty()) {
	                return assignVehicleForSubbranchs.get(0);
	            } else {
	                return null;
	            }
	        } catch (Exception e) {
	            
	            return null;
	        }

	
	
	}
	
	
	public List<AssignVehicleForSubbranch> getVehicleWithLocation(Integer subbrand_id) {

		  try {
	            String hql = "FROM AssignVehicleForSubbranch avfs WHERE avfs.brandLocaton.subbrand_id = :subbrand_id";
	            List<AssignVehicleForSubbranch> assignVehicleForSubbranchs = (List<AssignVehicleForSubbranch>) hibernateTemplate.findByNamedParam(hql, "subbrand_id", subbrand_id);

	            if (!assignVehicleForSubbranchs.isEmpty()) {
	                return assignVehicleForSubbranchs;
	            } else {
	                return null;
	            }
	        } catch (Exception e) {
	            
	            return null;
	        }

	
	
	}
	
	

}
