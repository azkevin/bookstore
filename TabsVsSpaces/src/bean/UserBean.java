package bean;

public class UserBean {

	private int userID;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	
	public UserBean(int userID, String userName, String password, String firstName, String lastName) {
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
