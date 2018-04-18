package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.UserBean;
import bean.CartBean;

public class OrderDAO {

	DataSource ds;

	public OrderDAO() throws ClassNotFoundException {

		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public String submitOrder(int uid, String status, ArrayList<CartBean> list) throws SQLException {
		String result = "";
		try {
			Connection con = this.ds.getConnection();
			Statement sta = con.createStatement();
			
			// get the number of rows from the result set
			ResultSet r = sta.executeQuery("SELECT count(*) FROM po");
			r.next();
		    int rowCount = r.getInt(1);
		    if(rowCount%3 == 0)
		    	result = "Credit Card Authorization Failed.";
		    else
		    	result = "Order Successfully Completed.";
		    r.close();
		    
		    ResultSet r1 = sta.executeQuery("SELECT count(*) FROM poitem");
		    r1.next();
		    int rowCount1 = r1.getInt(1);
		    r1.close();
		    
		    rowCount++;

		    //   1.  Update PO Table
			sta.executeUpdate("INSERT INTO po " + "VALUES (" + rowCount + ", " + uid + ", \'" + status + "\')");

			//   2. Update Address Table
			for (CartBean cart: list) {
			    rowCount1++;
				sta.executeUpdate("INSERT INTO poitem " + "VALUES (" + rowCount1 + ", " + rowCount + ", \'" + cart.getBid() 
						+ "\', " + cart.getPrice() + ")");
			}
			
		    sta.close();
			con.close();

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public void updateStatus() throws SQLException {
		Connection con = this.ds.getConnection();

		Statement stmt = con.createStatement();

		String sql = "UPDATE PO " + "SET status='denied' WHERE MOD(ind, 3) = 0";
		stmt.executeUpdate(sql);
		sql = "UPDATE PO " + "SET status='processed' WHERE status='ordered'";
		stmt.executeUpdate(sql);
	}

}
