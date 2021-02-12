import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * A class that represents the Stack ADT
 **/
public class Stack<T> {
    private T[] stackArray;
    private int top;

    public static int INIT_CAPACITY = 10;

    // Constructor - creates a stack with an initial capacity
    // of INIT_CAPACITY
    @SuppressWarnings("unchecked")
    public Stack() {
        stackArray = (T[]) new Object[INIT_CAPACITY];
        top = -1;
    }

    public void push(T item){
        if (isFull())
            expandArray();
        top++;
        stackArray[top] = item;
    }


    public T top() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("Cannot examine top of an empty stack.");
        return stackArray[top];
    }

    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Cannot pop from an empty stack.");

        return stackArray[top--];  // ALSO CORRECT

    /* Alternate approaches
    CORRECT
    T itemToReturn = stackArray[top];
    stackArray[top] = null; -- was not technically required, garbage collection takes place
    top--;
    return itemToReturn;
    */
    
    /* NOT CORRECT -- DOES NOT WORK
    return stackArray[top];
    top--;
    */
    
    /* NOT CORRECT -- DOES NOT WORK
    return stackArray[--top]
    */
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    private boolean isFull() {
        return (top == stackArray.length-1);
    }

    @SuppressWarnings("unchecked")
    private void expandArray(){
        System.out.println("Expanding array");
        int newCapacity = stackArray.length*2;

        T[] newStackArray = (T[]) new Object[newCapacity];
        for (int i=0; i<=top; i++){
            newStackArray[i] = stackArray[i];
        }
        stackArray = newStackArray;
    }

}