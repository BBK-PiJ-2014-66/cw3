/**
 * Unit test ArrayList
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 */
import static org.junit.Assert.*;
import org.junit.*;

public class ArrayListTest {

	/**
	 * start each test with an empty list
	 */
	List myList;

	@Before	
	public void initialize() {
		myList = new ArrayList();
	}

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
		assertEquals(10,myList.size());
	}
	
	@Test
	public void testAddNullProducesError() {
		/* according to interface must produce an appropriate error message
		 * INVALID_ARGUMENT is appropriate as it is documented as being for:
		 * "insert a null element in a list that does not allow null elements" 
	     */
		ReturnObject ro = myList.add(null);
		assertEquals( ro.getError(), ErrorMessage.INVALID_ARGUMENT);
	}
	

	@Test
	public void testGettingAddandGet10Items() {
		for (int ic = 0; ic < 10; ic++) {
			myList.add(new Integer(ic));
		}
		for (int ic = 0; ic < 10; ic++) {
			assertEquals(ic,myList.get(ic));
		}
	}
	
	@Test
	public void testGettingAddIntoMiddle() {
		// add 0 to 9 to list
		for (int ic = 0; ic < 10; ic++) {
			myList.add(new Integer(ic));
		}
		// now add 44 as item# 4
		myList.add( 4, new Integer(44));
		assertEquals(3,myList.get(3));
		assertEquals(44,myList.get(4));
		assertEquals(5,myList.get(5));
		assertEquals(11,myList.size());
	}
	
	@Test
	public void testAddatIndexOutofRange() {
		// add 0 to 9 to list
		for (int ic = 0; ic < 10; ic++) {
			myList.add(new Integer(ic));
		}
		myList.add( 10, "fred");
		ReturnObject ro = myList.add(null);
		assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS,ro.getError());
	}
	
}
