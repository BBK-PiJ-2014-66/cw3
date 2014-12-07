import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackImplTest {
	/**
	 * test both the array and linked list version of the stacks to make this
	 * easy create an array.
	 */
	private Stack Stacks[];

	@Before
	public void initialize() {
		// first stack is uses array and the 2nd linkedlist
		Stacks = new Stack[2];
		Stacks[0] = new StackImpl(new ArrayList());
		Stacks[1] = new StackImpl(new LinkedList());
	}

	@Test
	public void testEmptyStackisEmpty() {
		for (int sc = 0; sc < 2; sc++) {
			assertTrue(Stacks[sc].isEmpty());
		}
	}
	
	@Test
	public void testStackSize() {
		for (int sc = 0; sc < 2; sc++) {
			Stacks[sc].push("AA");
			Stacks[sc].push("B");
			Stacks[sc].push("CCC");
			assertFalse(Stacks[sc].isEmpty());
			assertEquals(3,Stacks[sc].size());
		}
	}
	@Test
	public void testTopFromEmpty() {
		for (int sc = 0; sc < 2; sc++) {
			ReturnObject ro = Stacks[sc].top();
			assertTrue(ro.hasError());
			assertEquals(ErrorMessage.EMPTY_STRUCTURE,ro.getError());
		}
	}
	
	@Test
	public void testTopFromFilled() {
		for (int sc = 0; sc < 2; sc++) {
			Stacks[sc].push("AA");
			Stacks[sc].push("B");
			Stacks[sc].push("CCC");
			ReturnObject ro = Stacks[sc].top();
			assertFalse(ro.hasError());
			// stack is last in first out so should get "CCC"
			assertEquals("CCC",ro.getReturnValue());
		}
	}
	@Test
	public void testPopFromFilled() {
		for (int sc = 0; sc < 2; sc++) {
			Stacks[sc].push("A");
			Stacks[sc].push("B");
			ReturnObject ro = Stacks[sc].pop();
			assertFalse(ro.hasError());
			// stack is last in first out so should get "B"
			assertEquals("B",ro.getReturnValue());
			// stack should have one item
			assertEquals(1,Stacks[sc].size());
			assertEquals("A", Stacks[sc].pop().getReturnValue());
			// another pop should give an EMPTRY_STRUCTURE error
			ro = Stacks[sc].pop();
			assertTrue(ro.hasError());
			assertEquals(ErrorMessage.EMPTY_STRUCTURE,ro.getError());
		}
	}
	
	
	

}
