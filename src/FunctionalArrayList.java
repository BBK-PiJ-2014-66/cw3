/**
 * FunctionalList implementation using ArrayList
 * 
 * A FunctionalList is a List with addition head and rest methods
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
		if (this.size() == 0) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		return new ReturnObjectImpl(this.get(0).getReturnValue());
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
		FunctionalList cutDownList = this.clone();
		// chop out the first (0 index) element if there is one
		if (!cutDownList.isEmpty()) {
			cutDownList.remove(0);
		}
		return cutDownList;
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
		for (int ic = 0; ic < this.size(); ic++) {
			Object item = this.get(ic).getReturnValue();
			// assume we want a "shallow" copy so simply add the same object
			theClone.add(item);
		}
		return theClone;
	}

}
