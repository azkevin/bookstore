package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.UserBean;


public class LoginDAO {
	DataSource ds;
	UserBean currentUser;

	public LoginDAO() throws ClassNotFoundException {

		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public UserBean loginUser(String username, String password) throws SQLException {
		String query = "select * FROM users U where U.username='" + username + "'and U.password='" + password + "'";

		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();

		while (r.next()) {
			currentUser = new UserBean(Integer.parseInt(r.getString("USERID")),r.getString("USERNAME"), 
					r.getString("PASSWORD"), r.getString("EMAIL"), r.getString("FIRSTNAME"), r.getString("LASTNAME"), r.getString("TYPE"));
		}

		r.close();
		p.close();
		con.close();
		return currentUser;
	}
	
	public UserBean getPassword(String username, String zip) throws SQLException {
		//might not be best query, it gets even the first and last name of user
		String query = "select * from customer natural join Address where lower(username)='" + username + "'and lower(zip)='" + zip + "'"; 


		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();

		while (r.next()) {
			currentUser = new UserBean(Integer.parseInt(r.getString("USERID")),r.getString("USERNAME"), 
					r.getString("PASSWORD"), r.getString("EMAIL"), r.getString("FIRSTNAME"), r.getString("LASTNAME"), r.getString("TYPE"));
		}

		r.close();
		p.close();
		con.close();
		return currentUser;
	}
	
	public UserBean getUserName(String fname, String lname, String zip) throws SQLException {
		//might not be best query, it gets even the first and last name of user
		String query = "select * from customer natural join Address where lower(FIRSTNAME)='" + fname + "'and lower(LASTNAME)='" + lname + "'and lower(zip)='" + zip + "'"; 


		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();

		while (r.next()) {
			currentUser = new UserBean(Integer.parseInt(r.getString("USERID")),r.getString("USERNAME"), 
					r.getString("PASSWORD"), r.getString("EMAIL"), r.getString("FIRSTNAME"), r.getString("LASTNAME"), r.getString("TYPE"));
		}

		r.close();
		p.close();
		con.close();
		return currentUser;
	}
}
