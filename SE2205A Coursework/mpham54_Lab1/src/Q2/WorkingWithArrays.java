package Q2;
import java.util.Scanner;
/*
Quang Pham
Student Number: 251271238
Fri, Sep 22, 2023
This program practice working with arrays and conditional statements!
 */
public class WorkingWithArrays {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        myHeader(1,2); //header
        System.out.print("Enter array size: "); //Prompt user to enter array size
        int arraySize = input.nextInt();
        double[] minMax = new double[arraySize]; //creating new array
        int arrayPos = 0;
        while(arraySize > arrayPos){
            System.out.print("Enter value "+ (arrayPos+1) +": ");
            //prompt user to enter values into each position in the array
            minMax[arrayPos++] = input.nextDouble();
        }
        mma5MethodQuang(minMax);
        myFooter(1,2);
    }
    public static void myHeader(int labNum, int questionNum) {
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise %d-Q%d/n", labNum, questionNum);
        System.out.println("Prepared By: Quang Pham");
        System.out.println("Student Number: 251271238");
        System.out.println("Goal of this Exercise: Working with arrays and conditional statements!");
        System.out.println("=======================================================");
    }
    public static void myFooter(int labNum, int questionNum) {
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise %d-Q%d is successful!\n", labNum, questionNum);
        System.out.println("Signing off - Quang");
        System.out.println("=======================================================");
    }
    public static double[] mma5MethodQuang(double[] div5){
        int div5Times = 0;
        double div5Total = 0;
        double[] summary = new double[4];
        summary[3] = 251271238;
        for(int i = 0; i < div5.length; i++) {
            if (div5[i] % 5 == 0) {
                div5Times++;
                div5Total = div5Total + div5[i];
                summary[0] = Math.max(div5[i],summary[0]);
                summary[1] = Math.min(div5[i],summary[1]);
            }//Only allow max and min numbers divisible by 5, their average and my student number into summary array
        }
        summary[2] = div5Total/div5Times;
        if(div5Total == 0){
            System.out.println("\nHere is the result......\n");
            System.out.println("In the array, there was no number ‘divisible by 5’ and hence the average remains 0.00.");
        }
        else{
            System.out.println("\nHere is the result......");
            System.out.println("Found "+div5Times+" numbers that are divisible by 5");
            System.out.printf("The max is %.2f.\n", summary[0]);
            System.out.printf("The min is %.2f.\n", summary[1]);
            System.out.printf("The average of the ‘divisible by 5 numbers’ is %.2f.\n", summary[2]);
            System.out.printf("My student number is %.0f\n", summary[3]);
        }
        return summary;
    }
}