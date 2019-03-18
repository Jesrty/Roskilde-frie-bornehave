public class Child extends Person {

	private int cpr;

	public Child(String firstName, String lastName, int cpr) {
		super(firstName, lastName);
		this.cpr = cpr;
	}

	public void setCpr(int cpr) {
		this.cpr = cpr;
	}

	public int getCpr() {
		return cpr;
	}
}
