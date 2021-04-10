package chapter13;

public class Division {

    public static void divide(){ //Practice problem in 13b
        try{
            int c = 30/0;
        }catch(ArithmeticException e){
            e.printStackTrace();
        }finally{
            System.out.println("Division is fun");
        }
    }
}
