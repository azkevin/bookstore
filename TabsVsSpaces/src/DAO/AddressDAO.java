package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.AddressBean;
import bean.BookBean;
import bean.UserBean;

public class AddressDAO {
	/*********Attributes************/
	private DataSource ds;
	private String query;
	private AddressBean address;


	/*********Constructor************/
	public AddressDAO() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS"); 
		} catch (NamingException e) {
			e.printStackTrace();
		} 
	}
	/*********Methods************/
	public AddressBean getAddress(int userID) throws SQLException {
		query = "select * FROM address A where A.id=" + userID;

		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();

		while (r.next()) {
			address = new AddressBean(Integer.parseInt(r.getString("ID")), r.getString("STREET"), r.getString("PROVINCE")
					, r.getString("COUNTRY"), r.getString("ZIP"), r.getString("PHONE"));
		}

		r.close();
		p.close();
		con.close();
		return address;
	}
	
	public void setAddress(int userID, String password, String street, String province, String country, String zip, String phone) 
			throws SQLException {
		query = "UPDATE address SET street=\'" + street + "\', province=\'" + province +
				"\', country=\'" + country + "\', zip=\'" + zip + "\', phone=\'" + phone + "\' WHERE userid=" + userID;
		
		Connection con = this.ds.getConnection();
		Statement sta = con.createStatement(); 
	    sta.executeUpdate(query);
	    
	    query = "UPDATE customer SET password=\'" + password + "\' WHERE userid=" + userID;
	    sta.executeUpdate(query);
	   	sta.close();
				
		query = "select * from users where userid=" + userID;

		PreparedStatement p1 = con.prepareStatement(query);
		ResultSet r = p1.executeQuery();

		while (r.next()) {
			 System.out.println(r.getInt("USERID") + r.getString("PASSWORD"));
		}

		r.close();
		p1.close();

		con.close();
	}
}
