package com.coffee.springweb.dao;

import java.util.List;

import com.coffee.springweb.domain.Admin;

public interface AdminDAO {

	public boolean save(Admin admin);
	public List<Admin> findAdmins();
	public Admin findAdminById(int id);
	public List<Admin> findAdminByName(String nombre);
	public boolean updateAdmin(Admin admin);
	public boolean deleteAdmin(Admin admin);
	public int[] saveAllAdmins(List<Admin> admins);
}
