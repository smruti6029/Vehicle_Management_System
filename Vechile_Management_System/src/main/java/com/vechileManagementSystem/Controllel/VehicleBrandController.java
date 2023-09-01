package com.vechileManagementSystem.Controllel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vechileManagementSystem.Entity.VehicleBrand;
import com.vechileManagementSystem.Service.VehicleBrandService;

@RestController
@RequestMapping("/vehiclebrand")
public class VehicleBrandController {
	
	@Autowired
	private VehicleBrandService brandService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveBrand(@RequestBody VehicleBrand brand)
	{
		
		Integer result = brandService.saveBrand(brand);
		if(result>0)
		{
			return new ResponseEntity<>("SuccessFully Saved",HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<>("fallid",HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/allBrand")
	public ResponseEntity<?> showAllbrand()
	{
		List<VehicleBrand> allBrands = brandService.getAllBrands();
		if(allBrands!=null)
		{
			return new ResponseEntity<List<VehicleBrand>> (allBrands,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String> ("Brand IS not avilable",HttpStatus.NO_CONTENT);
		}		
	}
	
}
