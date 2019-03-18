public class Leader extends Employee {

	public Leader(String firstName, String lastName, String userName, String password, int phoneNumber, int id, String initials, boolean ADMIN) {
		super(firstName, lastName, userName, password, phoneNumber, id, initials);
	}

	private final boolean ADMIN = true;

}