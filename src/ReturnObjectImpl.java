/**
 * Implementation of ReturnObject "A wrapper containing either an object (the
 * result of an operation on a data structure) or an error value."
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 * 
 */
public class ReturnObjectImpl implements ReturnObject {

	private ErrorMessage theErrorMessage;
	private Object theObject;

	/**
	 * constructor for success
	 * 
	 * @param inObject
	 *            the object to be stored
	 */
	ReturnObjectImpl(Object inObject) {
		theObject = inObject;
		theErrorMessage = ErrorMessage.NO_ERROR;
	}

	/**
	 * constructor for failure, store the error message
	 * 
	 * @param inErrorMessage
	 */
	ReturnObjectImpl(ErrorMessage inErrorMessage) {
		theObject = null;
		theErrorMessage = inErrorMessage;
	}

	/**
	 * a method required by the interface:
	 * 
	 * @see ReturnObject#hasError()
	 */
	@Override
	public boolean hasError() {
		if (theErrorMessage.equals(ErrorMessage.NO_ERROR)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * a method required by the interface to return the error message
	 * 
	 * @see ReturnObject#getError()
	 */
	@Override
	public ErrorMessage getError() {
		return theErrorMessage;
	}

	/**
	 * a method required by the interface to return the object (or null)
	 * 
	 * @see ReturnObject#getReturnValue()
	 */
	@Override
	public Object getReturnValue() {
		return theObject;
	}

}
