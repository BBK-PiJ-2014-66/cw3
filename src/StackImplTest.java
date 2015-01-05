import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackImplTest {
	/**
	 * Test all three implementation of the array and linked list version of the
	 * stacks. To make this easy create an array.
	 */
	private Stack Stacks[];
	private static int NSTACKS = 3;
	private static String[] DESCRIBEIMPL = { "ArrayList", "LinkedList",
			"ImprovedStackImpl" };

	@Before
	public void initialize() {
		// first stack uses arrayList and the 2nd linkedlist
		Stacks = new Stack[NSTACKS];
		Stacks[0] = new StackImpl(new ArrayList());
		Stacks[1] = new StackImpl(new LinkedList());
		Stacks[2] = new ImprovedStackImpl();
	}

	@Test
	public void testEmptyStackisEmpty() {
		for (int sc = 0; sc < NSTACKS; sc++) {
			assertTrue(Stacks[sc].isEmpty());
		}
	}

	@Test
	public void testStackSize() {
		String descript;
		for (int sc = 0; sc < NSTACKS; sc++) {
			Stacks[sc].push("AA");
			Stacks[sc].push("B");
			Stacks[sc].push("CCC");
			descript = "test A for " + DESCRIBEIMPL[sc]
					+ " : a filled list should not give .isEmpty";
			assertFalse(descript, Stacks[sc].isEmpty());
			descript = "test B for " + DESCRIBEIMPL[sc]
					+ " : push 3 items should result in .size 3";
			assertEquals(descript, 3, Stacks[sc].size());
		}
	}

	@Test
	public void testTopFromEmpty() {
		String descript;
		for (int sc = 0; sc < NSTACKS; sc++) {
			ReturnObject ro = Stacks[sc].top();
			if (ro == null) {
				descript = "test A for " + DESCRIBEIMPL[sc]
						+ " .top should not return null object";
				assertTrue(descript, false);
			} else {
				descript = "test B for " + DESCRIBEIMPL[sc]
						+ " .top on empty list should produce .hasError().";
				assertTrue(descript, ro.hasError());
				descript = "test C for "
						+ DESCRIBEIMPL[sc]
						+ " .top on empty list should produce EMPTY_STRUCTURE error message";
				assertEquals(ErrorMessage.EMPTY_STRUCTURE, ro.getError());
			}
		}
	}

	@Test
	public void testTopFromFilled() {
		for (int sc = 0; sc < NSTACKS; sc++) {
			Stacks[sc].push("AA");
			Stacks[sc].push("B");
			Stacks[sc].push("CCC");
			ReturnObject ro = Stacks[sc].top();
			assertFalse(ro.hasError());
			// stack is last in first out so should get "CCC"
			assertEquals("CCC", ro.getReturnValue());
		}
	}

	@Test
	public void testPopFromFilled() {
		for (int sc = 0; sc < NSTACKS; sc++) {
			Stacks[sc].push("A");
			Stacks[sc].push("B");
			ReturnObject ro = Stacks[sc].pop();
			assertFalse(ro.hasError());
			// stack is last in first out so should get "B"
			assertEquals("B", ro.getReturnValue());
			// stack should have one item
			assertEquals(1, Stacks[sc].size());
			assertEquals("A", Stacks[sc].pop().getReturnValue());
			// another pop should give an EMPTRY_STRUCTURE error
			ro = Stacks[sc].pop();
			assertTrue(ro.hasError());
			assertEquals(ErrorMessage.EMPTY_STRUCTURE, ro.getError());
		}
	}

}
