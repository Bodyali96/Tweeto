package tweeto;
// The documentation:

import java.util.Arrays;

/**
 * Hello, in this class we want to store Tweeto objects inside an array.
 * This implementation is to represent the "Heap" concept.
 * The methods below are for storing each Tweeto object in it's right position.
 * As known about binary heap, you DO NOT store the data randomly or sort them!
 * There are certain formulas for storing the parent, the left child, and the right child.
 * For example, we will assume that A is a parent who has two children, X on left, and Y on right.
 * To get the proper index for the left child X : (index of A) * 2 +1
 * To get the proper index for the right child Y : (index of A) * 2 +2
 * To get the proper index for the Parent A : ( (index X or Y) - 1 ) / 2
 * This implementation will represent the Max binary heap, which means :
 * The root is the largest node in the tree, and the children are always smaller than the parent
 * =====================================================================
 * For now, we will just assume that we store Tweeto objects that just start with the same letter,
 * and another class will be created later to handle all the possible letters.
 */
// Written by : Abdulrahman Ali.


public class TweetoBH {

    // capacity shows the maximum Tweeto objects you can store in this array.
    // while size shows the current number of Tweeto objects have been stored.

    public int getCapacity() {
        return capacity;
    }

    private int capacity;
    private int size;

    //The array that will store all Tweeto objects start with the same letter.

    private Tweeto[] items = new Tweeto[getCapacity()];

    // a default constructor
    public TweetoBH(String fileName) {
        // to initialize the capacity, we recive the name of the txt file,
        // and parse the part from beginning until the dot, for exapmle:
        // 1000.txt will make the capacity 1000
        try {
            this.capacity = Integer.parseInt(fileName.substring(0, fileName.indexOf(".")));
            size = 0;
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }


    // as explained in the documentation, these methods are just to get
    // the position of the object in the array

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    // Logical methods to check if there is a child or a parent for a specific Tweeto object or not.
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    //Methods to return the object itself stored in some position in the array
    private Tweeto leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private Tweeto righttChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private Tweeto parent(int index) {
        return items[getParentIndex(index)];
    }

    //just a normal method to swap the elements inside an array
    public void swap(int indexOne, int indexTwo) {
        Tweeto temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    // a simple method to return the first element in the array,
    // and throws an exception if the array is empty
    public Tweeto peek() {
        if (size == 0)
            throw new IllegalArgumentException();
        return items[0];
    }

    public void insert(Tweeto obj) {
        if (size == capacity)
            throw new ArrayIndexOutOfBoundsException("You can not insert elements any more");
        items[size] = obj;
        size++;
        heapyfiUp();
    }

    public void heapyfiUp() { // swim
        int index = size-1;
        while(hasParent(index) && ( parent(index).compareTo( items[index] ) < 0 ) ){
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }
    public void heapyfiDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int largerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && righttChild(index).compareTo( leftChild(index) ) > 0)
                largerChildIndex = getRightChildIndex(index);
            if(items[index].compareTo( items[largerChildIndex] ) > 0 )
                break;
            else
                swap(index,largerChildIndex);
            index = largerChildIndex;
        }
    }

}
