/**
 * FunctionalList implementation using ArrayList
 * 
 * A FunctionalList is a List with addition of head and rest methods.
 * 
 * To avoid code duplication uses methods from FunctionalLinkedListMethods to do
 * the actual work.
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 * 
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList,
		Cloneable {

	/**
	 * Returns the element at the beginning of the list.
	 * 
	 * If the list is empty, an "appropriate error" is returned.
	 * 
	 * appropriate error means EMPTY_STRUCTURE
	 * 
	 * @return a copy of the element at the beginning of the list or an error if
	 *         the list is empty.
	 */
	@Override
	public ReturnObject head() {
		return FunctionalLinkedListMethods.head(this);
	}

	/**
	 * Returns a list with the elements in this list except the head. The
	 * elements must be in the same order. The original list must not change or
	 * be affected by changes in the new list.
	 * 
	 * If the list is empty, another empty list is returned.
	 */
	@Override
	public FunctionalList rest() {
		// we have to "clone" the FunctionalList to get a new copy
		FunctionalList clonedList = this.clone();
		return FunctionalLinkedListMethods.chopOutFirstElement(clonedList);
	}

	/**
	 * clone of the current FunctionalList
	 * 
	 * see: https://docs.oracle.com/javase/7/docs/
	 * api/java/lang/Object.html#clone%28%29
	 * 
	 * Notice clone is "shallow" as it includes the same objects not clones of
	 * them.
	 * 
	 * @return the clone
	 */
	@Override
	public FunctionalList clone() {
		FunctionalList theClone = new FunctionalArrayList();
		return FunctionalLinkedListMethods.makeCopyOfList(this, theClone);
	}

}
