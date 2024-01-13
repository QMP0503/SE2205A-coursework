package L4Q2;

import java.util.ArrayList;
import java.util.Collections;

public class DriverForStudentClass {
    public static void  main(String[] args){
        myHeader(new Student(),4,2);
        ArrayList<Student> studentArrayList = new ArrayList<>();
        //initializing new studentArrayList ArrayList/
        studentArrayList.add(new Student());
        studentArrayList.add(new Student("Harry","Potter",75.5));
        studentArrayList.add(new Student("Ronald", "Weasley", 86.0));
        studentArrayList.add(new Student("Hermione","Granger",91.7));
        studentArrayList.add(new Student("Parvati", "Patil", 93.75));
        //Adding student type data into array list
        System.out.println("The Score Card:");
        for(Student index: studentArrayList){
            System.out.println("\t"+index);
        }//printing all elements in array by insertion order
        System.out.println("\nThe sorted list in terms of score in descending order....");
        Collections.sort(studentArrayList, Collections.reverseOrder());
        for(Student index: studentArrayList){
            System.out.println("\t"+index);
        }//printing all elements in array following descending order of scores.
        System.out.println("\nThe sorted list in terms of Last Names....");
        Collections.sort(studentArrayList,new HelperClassComparePham());
        for(Student index: studentArrayList){
            System.out.println("\t"+index);
        }//printing all elements in array following descending order of last names.
        System.out.println("\nThe sorted list in terms of First Names....");
        Collections.sort(studentArrayList, new HelperClassCompareQuang());
        for (Student index: studentArrayList){
            System.out.println("\t"+index);
        }//printing all elements in array following descending order of first names.
        System.out.println();
        myFooter(4,2);
    }
    public static void myHeader(Student myInfo, int labE_number, int q_number) {
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise %d-Q%d\n", labE_number,q_number);
        System.out.printf("Prepared By: %s %s\n", myInfo.getFirstName(), myInfo.getLastName());
        System.out.println("Student Number: 251271238");
        System.out.println("Goal of this Exercise: Demonstrate how to implement generic method compareTo from comparator interface");
        System.out.println("=======================================================");
    }
    public static void myFooter(int labE_number, int q_number) {
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise %d-Q%d is successful!\n", labE_number,q_number);
        System.out.println("Signing off - Quang");
        System.out.println("=======================================================");
    }
}
