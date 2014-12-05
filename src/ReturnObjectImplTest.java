import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests that ReturnObjectImpl works properly
 * 
 * @author osmart
 */
public class ReturnObjectImplTest {

	@Test
	/**
	 * test supplying an object, used for success in calling method.
	 */
	public void testSuccess() {
		// create a new object - boxed integer
		Integer anInteger = new Integer(1);
		// supply the boxed integer to ReturnObject
		ReturnObject ro = new ReturnObjectImpl(anInteger);

		assertFalse(ro.hasError()); // should not have an error

		assertEquals(ro.getReturnValue(), anInteger); // should get back what we
														// put in

		assertEquals(ro.getError(), ErrorMessage.NO_ERROR); // the error message
															// must be NO_ERROR
	}

	@Test
	/**
	 * test error condition handling
	 */
	public void testWithError() {
		ReturnObject ro = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);

		assertTrue(ro.hasError()); // this is an error.

		assertEquals(ro.getError(), ErrorMessage.EMPTY_STRUCTURE); // should get
																	// back the
																	// ErrorMessage

		assertEquals(ro.getReturnValue(), null); // should return null value

	}

}
