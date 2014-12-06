/**
 * FunctionalList implementation using ArrayList
 * 
 * A FunctionalList is a List with addition head and rest methods
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 * 
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {

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
		if (this.size()==0) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		return new ReturnObjectImpl(this.get(0).getReturnValue());
	}
	
    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
	@Override
	public FunctionalList rest() {
		// TODO Auto-generated method stub
		return null;
	}

}
