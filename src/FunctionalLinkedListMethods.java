/**
 * Methods for FunctionalList implementations used by both FunctionalArrayList
 * and FunctionLinkedList. Implement here as static methods working for any 
 * FunctionalList to avoid code duplication
 * 
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 */
public class FunctionalLinkedListMethods {
	/**
	 * head method :Returns the element at the beginning of the list.
	 * 
	 * If the list is empty, an "appropriate error" is returned.
	 * 
	 * appropriate error means EMPTY_STRUCTURE
	 * 
	 * @param FList The functional list.
	 * @return The element at the beginning of the list (element zero for us).
	 */
	public static ReturnObject head(FunctionalList fList) {
		if (fList.size() == 0) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		return new ReturnObjectImpl(fList.get(0).getReturnValue());
	}
	
	/**
	 * chops out the first element of a functional list used by head method 
	 * 
	 * @param clonedList a cloned copy of the original list
	 * @return a list with the first element removed
	 */
	public static FunctionalList chopOutFirstElement( FunctionalList clonedList) {
		// chop out the first (0 index) element if there is one
		if (!clonedList.isEmpty()) {
			clonedList.remove(0);
		}
		return clonedList;
	}
	
	/**
	 * Copies one list to another (used by clone)
	 * 
	 * @param fList the original functionallist not to be altered
	 * @param fCopy an existing list to be cleared and copied to.
	 * @return the functionallist fCopy
	 */
	public static FunctionalList makeCopyOfList( FunctionalList fList, FunctionalList fCopy) {
		// clear any items in the copy
		while (!fCopy.isEmpty()) {
			fCopy.remove(0);
		}
		
		// now copy across
		for (int ic = 0; ic < fList.size(); ic++) {
			Object item = fList.get(ic).getReturnValue();
			// assume we want a "shallow" copy so simply add the same object
			fCopy.add(item);
		}
		return fCopy;
	}

}
