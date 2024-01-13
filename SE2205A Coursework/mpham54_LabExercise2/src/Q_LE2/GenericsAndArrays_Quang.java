package Q_LE2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GenericsAndArrays_Quang {

    public static void main(String[]args){
        myHeader(2,1);

        ArrayList<Integer> studentYear = new ArrayList<>(Arrays.asList(2, 3, 4, 3, 2, 2));
        ArrayList<String> studentName = new ArrayList<>(Arrays.asList("Harry","Lavender", "Ron", "Hermione","Luna","Vincent"));
        Pair<Integer, String>[] studentPairArray = new Pair[studentName.size()];
        // initializing pair reference class array
        for (int i = 0; i < studentName.size(); i++) {
            studentPairArray[i] = new Pair<>(studentYear.get(i), studentName.get(i));
        } //Filling studentPairArray with studentYear and studentName data

        System.out.println("This program prints the names of the student leaders from year 2, 3 and 4.\n" +
                "To see the list of the students from a specific year enter an integer between 2 and 4 when\n" +
                "prompted.\n");
        while(true) { //repeat whole method unless condition is not met
            int n;
            while (true) {
                try {
                    System.out.print("Enter Academic Year (2, 3 or 4): ");
                    n = input.nextInt();
                    while (n > 4 || n < 2) {
                        System.out.print("Incorrect input! Enter Academic Year (2,3 or 4): ");
                        n = input.nextInt();
                    }
                    break;
                } catch (InputMismatchException ex) {
                    System.out.print("Incorrect input! ");
                    input.nextLine();
                } //catching error input from the user
            }
            Integer check = n;
            int numOfStudent = 0;
            ArrayList<String> studentInfo = new ArrayList<>();
            //initializing new array to pull student info from studentPairArray
            for (Pair<Integer, String> pair : studentPairArray) {
                if (pair.getKey() == check) {
                    studentInfo.add(pair.getValue());
                    numOfStudent++;
                } //checking if information is correct before adding to studentInfo
            }
            System.out.printf("Found %d leader(s) from year %d.\n", numOfStudent, n);
            System.out.println("Here is the list:");
            System.out.print("[");
            for (int i = 0; i < studentInfo.size(); i++) {
                System.out.print(studentInfo.get(i));
                if(i< studentInfo.size()-1) {
                    System.out.print(", ");
                } //printing information
            }
            System.out.println("]");
            System.out.print("Do you wish to continue? (Press y to continue or any other key to terminate): ");
            input.nextLine();
            String ans = input.nextLine();
            if(!ans.equals("y")){
                break;
            } //condition to stop program
        }
        myFooter(2,1);
    }
    public static void myHeader(int labNum, int questionNum) {
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise %d-Q%d\n", labNum, questionNum);
        System.out.println("Prepared By: Quang Pham");
        System.out.println("Student Number: 251271238");
        System.out.println("Goal of this Exercise: Storing student leader data using ArrayList class.");
        System.out.println("=======================================================");
    }
    public static void myFooter(int labNum, int questionNum) {
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise %d-Q%d is successful!\n", labNum, questionNum);
        System.out.println("Signing off - Quang");
        System.out.println("=======================================================");
    }
    public static Scanner input = new Scanner(System.in);
}
