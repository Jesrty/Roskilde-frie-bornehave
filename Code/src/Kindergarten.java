import java.util.Arrays;

public class Kindergarten extends FunctionHandler{
    public static void main(String[] args){

        //checkArraySizes();
        Kindergarten kindergarten = new Kindergarten();
        kindergarten.run();
        Menu m = new Menu();
    }

    public void run() {
        checkArraySizes();


        System.out.println(childList.size());
        //getChildInfo(20122011);
        //createChild();

        for(int i = 0; i < childList.size(); i++){
            System.out.println(Arrays.toString(childList.get(i).toString("save").split(",")));
        }
        System.out.println(childList.size());
        for(int i = 0; employeeList.size() > i; i++){
            //System.out.println(employeeList.get(i).getUserName());
        }

    }
}