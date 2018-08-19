package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.UserBean;

public class RegisterDAO {

	DataSource ds;
	UserBean user;

	public RegisterDAO() throws ClassNotFoundException {

		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	//Add user to our DB
	/**********Methods*********/
	public UserBean addNewUser(String username, String pwd, String email, String fName, String lName, String street, String province,
			String country, String zip, String phoneNumber, String a_cctype, String a_ccnumber, String a_cvv, String a_ccmonth, String a_ccyear) throws SQLException {
		try {
			Connection con = this.ds.getConnection();
			Statement sta = con.createStatement();
			
			// get the number of rows from the result set
			ResultSet r = sta.executeQuery("SELECT count(*) FROM users");
			r.next();
		    int rowCount = r.getInt(1);   
		    r.close();
		 
		    rowCount++;
		    
		    //allowing only customers to register
		    String type = "customer";
		    String user_query = "INSERT INTO users " + "VALUES (" + rowCount + ", \'" + username + "\', \'" + pwd + "\', \'" + email 
					+ "\', \'" + fName + "\', \'" + lName + "\', \'" + type + "\')";
		    //   1.  Update Users Table
			
		    sta.executeUpdate(user_query);
			user = new UserBean(rowCount, username, pwd, email, fName, lName, type);
			
			//   2. Update Address Table
		    String address_query = "INSERT INTO address " + "VALUES (" + rowCount + ", \'" + street + "\', \'" + province 
							+ "\', \'" + country  + "\', \'" + zip  + "\', \'" + phoneNumber + "\')";
			sta.executeUpdate(address_query);
			
			//	3. Update CreditCard Table
		    String creditcard_query = "INSERT INTO creditcard " + "VALUES (" + rowCount + ", \'" + a_cctype + "\', \'" + a_ccnumber 
					+ "\', \'" + a_cvv  + "\', \'" + a_ccmonth  + "\', \'" + a_ccyear + "\')";
		    sta.executeUpdate(creditcard_query);
			sta.close();
			con.close();

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return user;
	}
}
