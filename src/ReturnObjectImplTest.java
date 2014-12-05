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

		// should not have an error
		assertFalse(ro.hasError());

		// should get back what we put in
		assertEquals(ro.getReturnValue(), anInteger);

		// the "error message": must be NO_ERROR
		assertEquals(ro.getError(), ErrorMessage.NO_ERROR);
	}

	@Test
	/**
	 * test error condition handling
	 */
	public void testWithError() {
		// supply an error message (other than NO_ERROR)
		ReturnObject ro = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);

		// this is an error - check hasError method:
		assertTrue(ro.hasError());

		// should get back the ErrorMessage we supplied:
		assertEquals(ro.getError(), ErrorMessage.EMPTY_STRUCTURE);

		// after error the return value must be null (a requirement in interface
		// comments)
		assertNull(ro.getReturnValue());
	}

}
