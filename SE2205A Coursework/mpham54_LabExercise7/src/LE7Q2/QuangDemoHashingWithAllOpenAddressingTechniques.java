package LE7Q2;
import LE7Q1.*;
import static LE7Q1.QuangDemoHashingWithLinearProbing.*  ;

public class QuangDemoHashingWithAllOpenAddressingTechniques {
    public static void main(String[] args){
        myHeader(7,2);
        System.out.println("Let's demonstrate our understanding on all the open addressing techniques...");
        System.out.print("How many data items: ");
        items = input.nextInt();
        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        lf = input.nextDouble();
        tableCapacity = checkPrime((int)(items/lf));
        System.out.printf("The minimum required table capacity would be: %d\n", tableCapacity);
        hashTable = new QuangValueEntry[tableCapacity];
        for(int i  = 0; i < tableCapacity; i++){
            hashTable[i] = new QuangValueEntry();
        } //assigning empty constructor to hashtable;
        Integer[] array = new Integer[] {7, 14, -21, -28, 35};
        System.out.print("The given dataset is: ");
        printArray(array);
        System.out.println();

        //linear probing demonstration
        System.out.println("Let's enter each data item from the above to the hash table: \n");
        System.out.println("Adding data - linear probing resolves collision");
        for (Integer integer : array) {
            addValueLinearProbe(integer);
        }
        printHashTable();
        System.out.println("\n");
        emptyHashTable();

        //quadratic probing demonstration
        System.out.println("Adding data - quadratic probing resolves collision");
        for (Integer integer : array) {
            addValueQuadraticProbe(integer);
        }
        if (lf > 0.5) System.out.println("Probing failed! Use a load factor of 0.5 or less. Goodbye!");
        printHashTable();
        System.out.println("\n");
        emptyHashTable();

        //double-hashing demonstration
        System.out.println("Adding data - double-hashing resolves collision");
        for (Integer integer : array) {
            addValueDoubleHashing(integer);
        }
        System.out.println("The q value for double hashing is: "+thePrimeNumberForSecondHashFunction(hashTable.length));
        printHashTable();
        System.out.println();
        myFooter(7,2);

    }
    public static void addValueQuadraticProbe(Integer key){
        for (int i = 0; i < hashTable.length; i++) {
            int hashIndex = (key.hashCode() + i * i) % hashTable.length; //quadratic hash index for every increment i
            if (hashIndex < 0){
                hashIndex += hashTable.length;
            }
            if (hashTable[hashIndex].getKey() == -1 || hashTable[hashIndex].getKey() == -111) {
                hashTable[hashIndex] = new QuangValueEntry(key);
                return;
            }
        }
    }

    public static void addValueDoubleHashing(Integer key){
    int q = thePrimeNumberForSecondHashFunction(hashTable.length); //finding second function prime
    int primaryHash = Math.abs(key.hashCode() % hashTable.length);
    int secondaryHash = Math.abs(q - (key % q)); //recommended function in slide
        for (int i = 0; i < hashTable.length; i++) {
            int index = (primaryHash + i * secondaryHash) % hashTable.length;
            if (hashTable[index].getKey() == -1 || hashTable[index].getKey() == -111) {//checking if space available/null
                hashTable[index] = new QuangValueEntry(key);
                return;
            }
        }
    }
    public static int thePrimeNumberForSecondHashFunction(int q){
        q--; //reduce value of q would make function search for the prime directly below q incase q is a prime
        int m = q/2;
        for (int i = 3; i <= m; i++) {
            if (q % i == 0) {
                i = 2;
                q--;
                m = q/2;
            }
        }
        return q;

    }
    public static void emptyHashTable(){
        for(int i =0; hashTable.length>i; i++){
            hashTable[i] = new QuangValueEntry();
        } //replacing existing values with new empty constructors
    }
    public static void printArray(Integer[] array){
        String str = "[";
        for(Integer current : array){
            str +=  current + ", ";
        }
        str = str.substring(0,str.length()-2);
        str += "]";
        System.out.print(str);
    }
}
