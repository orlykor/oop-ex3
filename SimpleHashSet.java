/**
 * 
 * @author orlykor12
 *
 */
public abstract class SimpleHashSet implements SimpleSet {

	
	/** The initialized size of the table */
	protected final static int SIZE_CAPACITY = 16;
	
	/** The initialized upper load size */
	protected final static float UPPER_LOAD = 0.75f;
	
	/** The initialized lower load size */
	protected final static float LOWER_LOAD = 0.25f;
	
	/** The initialized number of elements in the table */
	protected final static int NUM_ELEMENTS = 0;
	
	/** The initialized number */
	protected final static int INITIALIZE_VALUE = 0;
	
	/** The number with we increase and decrease the table */
	protected final static int BYTWO = 2;
	
	/** False for not equal strings*/
	protected final static int NOT_EQUAL = -1;
	
	/** The lowest the capacity can get to*/
	protected final static int LOW_CAPACITY = 2;
	
	/** The upper load*/
	protected float upperLoad;
	
	/** The lower load */
	protected float lowerLoad;
	
	/** The number of elements in the table */
	protected int numElements;
	
	
	/**
	 * A default constructor. Constructs a new, empty table with default initial
	 * capacity, upper load factor and lower load factor.
	 */
	public SimpleHashSet() {
		this.lowerLoad = LOWER_LOAD;
		this.upperLoad = UPPER_LOAD;
	}
	
	/**
	 * Constructs a new, empty table with the specified load factors, and the
	 * default initial capacity.
	 * 
	 * @param upperLoadFactor
	 * @param lowerLoadFactor
	 */
	public SimpleHashSet(float upperLoadFactor, float lowerLoadFactor) {
		this.lowerLoad = lowerLoadFactor;
		this.upperLoad = upperLoadFactor;
	}
	
	/**
	 * Data constructor - builds the hash set by adding the elements one by one.
	 * Duplicate values should be ignored. The new table has the default values
	 * of initial capacity, upper load factor, and lower load factor.
	 * 
	 * @param data
	 */
	public SimpleHashSet(java.lang.String[] data) {
		this.lowerLoad = LOWER_LOAD;
		this.upperLoad = UPPER_LOAD;

	}

	/**
	 * Add a specified element to the set if it's not already in it.
	 * 
	 * @param newValue
	 * @return False iff newValue already exists in the set
	 */
	public abstract boolean add(String newValue);

	/**
	 * Look for a specified value in the set.
	 * 
	 * @param searchVal
	 * @return True iff searchVal is found in the set
	 */
	public boolean contains(String searchVal) {
		if (searchVal != null) {
			if (getIndexOf(searchVal) != NOT_EQUAL) {
				return true;
			}
		}
		return false;

	}
//}

	/*
	 * Check if there is a string in the table that is equal to the given
	 * string.
	 * 
	 * @param searchVal
	 * 
	 * @return the index of the equal string in the table, if not found return
	 * -1.
	 */
	protected abstract int getIndexOf(String searchVal);

	/**
	 * Remove the input element from the set.
	 * 
	 * @param toDelete
	 * @return True iff toDelete is found and deleted
	 */
	public abstract boolean delete(String toDelete);

	/**
	 * Return The number of elements currently in the set
	 */
	public int size() {
		return this.numElements;
	}

	/**
	 * 
	 * @return The current capacity (number of cells) of the table.
	 */
	public abstract int capacity();

}
