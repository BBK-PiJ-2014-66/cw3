import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * JUnit tests for the additional reverse and remove methods that are introduced
 * in ImprovedStack.
 * 
 * Note that the "basic" Stack methods of ImprovedStack are tested in
 * StackImplTest and not here
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 * 
 */
public class ImprovedStackImplTest {

	/**
	 * tests reverse method. Also provides tests of "basic" Stack methods on the
	 * way.
	 */
	@Test
	public void testReverse() {
		ImprovedStack original = new ImprovedStackImpl();
		assertTrue("test A: new Stack .isEmpty() must be true",
				original.isEmpty());
		original.push("s1");
		original.push("s2");
		original.push("s3");
		assertFalse(
				"test B: added 3 elements to stack .isEmpty() must be false",
				original.isEmpty());
		assertEquals("test C: after adding 3 elements size must be 3 ", 3,
				original.size());

		ImprovedStack reversed = original.reverse();
		assertNotNull("test D1: reverse should not return a null object.", reversed);
		assertEquals(
				"test D2: reverse of stack with 3 elements must result in stack with 3 elements",
				3, reversed.size());

		ReturnObject ro;
		ro = original.pop();
		assertNotNull("test E: .pop() must never return a null", ro);
		assertEquals("test F: first pop on original", "s3", ro);

		ro = reversed.pop();
		assertNotNull("test G: .pop() must never return a null", ro);
		assertEquals("test H: first pop on reversed", "s1", ro);
		assertEquals("test I: 2nd pop on reversed", "s2", reversed.pop());
		assertEquals("test J: 3rd pop on reversed", "s3", reversed.pop());

	}

	/**
	 * test of remove method. 
	 */
	@Test
	public void testRemove() {
		ImprovedStack test = new ImprovedStackImpl();
		test.push("a");
		test.push("B");
		test.push("C");
		test.push("B");
		test.push("b");
		assertEquals("test A: after adding 5 elements size must be 5 ", 5,
				test.size());
		test.remove("B");
		assertEquals("test B: removing \"B\" should have removed 2 objects. ", 3,
				test.size());		

	}

}
