public class SampleableListImpl extends ArrayList implements SampleableList {
	/**
	 * Returns a list containing the first, third, fifth... items of this list,
	 * or an empty list if the list is empty.
	 * 
	 * Note that that we assume that lists do not have a "zeroth" item. That is
	 * "first" means item with array index 0.
	 * 
	 * @return a list containing the first, third, fifth... items of this list
	 */
	@Override
	public SampleableList sample() {
		SampleableList sampled = new SampleableListImpl();
		// want the 0, 2, 4 index (count from zero in java!)
		for (int ic = 0; ic < this.size(); ic += 2) {
			Object item = this.get(ic).getReturnValue();
			if (item == null) {
				// should really throw an error
				System.out.println("internal progamming error"
						+ " in SampleableList sample! Got a null");
			} else {
				sampled.add(item);
			}
		}
		return sampled;
	}

}
