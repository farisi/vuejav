package com.sf.bungker.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.bungker.app.entities.UserDetail;
import com.sf.bungker.app.services.EmployeServices;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {
	
	@Autowired
	private EmployeServices employeSrv;
	
	@GetMapping("")
	public List<UserDetail> index()
	{
		//test User detail
		List<UserDetail> userdetails = employeSrv.all();
		return userdetails;
	}

	public UserDetail store()
	{
		return employeSrv.save(new UserDetail());
	}

}
