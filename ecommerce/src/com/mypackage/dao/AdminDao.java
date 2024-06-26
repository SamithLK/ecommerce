package com.mypackage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mypackage.model.Admin;

public class AdminDao {
	
	private Connection con;
	
	public AdminDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean saveAdmin(Admin admin) {
		boolean flag = false;

		try {
			String query = "insert into admin(name, email, password, phone) values(?, ?, ?, ?)";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setString(1, admin.getName());
			psmt.setString(2, admin.getEmail());
			psmt.setString(3, admin.getPassword());
			psmt.setString(4, admin.getPhone());

			psmt.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public Admin getAdminByEmailPassword(String email, String password) {
		Admin admin = null;
		try {
			String query = "select * from admin where email = ? and password = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setString(1, email);
			psmt.setString(2, password);

			ResultSet set = psmt.executeQuery();
			while (set.next()) {
				admin = new Admin();
				admin.setId(set.getInt("id"));
				admin.setName(set.getString("name"));
				admin.setEmail(set.getString("email"));
				admin.setPassword(set.getString("password"));
				admin.setPhone(set.getString("phone"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}