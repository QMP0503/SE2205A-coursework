import java.util.Arrays;
import java.util.StringJoiner;

public class QuangArray {
    private Pair<?,?>[] testArray; //<?,?> allow for parameter to be any type.
    public QuangArray(){//constructor
        this.testArray = new Pair<?,?>[0];
    }
    public Pair<?, ?> removeFromLastIndex() {//remove element from last index (popping)
        if (testArray.length == 0) { //checking if array is empty
            throw new IllegalStateException("You have an empty stack: []");
        }
        Pair<?, ?> popped = testArray[testArray.length - 1]; // reduce size of array by 1
        Pair<?, ?>[] newArray = new Pair<?, ?>[testArray.length - 1]; // create new array with new size
        System.arraycopy(testArray, 0, newArray, 0, newArray.length); // copy elements from testArray to newArray
        testArray = newArray;
        newArray = null;
        return popped;
    }

    public Pair<?,?> removeFromFirstIndex() { //remove element from first index position (dequeue)
        if (testArray.length == 0) { // checking if array is empty
            throw new IllegalStateException("You have an empty queue: []");
        }
        Pair<?,?> dequeue = testArray[0];
        Pair<?,?>[] newArray = new Pair[testArray.length-1];
        System.arraycopy(testArray, 1, newArray, 0, newArray.length); // copy elements starting from index 1, leave element at index 0 behind
        testArray = newArray;
        return dequeue;
    }
    //display the resulting stack or queue within
    @Override
    public String toString() {
        return Arrays.toString(testArray);
        // StringJoiner object to build strings with consistent formatting of elements instead of writing a loop
        /*StringJoiner joiner = new StringJoiner("", "[", "]");
        for (Pair<?,?> item: testArray) {
            joiner.add(item.toString());
        }
        return joiner.toString();*/ // converting joiner to regular String to return concatenated string
    }
    public void addAtLastIndex(Pair<?,?> push) {//add element to last index
        Pair<?,?>[] newArray = new Pair<?,?>[testArray.length+1]; // increase size of array by 1
        System.arraycopy(testArray, 0, newArray, 0, testArray.length); // copying elements from testArray to newArray
        newArray[testArray.length] = push;
        testArray = newArray;
        newArray = null;
    }
}
