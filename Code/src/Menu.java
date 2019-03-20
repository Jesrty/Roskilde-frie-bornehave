import java.util.Scanner;

public class Menu {

	public Menu() {
	    Scanner input = new Scanner(System.in);
	    FunctionHandler fh = new FunctionHandler();
	    fh.checkArraySizes();

        while(true) {
            int loginLvl = fh.login();
            //admin = 0
            //employee = 1
            //ikke login = 3

            while(true) {
                if (loginLvl == 3) {
                    break;
                }
                else {
                    System.out.println("[1 = Schedule]\n[2 = Children]\n[3 = Employee]\n[4 = log out]");
                    String option1 = input.nextLine();
                    if (option1.equals("1")) {
                        System.out.println("[1 = View Schedule]\n[2 = Edit schedule]");
                        String option2 = input.nextLine();

                        if (option2.equals("1")) {
                            System.out.println("Type the week number");
                            String week = input.nextLine();
                            try {
                                if(Integer.parseInt(week)<=52 && Integer.parseInt(week)>=1) {
                                    fh.viewSchedule(Integer.parseInt(week));
                                }
                                else{
                                    System.out.println("Pick a week between 1 and 52");
                                }
                            }
                            catch(NumberFormatException e){
                                System.out.println("Pick a number please");
                            }
                        }

                        else if (option2.equals("2") && loginLvl == 0) {
                            System.out.println("Type the week number");
                            String week = input.nextLine();
                            try{
                                if(Integer.parseInt(week)<=52 && Integer.parseInt(week)>=1) {
                                    fh.editSchedule(Integer.parseInt(week));
                                }
                                else{
                                    System.out.println("Pick a week between 1 and 52");
                                }
                            }
                            catch(NumberFormatException e){
                                System.out.println("Pick a number please");
                            }
                        }

                        else {
                            System.out.println("You didn't pick a valid number or you don't have access");
                        }
                    }
                    else if (option1.equals("2")) {
                        System.out.println("[1 = Create child]\n[2 = Edit child]\n[3 = View child information]\n[4 = View phone list]\n[5 = View waiting list]");
                        String option2 = input.nextLine();

                        if (option2.equals("1") && loginLvl == 0) {
                            fh.createChild();
                        }
                        else if (option2.equals("2") && loginLvl == 0) {
                            System.out.println("Type the CPR of the child");
                            String CRP = input.nextLine();
                            try{
                                fh.editChild(Integer.parseInt(CRP));
                            }
                            catch(NumberFormatException e){
                                System.out.println("Pick a number please");
                            }
                        }
                        else if (option2.equals("3")) {
                            System.out.println("Type the CPR of the child");
                            String CRP = input.nextLine();
                            try{
                                fh.getChildInfo(Integer.parseInt(CRP));
                            }
                            catch(NumberFormatException e){
                                System.out.println("Pick a number please");
                            }
                        }
                        else if (option2.equals("4")) {
                            fh.getPhoneList(true);
                        }
                        else if (option2.equals("5") && loginLvl == 0) {
                            fh.getWaitingList();
                        }
                        else {
                            System.out.println("You didn't pick a valid number or you don't have access");
                        }
                    }
                    else if (option1.equals("3")) {
                        System.out.println("[1 = Create employee]\n[2 = Edit employee]\n[3 = View employee phone list]");
                        String option2 = input.nextLine();

                        if (option2.equals("1") && loginLvl == 0) {
                            fh.createEmployee();
                        }
                        else if (option2.equals("2") && loginLvl == 0) {
                            System.out.println("Type id of the employee");
                            String employeeID = input.nextLine();
                            fh.editEmployee(Integer.parseInt(employeeID));
                        }
                        else if (option2.equals("3")) {
                            fh.getPhoneList(false);
                        }
                        else {
                            System.out.println("You didn't pick a valid number or you don't have access");
                        }
                    }
                    else if(option1.equals("4")){
                        System.out.println("You are logged out");
                        break;
                    }
                    else {
                        System.out.println("You didn't pick a valid number or you don't have access");
                    }
                }
            }
        }
	}
}
