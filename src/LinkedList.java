/**
 * Implementation of List based on pointers.
 * 
 * loosely adapted from PointerStringStack class provided by PiJ on day 8.
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 * 
 */
public class LinkedList implements List {
	/**
	 * The head of the list (N.B. LinkedListNode is a nested inner class)
	 */
	private LinkedListNode head;

	LinkedList() {
		head = null;
	}

	/**
	 * Returns true if the list is empty, false otherwise.
	 * 
	 * @return true if the list is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	@Override
	public int size() {
		if (head == null)
			return 0;
		return head.numberOfElementsAfter();
	}

	/**
	 * Returns the elements at the given position.
	 * 
	 * If the index is negative or greater or equal than the size of the list,
	 * then "an appropriate error" = INDEX_OUT_OF_BOUNDS is returned.
	 * 
	 * @param index
	 *            the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, encapsulated in a
	 *         ReturnObject
	 */
	@Override
	public ReturnObject get(int index) {
		// have they asked for an element that does not exist.
		if (index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		// retrieve the node;
		LinkedListNode retrieve = head.getNodeIndex(index);

		if (retrieve == null) {
			// should throw an error?
		}
		// return it as a new ReturnObjectImpl object
		return new ReturnObjectImpl(retrieve.getObject());
	}

	/**
	 * Returns the elements at the given position and removes it from the list.
	 * The indeces of elements after the removed element must be updated
	 * accordingly.
	 * 
	 * If the index is negative or greater or equal than the size of the list,
	 * then an appropriate error must be returned.
	 * 
	 * @param index
	 *            the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, encapsulated in a
	 *         ReturnObject
	 */
	@Override
	public ReturnObject remove(int index) {
		// use get to check index valid is and supply the object
		ReturnObject retRO = get(index);
		if (!retRO.hasError()) {
			// remove item
			// the head must be done differently
			if (index==0) {
				head = head.getNext();
			} else {
				// retrieve the node before
				LinkedListNode before = head.getNodeIndex(index - 1);
				// cut this node out
				before.setNext(before.getNext().getNext());
			}
		}
		return retRO;
	}

	/**
	 * Adds an element to the list, inserting it at the given position. The
	 * indeces of elements at and after that position must be updated
	 * accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of the list,
	 * then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the request must be
	 * ignored and an appropriate error must be returned.
	 * 
	 * @param index
	 *            the position at which the item should be inserted in the list
	 * @param item
	 *            the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful the item
	 *         added or containing an appropriate error message
	 */
	@Override
	public ReturnObject add(int index, Object item) {
		if (item == null) { // not allowed to store null
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else if (index < 0 || index >= this.size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		// index and item legit
		LinkedListNode newNode = new LinkedListNode(item);
		if (head == null) {
			head = newNode; // 1st item added
		} else if (index == 0) {
			// need to replace head with newNode
			// but first establish the link
			newNode.setNext(head);
			head = newNode;
		} else {
			// retrieve the node before
			LinkedListNode before = head.getNodeIndex(index - 1);
			newNode.setNext(before.getNext());
			before.setNext(newNode);
		}

		return null;
	}

	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the request must be
	 * ignored and an appropriate error must be returned.
	 * 
	 * @param item
	 *            the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful the item
	 *         added or containing an appropriate error message
	 */
	@Override
	public ReturnObject add(Object item) {
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		LinkedListNode newNode = new LinkedListNode(item);
		if (head == null) {
			head = newNode; // 1st item added
		} else {
			head.addNodeatEnd(newNode); // add at end of list
		}

		return null;
	}

	/**
	 * LinkedListNode is a private nested class only used by its enclosing
	 * class. Based on StringStackNode class provied by PiJ on day 8.
	 */
	private class LinkedListNode {
		private Object content;
		private LinkedListNode next;

		public LinkedListNode(Object inObject) {
			content = inObject;
			next = null;
		}

		/**
		 * Getter for the object stored at the node;
		 * 
		 * @return the object
		 */
		public Object getObject() {
			return content;
		}
		
		public  LinkedListNode getNext() {
			return next;
		}

		/**
		 * returns the node at a particular index (if called from head). Works
		 * by recursively calling itself.
		 * 
		 * @param the
		 *            index wanted.
		 * @return the node at particular index.
		 */
		public LinkedListNode getNodeIndex(int index) {
			if (index <= 0) {
				return this;
			} else if (next == null) {
				return null;
			}
			return next.getNodeIndex(index - 1);
		}

		/**
		 * Set the next node to point to the given node
		 */
		public void setNext(LinkedListNode node) {
			next = node;
		}

		/**
		 * recursive method to find the number of elements after this one
		 * 
		 * @return the number of elements after this one.
		 */
		public int numberOfElementsAfter() {
			if (next == null)
				return 1; // this is last item
			return 1 + next.numberOfElementsAfter();
		}

		/**
		 * adds Node to the end of the list
		 * 
		 * @param nodeToAdd
		 */
		public void addNodeatEnd(LinkedListNode nodeToAdd) {
			if (next == null) {
				next = nodeToAdd;
			} else {
				next.addNodeatEnd(nodeToAdd);
			}
		}
	}
}
