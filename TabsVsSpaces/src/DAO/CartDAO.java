package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	
	/**
	 * @param bid the book id being searched
	 * @return a CartBean holding the data of the book searched
	 * @throws SQLException
	 */
	public CartBean findById(String bid) throws SQLException
	{
		String query = "SELECT TITLE, AUTHOR, COVERART, PRICE FROM BOOK B WHERE B.bid='" + bid + "'";
		
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();

		while (r.next())
		{
			String title = r.getString("TITLE");
			String author = r.getString("AUTHOR");
			String coverart = r.getString("COVERART");
			float price = Float.parseFloat(r.getString("PRICE"));
			

	
			CartBean cb = new CartBean(bid, title, author, coverart, price, 1);
			
			r.close();
			p.close();
			con.close();
			
			return cb;
			
		}
		return new CartBean("bnf", "Book Not Found", "Nobody", "", 0, 0);
	}

}
