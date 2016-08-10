/**
 * 
 * Wraps an underlying Collection and serves to both simplify its API and give it a common 
 * type with the implemented SimpleHashSets.
 * @author orlykor12
 *
 */
public class CollectionFacadeSet implements SimpleSet {
	java.util.Collection<java.lang.String> collection;
	
	/**
	 * Creates a new facade wrapping the specified collection.
	 * 
	 * @param collection
	 */
	public CollectionFacadeSet(java.util.Collection<java.lang.String> collection){
		if (collection != null){
		this.collection = collection;
		}
	}
	
	@Override
	public boolean add(java.lang.String newValue){
		if (!contains(newValue)){
			return this.collection.add(newValue);
		}
		return false;
		 
	}

	@Override
	public boolean contains(String searchVal) {
		return this.collection.contains(searchVal);
	}

	@Override
	public boolean delete(String toDelete) {
		return this.collection.remove(toDelete);
	}

	@Override
	public int size() {
		return this.collection.size();
	}
}
