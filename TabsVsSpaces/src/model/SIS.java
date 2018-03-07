package model;

import java.util.Map;

import DAO.EnrollmentDAO;
import DAO.StudentDAO;
import bean.EnrollmentBean;
import bean.StudentBean;

public class SIS {
	private StudentDAO studentDAO;
	private EnrollmentDAO enrollmentDAO;
	
	public SIS() throws ClassNotFoundException {
		this.studentDAO = new StudentDAO();
		this.enrollmentDAO = new EnrollmentDAO();
	}
	
	public Map<String, StudentBean> retriveStudent(String namePrefix, int credit_taken) throws Exception {
		return this.studentDAO.retrieve(namePrefix, credit_taken);
	}
	
	public Map<String, EnrollmentBean> retriveEnrollment() throws Exception {
		return this.enrollmentDAO.retrieve();
	}
}
