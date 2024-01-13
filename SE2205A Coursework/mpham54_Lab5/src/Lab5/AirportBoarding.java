package Lab5;

import java.util.*;

public class AirportBoarding {
    public static void main(String[] args) {
        myHeader(5);
        Scanner input = new Scanner(System.in);
        //Declaring 3 types of priority queues that will be ordered in ascending order of seat number.
        PriorityQueue<Passenger> priorityQueue1 = new PriorityQueue<>();
        PriorityQueue<Passenger> priorityQueue2 = new PriorityQueue<>();
        PriorityQueue<Passenger> regularQueue = new PriorityQueue<>();
        System.out.println("Airplane Boarding and Disembarking Application\n");

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add Passenger to Boarding Queue");
            System.out.println("2. Display Boarding Queue");
            System.out.println("3. Display Passenger Disembarking Order");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");//Prompting user to enter options they desire.

            int choice = input.nextInt();
            input.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println();
                    int num;
                    while (true) {
                        try {
                            System.out.print("Enter number of passenger on flight:");
                            num = input.nextInt();
                            while (num<0) {
                                System.out.print("Incorrect input! Enter Academic Year (2,3 or 4): ");
                                num = input.nextInt();
                            }
                            break;
                        } catch (InputMismatchException ex) {
                            System.out.print("Incorrect input! ");
                            input.nextLine();
                        } //catching error input from the user
                    }
                    for (int i = 0;i<num;i++){
                        System.out.print("\nEnter passenger name: ");
                        input.nextLine();
                        String passengerName = input.next();
                        Integer passengerSeat;
                        while (true) {
                            try {
                                System.out.print("Enter passenger seat: ");
                                passengerSeat = input.nextInt();
                                while (passengerSeat<0) {
                                    System.out.print("Incorrect input! Enter Academic Year (2,3 or 4): ");
                                    passengerSeat = input.nextInt();
                                }
                                break;
                            } catch (InputMismatchException ex) {
                                System.out.print("Incorrect input! ");
                                input.nextLine();
                            } //catching error input from the user
                        }
                        System.out.println("Select passenger type:");
                        System.out.println("1. Military");
                        System.out.println("2. Family with Young Children");
                        System.out.println("3. Elderly");
                        System.out.println("4. Disabled");
                        System.out.println("5. Regular");
                        System.out.print("Enter passenger type: ");
                    int passengerType = input.nextInt();
                    //input.nextLine(); // Consume the newline character

                    switch (passengerType) {
                        case 1, 2:
                            priorityQueue2.add(new Passenger(passengerName, passengerSeat));
                            System.out.println(passengerName + " added to the 2nd priority boarding queue.");
                            break;
                        case 3,4:
                            priorityQueue1.add(new Passenger(passengerName, passengerSeat));
                            System.out.println(passengerName + " added to the 1st priority boarding queue.");
                            break;
                        case 5:
                            regularQueue.add(new Passenger(passengerName, passengerSeat));
                            System.out.println(passengerName + " added to the regular boarding queue.");
                            break;
                        default:
                            System.out.println("Invalid passenger type. Please enter a valid option.");
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("\nBoarding passengers from Priority Queue 1 needing special assistance:");
                    if (!priorityQueue1.isEmpty()) {
                        for (Passenger index : priorityQueue1) {
                            System.out.println(index);
                        }
                    }else{
                        System.out.println("There are no passengers in Priority Queue 1.");
                    }
                    System.out.println("Boarding passengers from Priority Queue 2:");
                    if (!priorityQueue2.isEmpty()) {
                        for (Passenger index : priorityQueue2) {
                            System.out.println(index);
                        }
                    }else{
                        System.out.println("There are no passengers in Priority Queue 2.");
                    }
                    System.out.println("Boarding passengers from Regular Queue:");
                    if (!regularQueue.isEmpty()) {
                        for (Passenger index : regularQueue) {
                            System.out.println(index);
                        }
                    }else{
                        System.out.println("There are no passengers from regular queue.");
                    }
                    break;

                case 3:
                    System.out.println("\nDisembarking passengers from Priority Queue 2:");
                    while (!priorityQueue2.isEmpty()){
                        Passenger disembarkingPassenger = priorityQueue2.poll();
                        System.out.println(disembarkingPassenger);
                    }
                    System.out.println("Disembarking passengers from Regular Queue:");
                    while(!regularQueue.isEmpty()) {
                        Passenger disembarkingPassenger = regularQueue.poll();
                        System.out.println(disembarkingPassenger);
                    }
                    System.out.println("Disembarking passengers from Priority Queue 1 needing special assistance:");
                    while (!priorityQueue1.isEmpty()){
                        Passenger disembarkingPassenger = priorityQueue1.poll();
                        System.out.println(disembarkingPassenger);
                    }
                    System.out.println("All passengers have disembarked");
                    break;

                case 4:
                    System.out.println("Exiting the application.");
                    myFooter(5);
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
    public static void myHeader(int labNum) {
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise %d\n", labNum);
        System.out.println("Prepared By: Quang Pham");
        System.out.println("Student Number: 251271238");
        System.out.println("Goal of this Exercise: Designing an application for airport staff to help passengers board and disembark from the plane.");
        System.out.println("=======================================================");
    }
    public static void myFooter(int labNum) {
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise %d is successful!\n", labNum);
        System.out.println("Signing off - Quang");
        System.out.println("=======================================================");
    }
}
