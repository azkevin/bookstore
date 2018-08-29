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
import bean.POBean;


public class PODAO {
	
	private DataSource ds;


	public PODAO() throws ClassNotFoundException
	{
		try
		{
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch(NamingException e)
		{
			e.printStackTrace();
		}
	}

	public void addNewPO(int a_userid, int a_addressid) throws SQLException {
		try {
			Connection con = this.ds.getConnection();
			Statement sta = con.createStatement();
			
			// get the maximum userid from the db
			ResultSet r = sta.executeQuery("SELECT * FROM po ORDER BY poid DESC FETCH FIRST ROW ONLY");
			r.next();
		    int rowCount = r.getInt(1);   
		    r.close();
		 
		    rowCount++;
		    
		    String insertQuery = "INSERT INTO po (poid, userid, addressid, status) " + "VALUES (" + rowCount + ", "
			    + a_userid + ", "
			    + a_addressid + ", \'ORDERED\')";
			
		    sta.executeUpdate(insertQuery);
			sta.close();
			con.close();

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Map<Integer, POBean> retrieveByPOId(int a_poid) throws SQLException {
		String query = "select * from po where poid=" + a_poid;
		Map<Integer, POBean> rv = new HashMap<Integer, POBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			POBean bean = new POBean(a_poid, r.getInt("userid"), r.getInt("addressid"), r.getString("status"));
			rv.put(a_poid, bean);
		}
		r.close();
		p.close();
		con.close();
		
		return rv;
	}
}
