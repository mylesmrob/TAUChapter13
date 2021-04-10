package chapter13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {
        createNewFile();
        numbersExceptionHandling();
        //createNewFileRethrow(); //Throws Exception could be added to main to allow this to function
        Division.divide();
    }

    public static void createNewFile(){
        File file = new File("resources/nonexistent.txt");
        try{
            file.createNewFile();
        }catch(IOException e){ //Exception e would also work, but is more broad
            System.out.println("Directory is nonexistent");
            e.printStackTrace();
        }
    }

    public static void createNewFileRethrow() throws IOException{
        File file = new File("resources/nonexistent.txt");
        file.createNewFile();
    }

    public static void numbersExceptionHandling(){
        File file = new File("resources/numbers.txt");
        try(Scanner fileReader = new Scanner(file)){ //Scanner is a resource and can be defined in try
            while(fileReader.hasNext()){
                double number = fileReader.nextDouble();
                System.out.println(number);
            }
        }catch(FileNotFoundException | InputMismatchException e){ //Two catch blocks can be put into one through pipe
            e.printStackTrace();
        }/*finally{ //Will execute whether or not an exception is thrown
            fileReader.close();
        }*/
    }
}
