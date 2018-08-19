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

import bean.CreditCardBean;

public class CreditCardDAO {
	/*********Attributes************/
	private DataSource ds;
	private String query;
	private CreditCardBean creditcard;


	/*********Constructor************/
	public CreditCardDAO() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS"); 
		} catch (NamingException e) {
			e.printStackTrace();
		} 
	}
	/*********Methods************/
	public CreditCardBean getCreditCard(int a_ccid) throws SQLException {
		query = "select * FROM creditcard where ccid=" + a_ccid;

		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();

		while (r.next()) {
			creditcard = new CreditCardBean(Integer.parseInt(r.getString("ccid")), r.getString("type"), r.getString("num")
					, r.getString("cvv"), r.getString("month"), r.getString("yr"));
		}

		r.close();
		p.close();
		con.close();
		return creditcard;
	}
}
