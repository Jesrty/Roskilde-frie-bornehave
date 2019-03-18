public class Parent extends Person {

	private int phoneNumber;
	private String mail;
	private int cpr;

	public Parent(String firstName, String lastName, int phoneNumber, String mail, int cpr) {
		super(firstName, lastName);
		this.phoneNumber = phoneNumber;
		this.mail = mail;
		this.cpr = cpr;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getCpr() {
		return cpr;
	}

	public void setCpr(int cpr) {
		this.cpr = cpr;
	}
}