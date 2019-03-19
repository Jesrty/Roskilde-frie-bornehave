import java.util.Scanner;

public class Menu {

	public Menu() {

	    FunctionHandler fh = new FunctionHandler();
	    fh.checkArraySizes();

	    Scanner input = new Scanner(System.in);


	    int loginLvl = fh.login();
        //admin = 0
        //employee = 1
        //ikke login = 3

        if(loginLvl == 3){

        }
        else {
            System.out.println("[1 = Schedule]\n[2 = Children]\n[3 = Employee]");
            String option1 = input.nextLine();
            if (option1.equals("1")) {
                System.out.println("[1 = View Schedule]\n[2 = Edit schedule]");
                String option2 = input.nextLine();

                if (option2.equals("1")) {
                    //Her er der et problem, man skal skrive hvilken uge man vil se men det tager den ikke godt hånd om!!!
                    System.out.println("Type the week number");
                    String week = input.nextLine();
                    fh.viewSchedule(Integer.parseInt(week));
                } else if (option2.equals("2")) {
                    //Her er der et problem, man skal skrive hvilken uge man vil se men det tager den ikke godt hånd om!!!
                    System.out.println("Type the week number");
                    String week = input.nextLine();
                    fh.editSchedule(Integer.parseInt(week));
                } else {
                    System.out.println("You didn't pick a valid number");
                }
            } else if (option1.equals("2")) {
                System.out.println("[1 = Create child]\n[2 = Edit child]\n[3 = View child information]\n[4 = View phone list]\n[5 = View waiting list]");
                String option2 = input.nextLine();

                if (option2.equals("1")) {
                    fh.createChild();
                } else if (option2.equals("2")) {
                    //Her er der et problem, man skal skrive hvilket cpr man vil edit men det tager den ikke godt hånd om!!!
                    System.out.println("Type the CPR of the child");
                    String CRP = input.nextLine();
                    fh.editChild(Integer.parseInt(CRP));
                } else if (option2.equals("3")) {
                    //Her er der et problem, man skal skrive hvilket cpr man vil edit men det tager den ikke godt hånd om!!!
                    System.out.println("Type the CPR of the child");
                    String CRP = input.nextLine();
                    fh.getChildInfo(Integer.parseInt(CRP));
                } else if (option2.equals("4")) {
                    fh.getPhoneList(true);
                } else if (option2.equals("5")) {
                    fh.getWaitingList();
                } else {
                    System.out.println("You didn't pick a valid number");
                }
            } else if (option1.equals("3")) {
                System.out.println("[1 = Create employee]\n[2 = Get employee][3 = View employee phone list]");
                String option2 = input.nextLine();

                if (option2.equals("1")) {
                    fh.createEmployee();
                } else if (option2.equals("2")) {
                    System.out.println("Type id of the employee");
                    String employeeID = input.nextLine();
                    fh.getEmployee(Integer.parseInt(employeeID));
                } else if (option2.equals("3")) {
                    fh.getPhoneList(false);
                } else {
                    System.out.println("You didn't pick a valid number");
                }
            } else {
                System.out.println("You didn't pick a valid number");

            }


        }
	}

}