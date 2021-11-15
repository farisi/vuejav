package com.sf.bungker.app.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.bungker.app.entities.UserDetail;
import com.sf.bungker.app.repositories.UserDetailRepository;
import com.sf.bungker.app.services.EmployeServices;

@Service
public class EmployeImplement implements EmployeServices {

	@Autowired 
	UserDetailRepository udRepo;

	@Override
	public List<UserDetail> all() {
		// TODO Auto-generated method stub
		return udRepo.findAll();
	}

	@Override
	public UserDetail save(UserDetail ud) {
		// TODO Auto-generated method stub
		return udRepo.save(ud);
	}

	@Override
	public UserDetail find(long id) {
		// TODO Auto-generated method stub
		return udRepo.getById(id);
	}
	

}
