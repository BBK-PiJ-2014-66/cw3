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

	private Stack internalStack;

	/**
	 * constructor: simply create an internalStack.
	 */
	ImprovedStackImpl() {
		// Use the StackImpl with array implementation of List
		internalStack = new StackImpl(new ArrayList());		
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

	@Override
	public ImprovedStack reverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Object object) {
		// TODO Auto-generated method stub

	}

}
