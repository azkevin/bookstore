package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.ReviewBean;

public class ReviewDAO {

	DataSource ds;

	public ReviewDAO() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	
	public Map<String, ReviewBean> retrieveByBID(String bid) throws SQLException {
		String query = "select * from review where bid like '" + bid + "'";
		
		Map<String, ReviewBean> rv = new HashMap<String, ReviewBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()) {
			int reviewid = r.getInt("reviewid");
			int userid = r.getInt("userid");
			String username = "";
			String usernameQuery = "select username from users where userid = " + userid;
			PreparedStatement p2 = con.prepareStatement(usernameQuery);
			ResultSet r2 = p2.executeQuery();
			while(r2.next()) {
				username = r2.getString("username");
			}
			ReviewBean bean = new ReviewBean(reviewid, r.getString("bid"), 
					userid, username, r.getInt("rating"), r.getString("reviewdesc"));
			rv.put(Integer.toString(reviewid), bean);
		}
		r.close();
		p.close();
		con.close();
		
		return rv;
	}

}
