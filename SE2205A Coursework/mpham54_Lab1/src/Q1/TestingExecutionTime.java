package Q1;
import java.util.Scanner;
/*
Quang Pham
Student Number: 251271238
Fri, Sep 22, 2023
This program check code execution time
 */
public class TestingExecutionTime {
    public static void main(String[] args){
        myHeader(1,1);
        System.out.print("Enter a integer number: ");
        int n = input.nextInt();
        while(n<0){
            System.out.println("Integer is not greater than 0.");
            System.out.print("Enter a integer number: ");
            n = input.nextInt();
        } //check if input is greater than 0
        double mainTime = System.nanoTime();//Gets initial time
        //does a factorial calculation in main
        double mainFactorial = 1;
        for (int i = 1; i <= n; i++) {
            mainFactorial *= i;
        }
        //displays the factorial result and runtime of method in main
        System.out.printf("Factorial (%d) is %.0e\n", n, mainFactorial);
        System.out.printf("Time taken by Iterative solution inside main: %.2e\n", (System.nanoTime() - mainTime)/100000000);

        //displays the result and runtime of the interative method
        double interTime = System.nanoTime();
        System.out.printf("Factorial (%d) with iterative call is: %.0e\n", n, interativeMethodForFactorial(n));
        System.out.printf("Time taken by Iterative method call: %.2e\n", (System.nanoTime() - interTime)/100000000);

        //displays the result and runtime of the recursive method
        double recurTime = System.nanoTime();
        System.out.printf("Factorial (%d) with recursive call is: %.0e\n", n, recursiveMethodFactorial(n));
        System.out.printf("Time taken by recursive method call: %.2e\n", (System.nanoTime() - recurTime)/100000000);
        myFooter(1,1);
    }
    public static double interativeMethodForFactorial(int n){
        double factorial=1;
        //Need more storage for large factorials thus need to use double.
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
    public static double recursiveMethodFactorial(int n){
        if(n==0){
            return 1;
        }
        else{
            return n*recursiveMethodFactorial(n-1);
        }
    }
    public static void myHeader(int labNum, int questionNum) {
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise %d-Q%d/n", labNum, questionNum);
        System.out.println("Prepared By: Quang Pham");
        System.out.println("Student Number: 251271238");
        System.out.println("Goal of this Exercise: Checking the code-execution time");
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
