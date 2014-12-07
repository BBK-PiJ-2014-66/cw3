/**
 * Unit test FunctionalList implementations.
 *
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 */
import static org.junit.Assert.*;

import org.junit.*;

public abstract class FunctionalListTest {
	/**
	 * start each test with an empty list
	 */
	FunctionalList myList;

	@Before
	public abstract void initialize();

	@Test
	public void testHeadonFilledList() {
		myList.add("AA");
		myList.add("BB");
		myList.add("CC");
		ReturnObject ro = myList.head();
		// should not have given error
		assertFalse(ro.hasError());
		// head should give first element added "AA"
		assertEquals("AA", ro.getReturnValue());
	}

	@Test
	public void testHeadonEmptyList() {
		// to exercise things add an element
		myList.add("AA");
		// now remove it
		myList.remove(0);
		ReturnObject ro = myList.head();
		// should have given error
		assertTrue(ro.hasError());
		// the error should be
		assertEquals(ro.getError(), ErrorMessage.EMPTY_STRUCTURE);
	}

	@Test
	public void testRestOnFilled() {
		myList.add("AA");
		myList.add("BB");
		myList.add("CC");
		assertEquals(3, myList.size());
		FunctionalList chopList = myList.rest();
		// original list should still have 3 items
		assertEquals(3, myList.size());
		// chopList should have 2 items
		assertEquals(2, chopList.size());
		// remove the 2nd item "BB" in original list
		myList.remove(1);
		// chopList should have 2 items
		assertEquals(2, chopList.size());
		// and its head should be BB
		assertEquals("BB", chopList.head().getReturnValue());
		// chop off the next, leaving CC
		chopList = chopList.rest();
		assertEquals("CC", chopList.head().getReturnValue());
		// and again to empty it
		chopList = chopList.rest();
		assertTrue(chopList.isEmpty());
        // original list should have 2 items AA and CC		
		assertEquals(2, myList.size());
		assertEquals("AA", myList.head().getReturnValue());
		assertEquals("CC", myList.get(1).getReturnValue());		
	}
	
	@Test
	public void testRestOnEmpty() {
		FunctionalList chopList = myList.rest();
		assertTrue(chopList.isEmpty());
	}

}
