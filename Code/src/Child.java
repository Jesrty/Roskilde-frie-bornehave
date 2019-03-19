import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.*;

public class Child extends Person {

	private int cpr;
	private boolean waitingList;
	private String date;
	//private String pattern = "dd-MM-yyyy"; //pattern for the date to print.
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy"); //pattern for the date to print.
	private String waitingListDate;

	public Child(String firstName, String lastName, int cpr, boolean waitingList, String waitingListDate) {
		super(firstName, lastName);
		this.cpr = cpr;
		this.waitingList = waitingList;
		this.waitingListDate = waitingListDate;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWaitingListDate() {
		return waitingListDate;
	}

	public void setWaitingListDate(String waitingListDate) {
		this.waitingListDate = waitingListDate;
	}

	public String toString(String option){
		String text = "";
		if(option.toLowerCase() == "save"){
			text = getFirstName() + "," + getFirstName() + "," + getCpr() + "," + isWaitingList() + "," + getWaitingListDate();
		}
		return text;
	}

	/* --- denne sektion er "lånt" fra internettet --- */
	public static int getDiffDays(Date first, Date last){
		long difference = last.getTime() - first.getTime();
		float daysBetween = (difference / (1000*60*60*24));
		return (int)daysBetween;
	}
	public static int getDiffYears(Date first, Date last) {
		Calendar a = getCalendar(first);
		Calendar b = getCalendar(last);
		int diff = b.get(YEAR) - a.get(YEAR);
		if (a.get(MONTH) > b.get(MONTH) ||
				(a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
			diff--;
		}
		return diff;
	}
	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(date);
		return cal;
	}

	public String timeSinceJoined(){
		try{
			String builder = "";
			//numbers of days as a member:
			Date date = simpleDateFormat.parse(this.waitingListDate);
			int totalDays = getDiffDays(date, new Date());
			int year = totalDays / 365;
			totalDays = totalDays % 365;
			//System.out.println("No. of years:"+year);
			int week = totalDays / 7;
			totalDays = totalDays % 7;
			//System.out.println("No. of weeks:"+week);
			int day = totalDays;
			//System.out.println("No. of days:"+day);
			//end
			if(year > 0){
				builder += year + " år ";
			}
			if(week > 0){
				builder += week + " uger ";
			}
			if(day > 0 || day == 0){
				builder += day + " dage";
			}else{
				builder = "error calulating the days since joined.";
			}
			return builder;
		}catch (ParseException e){
			System.out.println(e);
		}
		return "virker ikke";
	}
}
