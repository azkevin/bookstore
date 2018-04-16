package model;

import java.util.Map;

import DAO.BookDAO;
import DAO.EnrollmentDAO;
import DAO.StudentDAO;
import bean.BookBean;
import bean.EnrollmentBean;
import bean.StudentBean;

public class Model {
	private StudentDAO studentDAO;
	private EnrollmentDAO enrollmentDAO;
	private BookDAO bookDAO;
	
	public Model() throws ClassNotFoundException {
		this.studentDAO = new StudentDAO();
		this.enrollmentDAO = new EnrollmentDAO();
		this.bookDAO = new BookDAO();
	}
	
	public Map<String, BookBean> retrieveByCategory(String category) throws Exception {
		if(category.equalsIgnoreCase("All")) {
			return this.bookDAO.retrieveAll();
		}
		return this.bookDAO.retrieveAllByCategory(category);
	}
	
	public Map<String, StudentBean> retriveStudent(String namePrefix, int credit_taken) throws Exception {
		return this.studentDAO.retrieve(namePrefix, credit_taken);
	}
	
	public Map<String, EnrollmentBean> retriveEnrollment() throws Exception {
		return this.enrollmentDAO.retrieve();
	}
}
