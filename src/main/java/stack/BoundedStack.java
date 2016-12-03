package stack;

import exception.EmptyStackException;
import exception.IllegalCapacityException;
import exception.OverFlowException;
import exception.UnderFlowException;


/**
 * Created by sobngwi on 03/12/2016.
 */
public class BoundedStack implements Stack {

    private int size=0;
    private int capacity;
    private int[] elements;


    public static Stack Make(int capacity) {
        if ( capacity == 0)
            return new ZeroCapacity();
        return new BoundedStack(capacity);
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int getSize() {
        return size;
    }

    public void push(int element) {
        if(size==capacity) throw new OverFlowException();
        elements[size++]= element;
    }

    public int pop() {
        if(isEmpty()) throw new UnderFlowException();
        return elements[--size];
    }

    public int top() {
        if( isEmpty()) throw new EmptyStackException();
        return elements[size -1];
    }

    public Integer find(int element) {

        for (int i=size-1 ; i>=0 ; i--) {
            if( element == elements[i])
                return (size-1)-i ;
        }
        return null;
    }

    private BoundedStack(int capacity) {
        if ( capacity < 0 ) throw new IllegalCapacityException();
        this.capacity=capacity;
        elements = new int[capacity];

    }
}
