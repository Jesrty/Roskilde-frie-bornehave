public class Parent extends Person {

	private int phoneNumber;
	private String mail;

	public Parent(String firstName, String lastName, int phoneNumber, String mail) {
		super(firstName, lastName);
		this.phoneNumber = phoneNumber;
		this.mail = mail;
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
}