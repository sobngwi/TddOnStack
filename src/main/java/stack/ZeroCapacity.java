package stack;

import exception.EmptyStackException;
import exception.OverFlowException;
import exception.UnderFlowException;


/**
 * Created by sobngwi on 03/12/2016.
 */
class ZeroCapacity implements Stack {

    public boolean isEmpty() {
        return false;
    }

    public int getSize() {
        return 0;
    }

    public void push(int element) {
        throw new OverFlowException();
    }

    public int pop() {
        throw new UnderFlowException();
    }

    public int top() {
       throw new EmptyStackException();
    }

    public Integer find(int i) {
        return -1;
    }
}
