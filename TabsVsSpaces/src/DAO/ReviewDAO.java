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

import bean.ReviewBean;

public class ReviewDAO {

	DataSource ds;
	ReviewBean review;

	public ReviewDAO() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	
	public Map<Integer, ReviewBean> retrieveByBID(String bid) throws SQLException {
		String query = "select * from review where bid like '" + bid + "'";
		
		Map<Integer, ReviewBean> rv = new HashMap<Integer, ReviewBean>();
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
			rv.put(reviewid, bean);
		}
		r.close();
		p.close();
		con.close();
		
		return rv;
	}
	
	public ReviewBean addNewReview(String bid, int userid, String username, int rating, String reviewdesc) throws SQLException {
		try {
			Connection con = this.ds.getConnection();
			Statement sta = con.createStatement();
			
			// get the number of rows from the result set
			ResultSet r = sta.executeQuery("SELECT count(*) FROM review");
			r.next();
		    int rowCount = r.getInt(1);   
		    r.close();
		 
		    rowCount++;
		    
		    String review_query = "INSERT INTO review " + "VALUES (" + rowCount + ", \'" 
			    + bid + "\', " 
			    + userid + ", " 
			    + rating + ", \'" 
			    + reviewdesc + "\')";
		    // Update review table
			
		    sta.executeUpdate(review_query);
		    review = new ReviewBean(rowCount, bid, userid, username, rating, reviewdesc);

			sta.close();
			con.close();

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return review;
	}
}
