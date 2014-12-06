/**
 * Unit test List implementations.
 * 
 * code originally developed as ArrayListTest but move
 * the meat "up" to this abstract class to allow reuse to test
 * LinkedList implementation with duplication.
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 */
import static org.junit.Assert.*;

import org.junit.*;

public abstract class ListTest {
	/**
	 * start each test with an empty list
	 */
	List myList;

	@Before
	public abstract void initialize();

	@Test
	public void testEmptyListisEmpty() {
		// empty list should be empty!
		assertTrue(myList.isEmpty());

	}

	@Test
	public void testEmptyListHas0Elements() {
		// empty list should have zero elements
		assertEquals(0, myList.size());
	}

	@Test
	public void testEmptyListget() {
		// try to get the 0th element empty list. This should result in an error
		assertTrue(myList.get(0).hasError());
	}

	@Test
	public void testAddItemNotIsEmpty() {
		myList.add(new Integer(1));
		assertFalse(myList.isEmpty());
	}

	@Test
	public void testAdd10ItemsResultsSize10() {
		// add ten items to list and size should be 10
		for (int ic = 0; ic < 10; ic++) {
			myList.add(new Integer(ic));
		}
		assertEquals(10, myList.size());
	}

	@Test
	public void testAddNullProducesError() {
		/*
		 * according to interface must produce an appropriate error message
		 * INVALID_ARGUMENT is appropriate as it is documented as being for:
		 * "insert a null element in a list that does not allow null elements"
		 */
		ReturnObject ro = myList.add(null);
		assertEquals(ro.getError(), ErrorMessage.INVALID_ARGUMENT);
	}

	@Test
	public void testGettingAddandGet10Items() {
		for (int ic = 0; ic < 10; ic++) {
			myList.add(new Integer(ic));
		}
		for (int ic = 0; ic < 10; ic++) {
			assertFalse(myList.get(ic).hasError());
			int getBack = (Integer) myList.get(ic).getReturnValue();
			assertEquals(ic, getBack);
		}
	}

	@Test
	public void testGettingAddIntoMiddle() {
		// add 0 to 9 to list
		for (int ic = 0; ic < 10; ic++) {
			myList.add(new Integer(ic));
		}
		// now add "insert@4" as item# 4
		myList.add(4, "insert@4");
		assertEquals(3, myList.get(3).getReturnValue());
		assertEquals("insert@4", myList.get(4).getReturnValue());
		assertEquals(4, myList.get(5).getReturnValue());
		assertEquals(11, myList.size());
	}

	@Test
	public void testAddatIndexOutofRange() {
		// add 0 to 9 to list
		for (int ic = 0; ic < 10; ic++) {
			myList.add(new Integer(ic));
		}
		ReturnObject ro = myList.add(10, "fred");
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, ro.getError());
	}

	@Test
	public void testRemoveInitial() {
		// add 0 to 9 to list
		for (int ic = 0; ic < 10; ic++) {
			myList.add(new Integer(ic));
		}
		ReturnObject ro = myList.remove(0);
		// the removal should not have resulted in an error
		assertFalse(ro.hasError());
		// remove returns the item removed, in this case zero
		assertEquals(0, ro.getReturnValue());
		// list should now have nine elements
		assertEquals(9, myList.size());
		// first element should be 1
		assertEquals(1, myList.get(0).getReturnValue());
	}

	@Test
	public void testRemoveFinal() {
		// add 0 to 9 to list
		for (int ic = 0; ic < 10; ic++) {
			myList.add(new Integer(ic));
		}
		ReturnObject ro = myList.remove(9);
		// the removal should not have resulted in an error
		assertFalse(ro.hasError());
		// remove returns the item removed, in this case 9
		assertEquals(9, ro.getReturnValue());
		// list should now have nine elements
		assertEquals(9, myList.size());
		// first element should be 0
		assertEquals(0, myList.get(0).getReturnValue());
		// last element should be 8
		assertEquals(8, myList.get(8).getReturnValue());
	}

}
