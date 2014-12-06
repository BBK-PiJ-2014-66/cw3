/**
 * Implementation of List based on arrays (based on "ArrayStringStack" day 8)
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 * 
 */
public class ArrayList implements List {
	/**
	 * The array of the objects stored. When full, a new one is created.
	 */
	private Object[] objectArray;

	/**
	 * The number of object in this list
	 */
	private int size;

	/**
	 * The initial size of the array. (Note: not size of list, which starts at
	 * 0)
	 */
	private static int INITIAL_ARRAY_SIZE = 5;

	/**
	 * constructor - makes an empty list, use add to add items
	 */
	public ArrayList() {
		objectArray = new Object[INITIAL_ARRAY_SIZE];
		size = 0;
	}

	/**
	 * Returns true if the list is empty, false otherwise.
	 * 
	 * @return true if the list is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		boolean isEmpty = true;
		if (size != 0)
			isEmpty = false;
		return isEmpty;
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	@Override
	public int size() {
		return size;
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
		if (index < 0 || index >= size) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		return new ReturnObjectImpl(objectArray[index]);
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
		return null;
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
		} else if (index < 0 || index >= size) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		/*
		 * first add dummy item to the end of the list thus increasing size of
		 * array if this is needed. size will be incremented by one
		 */
		add("dummy no one should ever see this!");
		// shuffle items down array
		for (int ac = size - 1; ac > index; ac--) {
			objectArray[ac] = objectArray[ac - 1];
		}
		objectArray[index] = item;
		return null; // "empty" for success
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
		if (isAlmostFull()) {
			reserveMoreMemory();
		}
		objectArray[size] = item;
		size++;
		return null; // success should be "empty"
	}

	/**
	 * Returns true is the size of the stack is almost the same as the size of
	 * the array, false otherwise.
	 */
	private boolean isAlmostFull() {
		if (objectArray.length - size < 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Creates a new array twice as big, copies all elements from the old array
	 * into it, and then replaces the old array with the new array.
	 * 
	 * The old array is not pointed to by anyone, so it will be disposed of by
	 * the garbage collector.
	 */
	private void reserveMoreMemory() {
		Object[] biggerArray = new Object[size * 2];
		for (int i = 0; i < size; i++) {
			biggerArray[i] = objectArray[i];
		}
		objectArray = biggerArray;
	}

}
