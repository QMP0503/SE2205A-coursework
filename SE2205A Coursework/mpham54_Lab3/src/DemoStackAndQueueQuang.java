import java.util.Scanner;
public class DemoStackAndQueueQuang {
    public static void main(String[] args) {
        myHeader(3); // calling header method
        System.out.println("\nThis code performs a demo for Stack and Queue:\n");
        while (true) {
            System.out.println("Main Demo-Menu:");
            System.out.println("\t1: Stack\n\t2: Queue\n\t3: Exit");
            System.out.print("\tEnter your choice: "); // prompt user to input from listed choices
            String choice = input.nextLine();
            switch (choice) {
                case "1": // 1: Stack
                    QuangArray stack = new QuangArray(); // declaring reference variable stack
                    System.out.println("\nYou have an empty stack: []");
                    stackDemo(stack); // call stackDemo method
                    break;
                case "2": //2: Queue
                    QuangArray queue = new QuangArray(); // declaring reference variable queue
                    System.out.println("\nYou have an empty queue: []");
                    queueDemo(queue); // call queueDemo method
                    break;
                case "3": // 3: Exit
                    System.out.println("Goodbye!\n");
                    myFooter(3);
                    return; // return nothing, exiting code
                default:
                    System.out.println("Invalid choice!\n"); //display when user input option not in menu then try again
            }
        }
    }
    public static void stackDemo(QuangArray stack) {
        while (true) {
            System.out.println("\nStack Operation Menu:"); // displaying options in stack menu
            System.out.println("a: Push\nb: Pop\nc: Exit");
            System.out.print("Enter your choice: ");
            String choice = input.next().toLowerCase();

            switch (choice) {
                case "a": // a: Push (adding element to end/top of stack)
                    System.out.println("Let's push a data-item into the stack....");
                    // prompt user to enter year and name
                    System.out.print("Enter year: ");
                    int year = input.nextInt();
                    System.out.print("Enter name: ");
                    String name = input.next();
                    stack.addAtLastIndex(new Pair<>(year, name));
                    System.out.println("The current stack: " + stack.toString());
                    break;
                case "b": // b: Pop (removing element from end/top of stack)
                    System.out.println("Let's pop a data-item ....");
                    try {
                        Pair<?,?> popped = stack.removeFromLastIndex();
                        System.out.println(popped.toString() + "is removed! The current stack: " + stack.toString());
                    } catch (IllegalStateException e) { // catch exception when stack is empty
                        System.out.println("FYI: The stack is empty");
                    }
                    break;
                case "c": // c: Exit
                    System.out.println("Ending Queue-demo! Goodbye!\n");
                    return; // exiting queue demo and returning to main demo menu
                default:
                    System.out.println("Invalid choice!"); //reminding user of invalid choice then prompt user to try again
            }
        }
    }
    public static void queueDemo(QuangArray queue) {
        while (true) {
            System.out.println("\nQueue Operation Menu:"); //displaying option in queue menu
            System.out.println("a: Enqueue\nb: Dequeue\nc: Exit");
            System.out.print("Enter your choice: ");//prompt user to pick choice in queue demo menu
            String choice = input.next().toLowerCase();
            switch (choice){
                case "a": // a: Enqueue (add data to last index position in queue array)
                    System.out.println("Let's enqueue a data-item in the queue.... ");
                    System.out.print("Enter year: "); //prompt user to enter year and name
                    int year = input.nextInt();
                    System.out.print("Enter name: ");
                    String name = input.next();
                    queue.addAtLastIndex(new Pair<>(year,name));//add user info into last index of queue array
                    System.out.println("The current queue: " + queue.toString()); //display current array
                    break;
                case "b": // b: Dequeue (remove data from first index position in queue array)
                    try{
                        System.out.println("Let's dequeue a data-item .... ");
                        Pair<?,?> dequeued = queue.removeFromFirstIndex();
                        System.out.println(dequeued+" is dequeued! The current queue: "+ queue.toString());
                        //display removed array and new array
                    } catch (IllegalStateException e) { // catch exception when array is empty
                        System.out.println("FYI: The queue is empty");
                    }
                    break;
                case "c": // c: exit
                    System.out.println("Ending Stack-demo! Goodbye!\n");
                    return; //exit queue demo and return to main demo menu
                default:
                    System.out.println("Invalid choice!"); //spot invalid option outside of menu
            }
        }
    }
    public static void myHeader(int labNum) {
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise %d\n", labNum);
        System.out.println("Prepared By: Quang Pham");
        System.out.println("Student Number: 251271238");
        System.out.println("Goal of this Exercise: Demo for stack and queue in memory");
        System.out.println("=======================================================");
    }
    public static void myFooter(int labNum) {
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise %d is successful!\n", labNum);
        System.out.println("Signing off - Quang");
        System.out.println("=======================================================");
    }
    public static Scanner input = new Scanner(System.in);
}
