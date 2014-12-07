/**
 * StackImpl is an implementation of Stack that extends AbstractStack
 * 
 * This allows any List implementation to be used supplied to the constructor
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 * 
 */
public class StackImpl extends AbstractStack implements Stack {
	/**
	 * Comment from super:
	 * 
	 * Creates a new abstract stack using the provided list as the underlying
	 * data structure.
	 * 
	 * Note: This constructor does not check whether the provided list is null.
	 * Programmers must do their own checks. If a null list is provided, a
	 * NullPointerException will be thrown at runtime as soon as any operation
	 * is attempted on the underlying list.
	 * 
	 * OSS: ergo need to check for list being null in each and every method.
	 * 
	 * @param the
	 *            list to be used
	 */
	public StackImpl(List list) {
		super(list);

	}

	/**
	 * Returns true if the stack is empty, false otherwise.
	 * 
	 * @return true if the stack is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		// null list must be empty
		if (this == null) {
			// should throw an exception?
			System.out
					.println("WARNING using isEmpty() on a List that is null");
			return true;
		}
		return internalList.isEmpty();
	}

	/**
	 * Returns the number of items currently in the stack.
	 * 
	 * @return the number of items currently in the stack
	 */
	@Override
	public int size() {
		// null list will have no elements (for ever!)
		if (this == null) {
			// should throw an exception?
			System.out.println("WARNING using size() on a List that is null");
			return 0;
		}
		return internalList.size();
	}

	/**
	 * Adds an element at the top of the stack.
	 * 
	 * choose "top of stack" to be last element in list (means array
	 * implementation will not have to do a copy each time).
	 * 
	 * @param item
	 *            the new item to be added
	 */
	@Override
	public void push(Object item) {
		if (this == null) {
			// should throw an exception?
			System.out
					.println("WARNING trying to push() item to a List that is null");
			return;
		}
		internalList.add(item);
	}

	/**
	 * Returns the element at the top of the stack. The stack is left unchanged.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	@Override
	public ReturnObject top() {
		/*
		 * what is the appropriate error message for a null list?
		 * EMPTY_STRUCTURE seems OK for this.
		 */
		if (this == null || this.isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		ReturnObject topRO = internalList.get(internalList.size() - 1);
		if (topRO.hasError()) { 
			// should never happen! throw an exception? or assert?
			System.out.println("WARNING internal programMing top/pop got unexpected "
					+ " ReturnObject error " + topRO.getError());
			return null;
		}
		return topRO;
	}

	/**
	 * Returns the element at the top of the stack. The element is removed frmo
	 * the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	@Override
	public ReturnObject pop() {
		ReturnObject topRO = this.top();
		if (topRO!=null && !topRO.hasError()) {
			internalList.remove(internalList.size() - 1);	
		}
		return topRO;
	}

}
