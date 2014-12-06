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
		assertEquals("AA",ro.getReturnValue());
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
		assertEquals(ro.getError(),ErrorMessage.EMPTY_STRUCTURE);
	}
	
	
	@Test
	public void testRest() {
		fail("testRest not yet implemented"); // TODO
	}

}
