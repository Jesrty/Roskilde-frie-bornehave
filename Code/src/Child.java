import java.util.Date;

public class Child extends Person {

	private int cpr;
	private boolean waitingList;
	private Date date;

	public Child(String firstName, String lastName, int cpr, boolean waitingList, Date date) {
		super(firstName, lastName);
		this.cpr = cpr;
		this.waitingList = waitingList;
		this.date = date;
	}

	public void setCpr(int cpr) {
		this.cpr = cpr;
	}

	public int getCpr() {
		return cpr;
	}

	public boolean isWaitingList() {
		return waitingList;
	}

	public void setWaitingList(boolean waitingList) {
		this.waitingList = waitingList;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
