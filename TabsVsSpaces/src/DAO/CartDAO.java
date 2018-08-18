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

import bean.CartBean;

public class CartDAO {
	
	private DataSource ds;


	public CartDAO() throws ClassNotFoundException
	{
		try
		{
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch(NamingException e)
		{
			e.printStackTrace();
		}
	}
	
	public Map<Integer, CartBean> retrieveByUserId(int a_userid) throws SQLException {
		String query = "select * from cart where userid=" + a_userid;
		Map<Integer, CartBean> rv = new HashMap<Integer, CartBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			int cartid = r.getInt("cartid");
			String bid = r.getString("bid");
			String bookQuery = "select * from book where bid like '" + bid + "'";
			PreparedStatement p2 = con.prepareStatement(bookQuery);
			ResultSet r2 = p2.executeQuery();
			String coverart = "";
			String title = "";
			float price = 0.0f;
			while(r2.next()) {
				coverart = r2.getString("coverart");
				title = r2.getString("title");
				price = r2.getFloat("price");
			}
			CartBean bean = new CartBean(cartid, r.getInt("userid"), bid, coverart, title, price);
			rv.put(cartid, bean);
		}
		r.close();
		p.close();
		con.close();
		
		return rv;
	}

	public void removeCartItem(int cartid) throws SQLException {
		try {
			Connection con = this.ds.getConnection();
			Statement sta = con.createStatement();
			String removeQuery = "DELETE FROM cart WHERE cartid=" + cartid;
			sta.executeUpdate(removeQuery);
			sta.close();
			con.close();

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
