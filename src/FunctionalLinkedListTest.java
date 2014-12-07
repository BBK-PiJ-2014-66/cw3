/**
 * Unit test FunctionalLinkedList class.
 * 
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 */
public class FunctionalLinkedListTest extends FunctionalListTest {

	/**
	 * initialize provides a new list of the correct class for the start of each
	 * separate test.
	 * 
	 * the "meat" of the tests is in FunctionalListTest
	 */
	@Override
	public void initialize() {
		myList = new FunctionalLinkedList();
	}

}