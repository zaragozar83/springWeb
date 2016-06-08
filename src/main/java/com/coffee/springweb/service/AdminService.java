package com.coffee.springweb.service;

import java.util.List;

import com.coffee.springweb.domain.Admin;

public interface AdminService {

	public boolean saveAdmin(Admin admin);
	public List<Admin> findAllAdmins();
}
