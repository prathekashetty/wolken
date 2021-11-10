package com.wolken.mvc.service;


	/*import org.springframework.stereotype.Component;

	@Component
	public class ServiceImpl {
		public void printHello() {
			System.out.println("Hello service");
		}
	}*/
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wolken.mvc.dao.PhoneDetailsDAO;
import com.wolken.mvc.dto.PhoneDTO;
import com.wolken.mvc.entity.PhoneEntity;


@Component
public class PhoneServiceImpl implements PhoneService {
	
	@Autowired
	PhoneDetailsDAO dao;
	
	public String validateAndSave(PhoneDTO dto) {
		PhoneEntity entity=new PhoneEntity();
        if (dto !=null){
            BeanUtils.copyProperties(dto, entity);
        }
        return dao.save(entity);
	}

	public List<PhoneEntity> getByBrandName(String brandName) {
		
		return dao.getByBrandName(brandName);
	}

	public List<PhoneEntity> getByPrice(float price) {
		// TODO Auto-generated method stub
		return dao.getByPrice(price);
	}

	public PhoneEntity updatePriceByModelNo(int modelNo,float price) {
		PhoneEntity entity = dao.getByModelNo(modelNo);
		return dao.updatePriceByModelNo(entity,price);
	}

	public PhoneEntity updateAvailabilityByModelNo(int modelNo, boolean availability) {
		PhoneEntity entity = dao.getByModelNo(modelNo);
		return dao.updateAvailabilityByModelNo(entity, availability);
	}

	public void printHello() {
		// TODO Auto-generated method stub
		System.out.println("Hello service");
	}
	
}

