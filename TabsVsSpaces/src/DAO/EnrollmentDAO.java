package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.EnrollmentBean;

public class EnrollmentDAO {

	DataSource ds;
	List<String> studentList;

	public EnrollmentDAO() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public Map<String, EnrollmentBean> retrieve() throws SQLException {
		String query = "select * from enrollment";
		Map<String, EnrollmentBean> rv = new HashMap<String, EnrollmentBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		
		while(r.next()){
			String cid = r.getString("cid");
			String sid = r.getString("sid");
			int credit = r.getInt("credit");
			
			//If our map doesn't already have the existing course id, then create it and the student list for it
			if(!rv.containsKey(cid)) {	
				this.studentList = new ArrayList<String>();
				this.studentList.add(sid);
				EnrollmentBean bean = new EnrollmentBean(cid, this.studentList, credit);
				rv.put(cid, bean);
				
			//If our map does contain the course id, just append new students to it
			} else if (rv.containsKey(cid)) {
				EnrollmentBean bean = rv.get(cid);
				bean.getStudents().add(sid);
			}
		}
		r.close();
		p.close();
		con.close();
		
		return rv;

	}

}
