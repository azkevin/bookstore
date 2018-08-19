package bean;

public class CreditCardBean {
	private int ccid;
	private String type;
	private String number;
	private String cvv;
	private String month;
	private String year;

	public CreditCardBean(int ccid, String type, String number, String cvv, String month, String year) {
		super();
		this.ccid = ccid;
		this.type = type;
		this.number = number;
		this.cvv = cvv;
		this.month = month;
		this.year = year;
	}
	
	public int getCcid() {
		return ccid;
	}

	public void setCcid(int ccid) {
		this.ccid = ccid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
