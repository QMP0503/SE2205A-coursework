package LE7Q1;

import java.util.Scanner;

public class QuangDemoHashingWithLinearProbing {
    public static int items;
    public static Scanner input = new Scanner(System.in);
    public static double lf; //load factor
    public static int tableCapacity;
    public static QuangValueEntry[] hashTable;
    public static QuangValueEntry[] workingHashTable;
    public static void main(String[] args){
        myHeader(7,1);
        System.out.println("Let's decide on the initial table capacity based on the load factor and dataset size");
        System.out.print("How many data items: ");
        items = input.nextInt();
        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        lf = input.nextDouble();
        tableCapacity = checkPrime((int)(items/lf));
        System.out.printf("The minimum required table capacity would be: %d\n", tableCapacity);
        hashTable = new QuangValueEntry[tableCapacity];
        for(int i  = 0; i < tableCapacity; i++){
            hashTable[i] = new QuangValueEntry();
        }//to avoid nullPointerException by adding emptying QuangValueEntry constructor to each index
        for(int i=1; items>=i; i++){
            System.out.printf("Enter item %d: ",i);
            Integer itemKey = input.nextInt();
            addValueLinearProbe(itemKey);
        }
        printHashTable();
        System.out.println();
        System.out.println("\nLet’s remove two values from the table and then add one……\n");
        System.out.print("Enter a value you want to remove: ");
        removeValueLinearProbe(input.nextInt());
        printHashTable();
        System.out.print("\nEnter a value you want to remove: ");
        removeValueLinearProbe(input.nextInt());
        printHashTable();
        System.out.print("\nEnter a value to add to the table:");
        addValueLinearProbe(input.nextInt());
        printHashTable();
        System.out.println("\n\nRehashing the table...");
        rehashingWithLinearProbe();
        System.out.printf("The rehashed table capacity is: %d",tableCapacity);
        System.out.println();
        printHashTable();
        System.out.println();
        myFooter(7,1);
    }
    public static void addValueLinearProbe(Integer key){
        int hashIndex = key.hashCode() % hashTable.length; //hash code index
        if(hashIndex<0){ //checking if hashIndex is negative number
            hashIndex=hashTable.length+hashIndex;
        }
        while (hashTable[hashIndex].getKey() != -1 && hashTable[hashIndex].getKey() != -111) {
            hashIndex++;
            if (hashIndex > hashTable.length - 1) {
                hashIndex = 0;
            }
        }
        hashTable[hashIndex] = new QuangValueEntry(key);
    }
    public static void rehashingWithLinearProbe(){
        tableCapacity = checkPrime(2*tableCapacity); //doubling capacity when load factor is reached
        workingHashTable = hashTable;
        hashTable = new QuangValueEntry[tableCapacity];
        for(int i = 0; i < hashTable.length; i++){
            hashTable[i] = new QuangValueEntry();
        }

        for(int i = 0; i < workingHashTable.length; i++){
            if(workingHashTable[i].getKey() != -1 && workingHashTable[i].getKey() != -111){
                addValueLinearProbe(workingHashTable[i].getKey());
            }
        }
    }
    public static int checkPrime(int n) {
        int m = n / 2;//we just need to check half of the n factors
        for (int i = 3; i <= m; i++) {
            if (n % i == 0) {
                i = 2;

                n++;//next n value
                m = n / 2;
            }
        }
        return n;
    }//end of checkPrime()

    public static void removeValueLinearProbe(Integer key) {
        int hashIndex = key % hashTable.length;
        if (hashIndex < 0) {
            hashIndex += tableCapacity;
        }
        while (true) {
            if (hashTable[hashIndex].getKey() == -1 || hashTable[hashIndex].getKey() == -111) {
                System.out.printf("%d is not found! ", key);
                break;
            } else if (hashTable[hashIndex].getKey() == key) {
                hashTable[hashIndex].setKey(-111);
                System.out.printf("%d is Found and removed! ", key);
                break;
            } else if (hashTable[hashIndex].getKey() != key) {
                if (hashIndex + 1 >= hashTable.length) {
                    hashIndex = 0;
                } else {
                    hashIndex++;
                }
            } else {
                System.out.printf("%d is not found! ", key);
                break;
            }
        }
    }
    public static void printHashTable(){
        String str = "[";
        for(QuangValueEntry current : hashTable){
            str += current + ", ";

        }
        str = str.substring(0,str.length()-2);
        str += "]";
        System.out.print("The Current Hash-Table: " + str);
    }

    public static void myHeader(int labNum, int qNum) {
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise %d, Q%d\n", labNum,qNum);
        System.out.println("Prepared By: Quang Pham");
        System.out.println("Student Number: 251271238");
        System.out.println("Goal of this Exercise: Demonstrate Hash table with linear addressing.");
        System.out.println("=======================================================");
    }
    public static void myFooter(int labNum,int qNum) {
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise %d, Q%d is successful!\n", labNum,qNum);
        System.out.println("Signing off - Quang");
        System.out.println("=======================================================");
    }



}
