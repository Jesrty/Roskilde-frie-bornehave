public class Kindergarten extends FunctionHandler{
    public static void main(String[] args){
        //checkArraySizes();
        Kindergarten kindergarten = new Kindergarten();
        kindergarten.run();
    }

    public void run(){
        checkArraySizes();
        System.out.println(employeeList.size());
        System.out.println(childList.size());
        /*for(int i = 0; employeeList.size() > i; i++){
            System.out.println(employeeList.size());
        }*/
    }
}