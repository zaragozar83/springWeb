package com.coffee.springweb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.coffee.springweb.dao.AdminDAO;
import com.coffee.springweb.domain.Admin;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {

	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public boolean save(Admin admin) {
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		return jdbcTemplate.update("insert into Admin (nombre, cargo, fechaCreacion) values (:nombre, :cargo, :fechaCreacion)", paramMap) == 1;
	}

	@Override
	public List<Admin> findAdmins() {
		return jdbcTemplate.query("SELECT * FROM Admin", new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setNombre(rs.getString("nombre"));
				admin.setCargo(rs.getString("cargo"));
				admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
				return admin;
			}
		});
	}

	@Override
	public Admin findAdminById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAdminByName(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] saveAllAdmins(List<Admin> admins) {
		// TODO Auto-generated method stub
		return null;
	}

}
