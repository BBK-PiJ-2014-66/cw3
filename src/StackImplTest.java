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
		if (NSTACKS > 2) {
			Stacks[2] = new ImprovedStackImpl();
		}
	}

	@Test
	public void testEmptyStackisEmpty() {
		String descript;
		for (int sc = 0; sc < NSTACKS; sc++) {
			descript = "test for " + DESCRIBEIMPL[sc]
					+ " : a empty list should  give .isEmpty true";
			assertTrue(descript, Stacks[sc].isEmpty());
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
		String descript;
		for (int sc = 0; sc < NSTACKS; sc++) {
			Stacks[sc].push("AA");
			Stacks[sc].push("B");
			Stacks[sc].push("CCC");
			ReturnObject ro = Stacks[sc].top();
			if (ro == null) {
				descript = "test A for " + DESCRIBEIMPL[sc]
						+ " on filled stack .top should not return null object";
				assertTrue(descript, false);
			} else {
				descript = "test B for "
						+ DESCRIBEIMPL[sc]
						+ " .top on filled stack should not produce .hasError().";
				assertFalse(descript, ro.hasError());
				// stack is last in first out so should get "CCC"
				// make test more challenging by poping the last value
				Stacks[sc].pop();
				descript = "test C for "
						+ DESCRIBEIMPL[sc]
						+ " .top on filled stack should get back last object put in.";
				assertEquals("CCC", ro.getReturnValue());
			}
		}
	}

	@Test
	public void testPopFromFilled() {
		String descript;
		for (int sc = 0; sc < NSTACKS; sc++) {
			Stacks[sc].push("A");
			Stacks[sc].push("B");
			ReturnObject ro = Stacks[sc].pop();
			if (ro == null) {
				descript = "test A for " + DESCRIBEIMPL[sc]
						+ " on filled stack .pop should not return null object";
				assertTrue(descript, false);
			} else {
				descript = "test B for " + DESCRIBEIMPL[sc]
						+ " on filled stack .pop should not return .hasError";
				assertFalse(descript, ro.hasError());
				// stack is last in first out so should get "B"
				descript = "test C for "
						+ DESCRIBEIMPL[sc]
						+ " .pop on filled stack should get back last object put in.";
				assertEquals(descript, "B", ro.getReturnValue());
				// stack should have one item
				descript = "test D for "
						+ DESCRIBEIMPL[sc]
						+ " .pop on filled stack with two items should give one item.";
				assertEquals(descript, 1, Stacks[sc].size());
				descript = "test E for "
						+ DESCRIBEIMPL[sc]
						+ " (2nd) .pop on filled stack should get back last object put in.";
				assertEquals(descript,"A", Stacks[sc].pop().getReturnValue());
				// another pop should give an EMPTY_STRUCTURE error
				ro = Stacks[sc].pop();
				descript = "test F for "
						+ DESCRIBEIMPL[sc]
						+ " .pop on now empty stack should give .hasError";
				assertTrue(descript,ro.hasError());
				descript = "test G for "
						+ DESCRIBEIMPL[sc]
						+ " .pop on now empty stack should give ErrorMessage EMPTY_STRUCTURE";
				assertEquals(descript,ErrorMessage.EMPTY_STRUCTURE, ro.getError());
			}
		}
	}

}
