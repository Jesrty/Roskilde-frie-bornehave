import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FunctionHandler {

	File schedule = new File("schedule.txt");
	File employeeJ = new File("employees.txt");
	List<Employee> employeeList = new ArrayList<Employee>();
	List<Child> childList = new ArrayList<Child>();
	List<Parent> parentList = new ArrayList<Parent>();
	Scanner userInput = new Scanner(System.in);
	ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();

	public boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch(NumberFormatException e) {
			return false;
		} catch(NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}

	public void createChild() {
		// TODO - implement FunctionHandler.createChild
		int placeInInfo = 0;
		String finalStringChild = "";

		String[] infoNeededChild = {
				"Enter first name",
				"Enter last name",
				"Enter CPR number (05102010-0000)",
				"Enter waiting list (Yes or No)",
				"Enter witing list date (05-10-2010)"
		};

		do{
			System.out.println(infoNeededChild[placeInInfo]);
			if(placeInInfo != 5){
				finalStringChild += userInput.nextLine();
				if(placeInInfo != 4){
					finalStringChild += ",";
				}
			}
			placeInInfo++;
		}while(placeInInfo != 5);

		Object[] infoChild = finalStringChild.split(",");
		System.out.println(Arrays.toString(infoChild));
		System.out.println(infoChild[0]);
		System.out.println(infoChild[1]);
		childList.add(new Child(
				infoChild[0].toString(),
				infoChild[1].toString(),
				Integer.parseInt(infoChild[2].toString()),
				Boolean.parseBoolean(infoChild[3].toString()),
				infoChild[4].toString()
		));

		System.out.println("How many parents does " + infoChild[0].toString() + " " + infoChild[1].toString() + " have?");
		String numberOfParents = "";
		int j = 0;

		do{
			if(j > 0){ System.out.println(numberOfParents + " is not a number. Please try again."); }
			numberOfParents = userInput.nextLine();
			j++;
		}while(!isInteger(numberOfParents));

		j = 0;
		do{
			placeInInfo = 0; //resetting the counter for the parent
			String finalStringParent = "";
			String[] infoNeededParents ={
					"Enter parent first name",
					"Enter parent last name",
					"Enter parent phone number",
					"Enter parent email address"
			};

			do{
				System.out.println(infoNeededParents[placeInInfo]);
				if(placeInInfo != 4){
					finalStringParent += userInput.nextLine();
					if(placeInInfo != 3){
						finalStringParent += ",";
					}
				}
				placeInInfo++;
			}while(placeInInfo != 4);

			Object[] infoParent = finalStringParent.split(",");
			parentList.add(new Parent(
					infoParent[0].toString(),
					infoParent[1].toString(),
					Integer.parseInt(infoParent[2].toString()),
					infoChild[3].toString(),
					Integer.parseInt(infoChild[2].toString())
			));
			j++;
		}while(Integer.parseInt(numberOfParents) != j);


		//saving all the childs and parents info back to file
		saveChildren();
		saveParents();
	}

	/**
	 *
	 * @param cpr
	 */
	public void editChild(int cpr) {
		String[] editInfo = {"Fornavn","Efternavn","CPR","Venteliste","Dato"};

		for(int i = 0; i < childList.size(); i++){
			if(childList.get(i).getCpr() == cpr){
				Object[] info = childList.get(i).toString("save").split(",");

				int j = 0;
				System.out.println("Please choose a number: \n");
				do{
					System.out.println(" - (" + (j + 1) + ") " + editInfo[j] + ": " + info[j].toString());
					j++;
				}while(j != 5);

				String option = ""; //ask the user for option to edit
				String temp = ""; //hold the new changed info for later use.

				do{
					option = userInput.nextLine();
					System.out.println("\n ");
					switch (option){
						case "1": //firstname
							System.out.println("What should the new first name be?\n");
							temp = userInput.nextLine();
							System.out.println("Sure, you want to change " + info[1].toString() + " to " + temp + " - yes or no.");
							option = userInput.nextLine();

							if(option.equalsIgnoreCase("yes")){
								childList.get(i).setFirstName(temp);
								System.out.println("Changed " + info[1].toString() + " name to: " + temp);
							}else if(option.equalsIgnoreCase("no")){
								System.out.println("Ignoring any changes to " + info[1].toString() + "\'s first name");
							}
							break;

						case "2": //lastname
							System.out.println("What should the new last name be?\n");
							temp = userInput.nextLine();
							System.out.println("Sure, you want to change " + info[2].toString() + " to " + temp + " - yes or no.");
							option = userInput.nextLine();

							if(option.equalsIgnoreCase("yes")){
								childList.get(i).setLastName(temp);
								System.out.println("Changed " + info[2].toString() + " last name to: " + temp);
							}else if(option.equalsIgnoreCase("no")){
								System.out.println("Ignoring any changes to " + info[1].toString() + " " + info[2].toString() +  " last name");
							}
							break;

						case "3": //CPR
							System.out.println("What should the new CPR number be?\n");
							temp = userInput.nextLine();
							System.out.println("Sure, you want to change " + info[3].toString() + " to " + temp + " - yes or no.");
							option = userInput.nextLine();

							if(option.equalsIgnoreCase("yes")){
								childList.get(i).setCpr(Integer.parseInt(temp));
								System.out.println("Changed " + info[3].toString() + " CPR to: " + temp);
							}else if(option.equalsIgnoreCase("no")){
								System.out.println("Ignoring any changes to " + info[1].toString() + " " + info[2].toString() +  " CPR");
							}
							break;

						case "4": //Waiting list
							System.out.println("What should the new password be?\n");
							temp = userInput.nextLine();
							System.out.println("Sure, you want to change " + info[4].toString() + " to " + temp + " - yes or no.");
							option = userInput.nextLine();

							if(option.equalsIgnoreCase("yes")){
								childList.get(i).setLastName(temp);
								System.out.println("Changed " + info[4].toString() + " waiting list to: " + temp);
							}else if(option.equalsIgnoreCase("no")){
								System.out.println("Ignoring any changes to " + info[1].toString() + " " + info[2].toString() +  " waiting list");
							}
							break;

						case "5": //waiting list date
							System.out.println("What should the new phone number be?\n");
							temp = userInput.nextLine();
							System.out.println("Sure, you want to change " + info[5].toString() + " to " + temp + " - yes or no.");
							option = userInput.nextLine();

							if(option.equalsIgnoreCase("yes")){
								childList.get(i).setLastName(temp);
								System.out.println("Changed " + info[5].toString() + " waiting list date to: " + temp);
							}else if(option.equalsIgnoreCase("no")){
								System.out.println("Ignoring any changes to " + info[1].toString() + " " + info[2].toString() +  " waiting list date");
							}
							break;

						case "exit":
							option = "exit";
							break;

						default:
							for(int k = 1; k < editInfo.length; k++){
								System.out.println(" - (" + (k) + ") " + editInfo[k - 1] + ": " + info[k].toString());
							}
							System.out.println(option + " is a invalid option. Please choose a number from 1 to 4 to edit information.\n- type exit to go back");
							break;
					}
				}while(!option.equalsIgnoreCase("exit"));
			}else{
				System.out.println("No employee with the provided id. Please try again.");
			}
		}

		//saving all the childs info back to file
		saveChildren();
	}

	/**
	 *
	 * @param cpr
	 */
	public void getChildInfo(int cpr) {
		for(int i = 0; childList.size() > i; i++){
			int childCpr = childList.get(i).getCpr();
			if(childCpr == cpr){
				String firstName = childList.get(i).getFirstName();
				String lastName = childList.get(i).getLastName();
				System.out.println("Found the child with the corresponding CPR number.");
				System.out.println("- " + firstName + " " + lastName);
			}else if(childList.size() == i){
				System.out.println("No child with the CPR. Did you type right?");
			}
		}
	}

	/**
	 *
	 * @param child
	 */
	public void getPhoneList(boolean child) {
		// TODO - implement FunctionHandler.getPhoneList

		if(child == true) {
			for(int c = 0; c < childList.size(); c++){
				System.out.println(
						childList.get(c).getFirstName() + " " + childList.get(c).getLastName()
				);
				for(int p = 0; p < parentList.size(); p++){
					if(parentList.get(p).getCpr() == childList.get(c).getCpr()){
						System.out.println(
								"- " + parentList.get(p).getFirstName() + " " + parentList.get(p).getLastName() + " +(45)" + parentList.get(p).getPhoneNumber() + " " + parentList.get(p).getMail()
						);
					}
				}
				System.out.println("\n");
			}
		}else if(child == false){
			for(int i = 0; i < employeeList.size(); i++){
				System.out.println("- " + employeeList.get(i).getInitials() + " +45" + employeeList.get(i).getPhoneNumber());
			}
		}
	}

	public void createEmployee() {
		int newestId = (employeeList.get(employeeList.size() - 1).getId() + 1);

		int placeInInfo = 0;
		String finalString = "";

		//int id, String firstName, String lastName, String userName, String password, int phoneNumber, String initials, boolean admin
		String[] infoNeeded = {
				"Enter first name",
				"Enter last name",
				"Enter username",
				"Enter password",
				"Enter phone number",
				"Enter intials"
		};

		do{
			System.out.println(infoNeeded[placeInInfo]);
			if(placeInInfo != 6){
				finalString += userInput.nextLine();
				if(placeInInfo != 5){
					finalString += ",";
				}
			}
			placeInInfo++;
		}while(placeInInfo != 6);

		Object[] info = finalString.split(",");

		for(int i = 0; i < employeeList.size(); i++){
			if(employeeList.get(i).getInitials().equalsIgnoreCase(info[5].toString())){
				int j = 0;
				System.out.println("The choosen intials is taken. Please try again.");
				do{
					if(j > 0){ System.out.println("The choosen intials is taken. Please try again."); }
					info[5] = userInput.nextLine();
					j++;
				}while(employeeList.get(i).getInitials().equalsIgnoreCase(info[5].toString()));
			}
		}

		employeeList.add(new Employee(
				newestId,
				info[0].toString(),
				info[1].toString(),
				info[2].toString(),
				info[3].toString(),
				Integer.parseInt(info[4].toString()),
				info[5].toString(),
				Boolean.parseBoolean(info[3].toString())
		));

		
		//saving all the employees info back to file
		saveEmployees();
	}

	/**
	 *
	 * @param id
	 */
	public void editEmployee(int id) {
		String[] editInfo = {"Fornavn", "Efternavn", "Brugernavn", "Kodeord", "Telefon nummer", "Intialer"};

		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getId() == id) {
				Object[] info = employeeList.get(i).toString("save").split(",");

				int j = 1;
				System.out.println("Please choose a number: \n");
				do {
					System.out.println(" - (" + (j) + ") " + editInfo[j - 1] + ": " + info[j].toString());
					j++;
				} while (j != 7);

				String option = ""; //ask the user for option to edit
				String temp = ""; //hold the new changed info for later use.

				do {
					option = userInput.nextLine();
					System.out.println("\n ");
					switch (option) {
						case "1": //firstname
							System.out.println("What should the new first name be?\n");
							temp = userInput.nextLine();
							System.out.println("Sure, you want to change " + info[1].toString() + " to " + temp + " - yes or no.");
							option = userInput.nextLine();

							if (option.equalsIgnoreCase("yes")) {
								employeeList.get(id).setFirstName(temp);
								System.out.println("Changed " + info[1].toString() + " name to: " + temp);
							} else if (option.equalsIgnoreCase("no")) {
								System.out.println("Ignoring any changes to " + info[1].toString() + "\'s first name");
							}
							break;

						case "2": //lastname
							System.out.println("What should the new last name be?\n");
							temp = userInput.nextLine();
							System.out.println("Sure, you want to change " + info[2].toString() + " to " + temp + " - yes or no.");
							option = userInput.nextLine();

							if (option.equalsIgnoreCase("yes")) {
								employeeList.get(id).setLastName(temp);
								System.out.println("Changed " + info[2].toString() + " last name to: " + temp);
							} else if (option.equalsIgnoreCase("no")) {
								System.out.println("Ignoring any changes to " + info[1].toString() + " " + info[2].toString() + " last name");
							}
							break;

						case "3": //username
							System.out.println("What should the new username be?\n");
							temp = userInput.nextLine();
							System.out.println("Sure, you want to change " + info[3].toString() + " to " + temp + " - yes or no.");
							option = userInput.nextLine();

							if (option.equalsIgnoreCase("yes")) {
								employeeList.get(id).setUserName(temp);
								System.out.println("Changed " + info[3].toString() + " username to: " + temp);
							} else if (option.equalsIgnoreCase("no")) {
								System.out.println("Ignoring any changes to " + info[1].toString() + " " + info[2].toString() + " username");
							}
							break;

						case "4": //password
							System.out.println("What should the new password be?\n");
							temp = userInput.nextLine();
							System.out.println("Sure, you want to change " + info[4].toString() + " to " + temp + " - yes or no.");
							option = userInput.nextLine();

							if (option.equalsIgnoreCase("yes")) {
								employeeList.get(id).setLastName(temp);
								System.out.println("Changed " + info[4].toString() + " password to: " + temp);
							} else if (option.equalsIgnoreCase("no")) {
								System.out.println("Ignoring any changes to " + info[1].toString() + " " + info[2].toString() + " password");
							}
							break;

						case "5": //phone number
							System.out.println("What should the new phone number be?\n");
							temp = userInput.nextLine();
							System.out.println("Sure, you want to change " + info[5].toString() + " to " + temp + " - yes or no.");
							option = userInput.nextLine();

							if (option.equalsIgnoreCase("yes")) {
								employeeList.get(id).setLastName(temp);
								System.out.println("Changed " + info[5].toString() + " phone number to: " + temp);
							} else if (option.equalsIgnoreCase("no")) {
								System.out.println("Ignoring any changes to " + info[1].toString() + " " + info[2].toString() + " phone number");
							}
							break;

						case "6": //intitials
							System.out.println("What should the new initials be?");
							boolean checkInitials = true;
							int placeholder = 0;

							do {
								temp = userInput.nextLine();

								for (int l = 0; l < employeeList.size(); l++){
									if(employeeList.get(l).getInitials().equalsIgnoreCase(temp)){
										checkInitials = true;
										System.out.println("Those initials are taken. Try again:");
										break;
									}
									else{
										temp = employeeList.get(l).getInitials();
										checkInitials = false;
									}
									placeholder++;
								}
							} while (checkInitials);

							System.out.println("Sure, you want to change " + info[6].toString() + " to " + temp + " - yes or no.");
							option = userInput.nextLine();

							if (option.equalsIgnoreCase("yes")) {
								employeeList.get(id).setInitials(temp);
								info[6] = temp; //set the info to the info object array
								System.out.println("Changed " + info[6].toString() + " initials to: " + temp);
							} else if (option.equalsIgnoreCase("no")) {
								System.out.println("Ignoring any changes to " + info[1].toString() + " " + info[2].toString() + " initials");
							} else {
								System.out.println("'" + option + "' is not a valid option. Please choose yes or no.");
							}
							break;

						case "exit":
							option = "exit";
							break;

						default:
							for (int k = 0; k < editInfo.length; k++) {
								System.out.println(" - (" + (k + 1) + ") " + editInfo[k] + ": " + info[k + 1].toString());
							}
							System.out.println("\n '" + option + "' is a invalid option. Please choose a number from 1 to 6 to edit information.\n - type exit to go back");
							break;
					}
				} while (!option.equalsIgnoreCase("exit"));
			} else {
				System.out.println("No employee with the provided id. Please try again.");
			}
		}

		//saving all the employees info back to file
		saveEmployees();
	}

	/**
	 *
<<<<<<< HEAD
	 * @param week
	 */
=======
	 * @param id
	 */
	public String getEmployee(int id) {
		// TODO - implement FunctionHandler.getEmployee
		throw new UnsupportedOperationException();
	}

>>>>>>> 4dffef478a38051ea767bbe8f0bcf8c4ef8d00ea
	public void editSchedule(int week) {

		boolean test = false;

		try{
			Scanner sSchedule = new Scanner(schedule);
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<String> scheduleHolder = new ArrayList<String>();
			String namesDone = "";

			System.out.println("Type the day you want to edit (fx monday)");
			String day = userInput.nextLine();
			System.out.println("pick time (early or late)");
			String time = userInput.nextLine();



			while(sSchedule.hasNextLine()){
				String line = sSchedule.nextLine();
				String[] split = line.split(",");
				if(split[0].equals(Integer.toString(week)) & split[1].equals(day) & split[3].equals(time)){

					while(true){
						System.out.println("[1 = add worker]\n[2 = all workers are added]");
						String option = userInput.nextLine();
						if(option.equals("1")) {
							test = false;
							System.out.println("Type the initial of one worker");
							String initial = userInput.nextLine();

							Scanner sEmployee = new Scanner(employeeJ);
							while(sEmployee.hasNextLine()){
								String line1 = sEmployee.nextLine();
								String[] split1 = line1.split(",");
								if(initial.equals(split1[6])){
									names.add(initial);
									test = true;
								}
							}
							if(test == false){
								System.out.println("The initials is not in the system");
							}
							sEmployee.close();
						}

						else if(option.equals("2")){
							break;
						}
						else{
							System.out.println("You didn't pick a valid number");
						}
					}

					for(int i = 0; i<names.size(); i++) {
						if(i == 0) {
							namesDone = names.get(i);
						}
						else{
							namesDone = namesDone + " " + names.get(i);
						}
					}
					scheduleHolder.add(split[0] + "," + split[1] + "," + split[2] + "," + split[3] + "," + namesDone);
				}
				else{
					scheduleHolder.add(line);
				}
			}

			PrintStream printSchedule = new PrintStream(schedule);
            for(int j = 0; j<scheduleHolder.size(); j++){
                printSchedule.println(scheduleHolder.get(j));
            }

		}
		catch (FileNotFoundException e){
			System.out.println("Something went worng!");
		}
			}

	/**
	 *
	 * @param week
	 */
	public void viewSchedule(int week) {
		try {
			Scanner sSchedule = new Scanner(schedule);
			while (sSchedule.hasNextLine()) {
				String line = sSchedule.nextLine();
				String[] info = line.split(",");
				if (info[0].equals(Integer.toString(week))) {
					System.out.print("Week: " + info[0] + ". year: " + info[2] + "\n" + info[1] + ": " + info[3] + " [" + info[4] + "]");
					line = sSchedule.nextLine();
					info = line.split(",");
					System.out.println(" " + info[3] + " [" + info[4] + "]");

					while (sSchedule.hasNextLine()) {
							line = sSchedule.nextLine();
							info = line.split(",");
						if(info[0].equals(Integer.toString(week))) {
							System.out.print(info[1] + ": " + info[3] + " [" + info[4] + "]");
							line = sSchedule.nextLine();
							info = line.split(",");
							System.out.println(" " + info[3] + " [" + info[4] + "]");
						}
					}
				}
			}
			System.out.println("");
			sSchedule.close();
		}
		catch (FileNotFoundException e){
			System.out.println("a mistake was made!");
		}



	}

	public void checkArraySizes(){
		if(childList.size() == 0 || parentList.size() == 0 || employeeList.size() == 0){
			populateChilds();
			populateParents();
			populateEmployees();
			populateSchedule();
		}
	}

	public void populateParents(){
		//make sure the array is empty
		parentList.clear();

		try {
			Scanner scan = new Scanner(new File("parents.txt"));
			do{
				Object[] info = scan.nextLine().split(",");
				parentList.add(new Parent(
						info[0].toString(), //first name
						info[1].toString(), //last name
						Integer.parseInt(info[2].toString()), //phone number
						info[3].toString(), //mail
						Integer.parseInt(info[4].toString()) //Child cpr
				));
			}while (scan.hasNextLine());

		}catch (FileNotFoundException e){
			System.out.println("Ingen fil fundet");
		}
	}

	public void saveParents(){
		try{
			PrintStream file = new PrintStream(new File("parents.txt"));
				for(int i = 0; i < parentList.size(); i++){
					file.println(parentList.get(i).toString("save"));
				}
		}catch (FileNotFoundException e){
			System.out.println(e);
		}
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

	public void saveChildren(){
		try{
			PrintStream fileSave = new PrintStream(new File("children.txt"));
			for(int i = 0; i < childList.size(); i++){
				System.out.println(childList.get(i).toString("save"));
				fileSave.println(childList.get(i).toString("save"));
			}
		} catch (FileNotFoundException e){
			System.out.println(e);
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

	public void saveEmployees(){
		try{
			PrintStream file = new PrintStream(new File("employees.txt"));
			for(int i = 0; i < employeeList.size(); i++){
				file.println(employeeList.get(i).toString("save"));
			}
		}catch (FileNotFoundException e){
			System.out.println(e);
		}
	}

	public int login(){
		Scanner input = new Scanner(System.in);
		String username = "";
		String password = "";
		String passwordInput;
		boolean foundUser = false;
		boolean admin = false;
		int toReturn = 3;


		System.out.println("Enter Username: ");
		username = input.nextLine();

		for(int i = 0; i < employeeList.size(); i++){
			if (username.equalsIgnoreCase(employeeList.get(i).getUserName())){
				password = employeeList.get(i).getPassword();
				foundUser = true;
				if (employeeList.get(i).isAdmin() == true){
					admin = true;
				}
			}
		}
		if (foundUser == false){
			System.out.println("No user found");
		}
		else{
			System.out.println("Enter password: ");
			passwordInput = input.next();
			if(passwordInput.equals(password)){
				if (admin == true){
					toReturn = 0;
				}
				else {
					toReturn = 1;
				}
			}
			else{
				System.out.println("Password does not match the username!!");
			}
		}

		return toReturn;

	}

	public void getWaitingList(){
		for (Child child : childList){
			if(child.isWaitingList()){
				System.out.println(child.getFirstName() + " " + child.getLastName() + " " + child.getCpr());
			}
		}
	}

	public void scheduleFeeder(){
	    String[] dayCheck = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
	    try {
            PrintStream schedule = new PrintStream(new File("schedule.txt"));
            for (int i = 1; i <= 52; i++) {
                for (int j = 0; j < 7; j++) {
                    schedule.println(i + "," + dayCheck[j] + "," + "2019" + "," + "early" + "," + "placeholder");
                    schedule.println(i + "," + dayCheck[j] + "," + "2019" + "," + "late" + "," + "placeholder");

                }
            }
        }catch(FileNotFoundException e){System.out.print(e);}
    }


	public void populateSchedule(){
		//make sure the array is empty
		scheduleList.clear();

		try {
			Scanner scan = new Scanner(new File("schedule.txt"));
			do{
				Object[] info = scan.nextLine().split(",");
				scheduleList.add(new Schedule(
					Integer.parseInt(info[0].toString()), //Week number
					info[1].toString(), //Day
					Integer.parseInt(info[2].toString()), //Year
					info[3].toString(), //Early or late
					info[4].toString()	//String with shift info
				));
			}while (scan.hasNextLine());

		}catch (FileNotFoundException e){
			System.out.println("Ingen fil fundet");
		}
	}

    public void saveSchedule(){
        try{
            PrintStream file = new PrintStream(new File("schedule.txt"));
            for(Schedule schedule : scheduleList){
                file.println(schedule.getWeek());
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

	public void changeWeekSchedule(int week){

    }
}