package com.coffee.springweb.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.springweb.dao.AdminDAO;
import com.coffee.springweb.domain.Admin;
import com.coffee.springweb.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	public boolean saveAdmin(Admin admin) {
		
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		
		return adminDAO.save(admin);
	}

	@Override
	public List<Admin> findAllAdmins() {
		return adminDAO.findAdmins();
	}
	
}
