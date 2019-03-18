import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunctionHandler {

	List<Employee> employeeList = new ArrayList<Employee>();
	List<Child> childList = new ArrayList<Child>();
	List<Parent> parentList = new ArrayList<Parent>();

	public void createChild() {
		// TODO - implement FunctionHandler.createChild
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param cpr
	 */
	public void editChild(int cpr) {
		// TODO - implement FunctionHandler.editChild
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param cpr
	 */
	public void getChildInfo(int cpr) {
		// TODO - implement FunctionHandler.getChildInfo
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param child
	 */
	public void getPhoneList(boolean child) {
		// TODO - implement FunctionHandler.getPhoneList
		throw new UnsupportedOperationException();
	}

	public void createEmployee() {
		// TODO - implement FunctionHandler.createEmployee
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param id
	 */
	public void editEmployee(int id) {
		// TODO - implement FunctionHandler.editEmployee
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param id
	 */
	public String getEmployee(int id) {
		// TODO - implement FunctionHandler.getEmployee
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param week
	 */
	public void editSchedule(int week) {
		// TODO - implement FunctionHandler.editSchedule
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param week
	 */
	public void viewSchedule(int week) {
		// TODO - implement FunctionHandler.viewSchedule
		throw new UnsupportedOperationException();
	}

	public void checkArraySizes(){
		if(childList.size() == 0 && parentList.size() == 0 && employeeList.size() == 0){
			populateChilds();
			populateParents();
			populateEmployees();
		}
	}

	public void populateParents(){

	}

	public void populateChilds(){
		//make sure the array is empty
		childList.clear();

		try {
			Scanner scan = new Scanner(new File("children.txt"));
			do{
				Object[] info = scan.nextLine().split(",");
				childList.add(new Child(
						info[0].toString(), //first name
						info[1].toString(), //last name
						Integer.parseInt(info[2].toString()), //cpr
						Boolean.parseBoolean(info[3].toString()), //on waiting list
						info[4].toString() //waiting list date
				));
			}while (scan.hasNextLine());

		}catch (FileNotFoundException e){
			System.out.println("Ingen fil fundet");
		}
	}

	public void populateEmployees(){
		//make sure the array is empty
		employeeList.clear();

		try {
			Scanner scan = new Scanner(new File("employees.txt"));
			do{
				Object[] info = scan.nextLine().split(",");
				employeeList.add(new Employee(
						Integer.parseInt(info[0].toString()), //id
						info[1].toString(), //first name
						info[2].toString(), //last name
						info[3].toString(), //Username
						info[4].toString(), //Password
						Integer.parseInt(info[5].toString()), //phone number
						info[6].toString(), //initials
						Boolean.parseBoolean(info[7].toString()) //is admin
				));
			}while (scan.hasNextLine());

		}catch (FileNotFoundException e){
			System.out.println("Ingen fil fundet");
		}
	}



}