import exception.EmptyStackException;
import exception.OverFlowException;
import exception.UnderFlowException;
import stack.BoundedStack;
import exception.IllegalCapacityException;
import org.junit.Before;
import org.junit.Test;
import stack.*;



import static org.junit.Assert.*;

/**
 * Created by sobngwi on 03/12/2016.
 */
public class StackTest {

    private Stack stack ;

    @Before
    public void setUp(){
        stack = BoundedStack.Make(2);
    }

    @Test
    public void newly_created_stack_should_be_empty() throws Exception {

        assertTrue(stack.isEmpty());
        assertTrue(stack.getSize() == 0);
        assertEquals(0, stack.getSize());
    }

    @Test
    public void after_onePush_size_should_be_one() throws Exception {
        stack.push(1);
        assertEquals(1, stack.getSize());
        assertFalse(stack.isEmpty());

    }

    @Test
    public void after_one_push_and_pop_size_should_be_empty_again() throws Exception {
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());

    }

    @Test(expected= OverFlowException.class)
    public void over_flow_size_shoud_generate_an_exception() throws Exception {
        stack.push(1);
        stack.push(1);
        stack.push(1);
    }

    @Test(expected= UnderFlowException.class)
    public void under_flow_size_shoud_generate_an_exception() throws Exception {
        stack.pop();
    }

    @Test
    public void when_one_is_push_one_should_be_pop() throws Exception {
        stack.push(1);
        assertTrue(1==stack.pop());
    }

    @Test
    public void when_push_one_and_two_you_should_pop_two_and_one() throws Exception {
        stack.push(1);
        stack.push(2);
        assertTrue(2==stack.pop());
        assertTrue(1==stack.pop());

    }

    @Test(expected = IllegalCapacityException.class)
    public void stack_with_negative_quantity_should_generate_an_exception() throws Exception {
        stack = BoundedStack.Make(-10);
    }

    @Test(expected= OverFlowException.class)
    public void create_stack_with_zero_capacity_any_push_generate_an_overflow() throws Exception {
        stack = BoundedStack.Make(0);
        stack.push(1);

    }

    @Test
    public void when_one_is_push_one_should_be_at_the_top() throws Exception {
        stack.push(3);
        stack.push(1);
        assertTrue(1== stack.top());
        assertEquals(1, stack.pop());

    }

    @Test(expected = EmptyStackException.class)
    public void when_stack_is_empty_should_throws_an_exception() throws Exception {
        stack.top();

    }

    @Test(expected = EmptyStackException.class)
    public void with_zero_capacity_stack_any_pop_throws_an_exception() throws Exception {
            stack = BoundedStack.Make(0);
            stack.top();
    }

    @Test
    public void should_find_the_rigth_index() throws Exception {
        stack.push(100);
        stack.push(200);

        assertTrue(1 == stack.find(100));
        assertTrue(0 == stack.find(200));
        assertSame(1, stack.find(100));
        assertSame(0, stack.find(200));

    }

    @Test
    public void find_an_non_existing_value_should_return_null() throws Exception {
        assertNull(stack.find(100));
    }
}
