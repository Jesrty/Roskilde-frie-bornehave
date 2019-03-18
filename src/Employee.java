public class Employee extends Person {

	private String userName;
	private String password;
	private int phoneNumber;
	private int id;
	private String initials;

	public Employee(String firstName, String lastName, String userName, String password, int phoneNumber, int id, String initials) {
		super(firstName, lastName);
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.initials = initials;
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

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}
}