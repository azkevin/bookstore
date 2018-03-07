package bean;

import java.util.List;

public class EnrollmentBean {
	
	private String cid;
	private List<String> students;
	private int credit;
	
	public EnrollmentBean() {}
	
	public EnrollmentBean(String cid, List<String> students, int credit) {
		this.cid = cid;
		this.students = students;
		this.credit = credit;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public List<String> getStudents() {
		return students;
	}

	public void setStudents(List<String> students) {
		this.students = students;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

}
