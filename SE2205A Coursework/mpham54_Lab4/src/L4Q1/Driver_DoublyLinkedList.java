package L4Q1;

public class Driver_DoublyLinkedList {
    public static void main(String[] args){
        myHeader(4,1);
        //Instantiating new DoublyLinked list that stores MyStudent objects
        DoublyLinkedList<MyStudent> quangList = new DoublyLinkedList<MyStudent>();

        //Adding required information
        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry", 67.35);
        MyStudent s2 = new MyStudent("Luna", 87.5);
        MyStudent s3 = new MyStudent("Vincent", 60.5);
        MyStudent s4 = new MyStudent("Hermione", 89.2);

        //Adds info into nodes in order
        quangList.addLast(s0);
        quangList.addLast(s1);
        quangList.addLast(s2);
        quangList.addLast(s3);

        //Attempting to add s4 info between s2 and s3
        System.out.println("Adding 4 students to the list.");
        System.out.println("The list Content:");
        System.out.println(quangList);

        //finding location of node storing s2 and s3
        DoublyLinkedList.Node<MyStudent> nodeS2 = quangList.findNode(s2);
        DoublyLinkedList.Node<MyStudent> nodeS3 = quangList.findNode(s3);

        //Uses addBetween method in DoublyLinkedList and displaying array
        quangList.addBetween(s4,nodeS2,nodeS3);
        System.out.printf("Adding %s to the list in between %s and %s.....\n",s4.getFirstName(),s2.getFirstName(),s3.getFirstName());
        System.out.println("The list Content:");
        System.out.println(quangList);
        myFooter(4,1);
    }
    //Header function
    public static void myHeader(int labE_number, int q_number) {
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise %d-Q%d\n", labE_number,q_number);
        System.out.println("Prepared By: Quang Pham");
        System.out.println("Student Number: 251271238");
        System.out.println("Goal of this Exercise: Understanding DoublyLinked lists and nodes.");
        System.out.println("=======================================================");
    }
    //Footer function
    public static void myFooter(int labE_number, int q_number) {
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise %d-Q%d is successful!\n", labE_number,q_number);
        System.out.println("Signing off - Quang");
        System.out.println("=======================================================");
    }
}