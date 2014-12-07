import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Unit test ArrayList
 * @author Oliver Smart <osmart01@dcs.bbk.ac.uk>
 */

public class SampleableListImplTest extends ListTest{

	/** 
	 * first use the existing ListTest
	 */
	public void initialize() {
		myList = new SampleableListImpl();
	}
	
	@Test
	public void testSampleOnFilledList() {
		// set up initial list
		SampleableList initialList = new SampleableListImpl();
		initialList.add("1st");
		initialList.add("2nd");
		initialList.add("3rd");
		initialList.add("4th");
		initialList.add("5th");
		initialList.add("6th");
		// now sample it should get "1st", "3rd", "5th"
		SampleableList sampledList = initialList.sample();
		assertEquals(3,sampledList.size());
		assertEquals("1st",sampledList.get(0).getReturnValue());
		assertEquals("3rd",sampledList.get(1).getReturnValue());
		assertEquals("5th",sampledList.get(2).getReturnValue());
		// list should be independent so clear the initial one
		while (initialList.size()>0) {
			initialList.remove(0);
		}
		// repeat test
		assertEquals(3,sampledList.size());
		assertEquals("1st",sampledList.get(0).getReturnValue());
		assertEquals("3rd",sampledList.get(1).getReturnValue());
		assertEquals("5th",sampledList.get(2).getReturnValue());

	}

}
