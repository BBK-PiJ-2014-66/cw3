/**
 * 
 * Coursework specifies:
 * "this class cannot Extend either AbstractStack or StackImpl" so instead use
 * composition where this class "has-a" internalStack;
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 * 
 */
public class ImprovedStackImpl implements ImprovedStack {

	// want List type access for reverse and remove methods
	private List internalList;
	private Stack internalStack;

	/**
	 * constructor: simply create an internalStack.
	 */
	ImprovedStackImpl() {
		// Use the StackImpl with array implementation of List
		internalList = new ArrayList();
		internalStack = new StackImpl(internalList);
	}

	@Override
	public boolean isEmpty() {
		// simply use the method from StackImpl
		return internalStack.isEmpty();
	}

	@Override
	public int size() {
		// simply use the method from StackImpl
		return internalStack.size();
	}

	@Override
	public void push(Object item) {
		// simply use the method from StackImpl
		internalStack.push(item);
	}

	@Override
	public ReturnObject top() {
		// simply use the method from StackImpl
		return internalStack.top();
	}

	@Override
	public ReturnObject pop() {
		// simply use the method from StackImpl
		return internalStack.pop();
	}

	/**
	 * Returns a copy of this stack with the items reversed, the top
	 * elements on the original stack is at the bottom of the new
	 * stack and viceversa.
	 * 
	 * @return a copy of this stack with the items reversed. 
	 */
	@Override
	public ImprovedStack reverse() {
		if (internalList == null)
			return null;
		ImprovedStack reversed = new ImprovedStackImpl();
		// access the Stack elements in reverse using the underlying internalList
		for (int ic= internalList.size()-1; ic>=0; ic--) {
			// want the element in the list at ic
			Object element = internalList.get(ic).getReturnValue(); 
			// push the new element into the new stack
			reversed.push(element); 
		}
		return reversed;
	}

	@Override
	public void remove(Object object) {
		// TODO Auto-generated method stub

	}

}
