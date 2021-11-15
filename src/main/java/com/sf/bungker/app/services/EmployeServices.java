package com.sf.bungker.app.services;

import java.util.List;


import com.sf.bungker.app.entities.UserDetail;

public interface EmployeServices {

	List<UserDetail> all();
	UserDetail save(UserDetail ud);
	UserDetail find(long id);
	
}
