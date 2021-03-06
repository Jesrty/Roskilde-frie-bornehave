public class Employee extends Person {

	private String userName;
	private String password;
	private int phoneNumber;
	private int id;
	private String initials;
	private boolean admin;

	public Employee(int id, String firstName, String lastName, String userName, String password, int phoneNumber, String initials, boolean admin) {
		super(firstName, lastName);
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.initials = initials;
		this.admin = admin;
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	//int id, String firstName, String lastName, String userName, String password, int phoneNumber, String initials, boolean admin
	public String toString(String option){
	    String text = "";

	    if(option.toLowerCase() == "save"){
	        text = getId() + "," +
                    getFirstName() + "," +
                    getLastName() + "," +
                    getUserName() + "," +
                    getPassword() + "," +
                    getPhoneNumber() + "," +
                    getInitials() + "," +
                    isAdmin();
        }

	    return text;
    }
}