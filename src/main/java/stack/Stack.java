package stack;

/**
 * Created by sobngwi on 03/12/2016.
 */
public interface Stack {
    boolean isEmpty();

    int getSize();

    void push(int element);

    int pop();

    int top();

    Integer find(int i);
}
