import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for StackImpl implementations
 * 
 * Peforms the same tests on 3 things:
 * 
 * (a) StackImpl using an ArrayList List
 * 
 * (b) StackImpl using a LinkedList List
 * 
 * (c) ImprovedStackImpl (note that this tests just the Stack type functions)
 * and not the additional reverse and remove methods that are introduced in
 * ImprovedStack
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 * 
 */
public class StackImplTest {
	/**
	 * Same test on three things. To do this create an array.
	 */
	private Stack Stacks[];
	private static int NSTACKS = 3; // never hard code anything
	private static String[] DESCRIBEIMPL = { "ArrayList", "LinkedList",
			"ImprovedStackImpl" };

	/**
	 * method to initialize the three stack implementations
	 */
	@Before
	public void initialize() {
		Stacks = new Stack[NSTACKS];
		Stacks[0] = new StackImpl(new ArrayList()); // first ArrayList
		Stacks[1] = new StackImpl(new LinkedList()); // 2nd LinkedList
		if (NSTACKS > 2) { /*
							 * 3rd is improved stack. Use the conditional to
							 * allow it to be easilyturned off during
							 * development
							 */
			Stacks[2] = new ImprovedStackImpl();
		}
	}

	/**
	 * initial stacks will be empty. Check that they actually give .isEmpty()
	 * true
	 */
	@Test
	public void testEmptyStackisEmpty() {
		// in the case of a failure need to know which fails
		String descript;
		for (int sc = 0; sc < NSTACKS; sc++) {
			descript = "test for " + DESCRIBEIMPL[sc]
					+ " : a empty list should  give .isEmpty true";
			assertTrue(descript, Stacks[sc].isEmpty());
		}
	}

	/**
	 * test that three things to a stack results in .isEmpty false and .size()
	 * of three.
	 */
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

	/**
	 * test top from empty stack. Should produce a EMPTY_STRUCTURE error
	 * message.
	 */
	@Test
	public void testTopFromEmpty() {
		String descript;
		for (int sc = 0; sc < NSTACKS; sc++) {
			ReturnObject ro = Stacks[sc].top();
			descript = "test A for " + DESCRIBEIMPL[sc]
					+ " .top should never return a null!";
			assertNotNull(descript, ro);
			descript = "test B for " + DESCRIBEIMPL[sc]
					+ " .top on empty list should produce .hasError().";
			assertTrue(descript, ro.hasError());
			descript = "test C for "
					+ DESCRIBEIMPL[sc]
					+ " .top on empty list should produce EMPTY_STRUCTURE error message";
			assertEquals(ErrorMessage.EMPTY_STRUCTURE, ro.getError());
		}
	}

	/**
	 * push three objects onto the stack and test that top gets back the last
	 * one put in
	 */
	@Test
	public void testTopFromFilled() {
		String descript;
		for (int sc = 0; sc < NSTACKS; sc++) {
			Stacks[sc].push("AA");
			Stacks[sc].push("B");
			Stacks[sc].push("CCC");
			ReturnObject ro = Stacks[sc].top();
			descript = "test A for " + DESCRIBEIMPL[sc]
					+ " on filled stack .top should not return null!";
			assertNotNull(descript, ro);
			descript = "test B for " + DESCRIBEIMPL[sc]
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

	/**
	 * push two objects onto the stack. Pop one out. Check that correct object
	 * is returned. Pop all objects out. Do an additional pop and check that
	 * EMPTY_STRUCTURE error message is found.
	 */
	@Test
	public void testPopFromFilled() {
		String descript;
		for (int sc = 0; sc < NSTACKS; sc++) {
			Stacks[sc].push("A");
			Stacks[sc].push("B");
			ReturnObject ro = Stacks[sc].pop();
			descript = "test A for " + DESCRIBEIMPL[sc]
					+ " on filled stack .pop should not return null object";
			assertNotNull(descript, ro);
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
			assertEquals(descript, "A", Stacks[sc].pop().getReturnValue());
			// another pop should give an EMPTY_STRUCTURE error
			ro = Stacks[sc].pop();
			descript = "test F for " + DESCRIBEIMPL[sc]
					+ " .pop on now empty stack should give .hasError";
			assertTrue(descript, ro.hasError());
			descript = "test G for "
					+ DESCRIBEIMPL[sc]
					+ " .pop on now empty stack should give ErrorMessage EMPTY_STRUCTURE";
			assertEquals(descript, ErrorMessage.EMPTY_STRUCTURE, ro.getError());
		}
	}

}
