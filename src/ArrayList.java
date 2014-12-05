/**
 * Implementation of List based on arrays
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 * 
 */
public class ArrayList implements List {

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public ReturnObject get(int index) {
		return null;
	}

	@Override
	public ReturnObject remove(int index) {
		return null;
	}

	@Override
	public ReturnObject add(int index, Object item) {
		return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
	}

	@Override
	public ReturnObject add(Object item) {
		return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
	}

}
