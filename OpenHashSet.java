/**
 * In this model of OpenHashSet each cell in the hash table is a reference to a String. When a new string is 
 * mapped to an occupied cell, there’s need to probe further in the array to find an empty spot.
 * this model uses quadratic probing inorder to do that.
 * @author orlykor12
 *
 */
public class OpenHashSet extends SimpleHashSet {

	/** The table */
	private String[] table;
	
	/** The flag that point the deleted place in the table */
	protected final static String DELETED = new String ("deleted");
		
	
	/**
	 * A default constructor. Constructs a new, empty table with default initial
	 * capacity, upper load factor and lower load factor.
	 */
	public OpenHashSet() {
		super();
		this.table = new String[SIZE_CAPACITY];
	}

	/**
	 * Constructs a new, empty table with the specified load factors, and the
	 * default initial capacity.
	 * 
	 * @param upperLoadFactor
	 * @param lowerLoadFactor
	 */
	public OpenHashSet(float upperLoadFactor, float lowerLoadFactor) {
		super(upperLoadFactor, lowerLoadFactor);
		this.table = new String[SIZE_CAPACITY];

	}

	/**
	 * Data constructor - builds the hash set by adding the elements one by one.
	 * Duplicate values should be ignored. The new table has the default values
	 * of initial capacity, upper load factor, and lower load factor.
	 * 
	 * @param data
	 */
	public OpenHashSet(java.lang.String[] data) {
		super();
		this.table = new String[SIZE_CAPACITY];
		for (int i = 0; i < data.length; i++) {
			add(data[i]);
		}
	}

	/**
	 * Add a specified element to the set if it's not already in it.
	 * 
	 * @param newValue
	 * @return False iff newValue already exists in the set
	 */
	public boolean add(java.lang.String newValue) {
		if (newValue == null) {
			return false;
		}
		if (getIndexOf(newValue) == NOT_EQUAL && newValue != DELETED) {
			int newLength = this.table.length - 1;
			int i = INITIALIZE_VALUE;
			int hashValue = newValue.hashCode() & newLength;
			while (this.table[ hashValue] != null) {
				i++;
				hashValue = (hashValue + (i + i * i) / BYTWO) & newLength;
			}
			this.table[hashValue] = newValue;
			this.numElements++;
			if ((float) size() / capacity() > this.upperLoad) {
				Rehash(this.table.length * BYTWO);
			}
			return true;
		}
		return false;
	}

	/**
	 * Remove the input element from the set.
	 * 
	 * @param toDelete
	 * @return True iff toDelete is found and deleted
	 */
	public boolean delete(java.lang.String toDelete) {
		if (toDelete == null || getIndexOf(toDelete) == NOT_EQUAL) {
			return false;
		} else {
			this.table[getIndexOf(toDelete)] = DELETED;
			this.numElements--;
			if ((float) size() / capacity() < this.lowerLoad) {
				Rehash(this.table.length / BYTWO);
			}
			return true;
		}
	}

	/*
	 * Check if there is a string in the table that is equal to the given
	 * string.
	 * 
	 * @param searchVal
	 * 
	 * @return the index of the equal string in the table, if not found return
	 * -1.
	 */
	protected int getIndexOf(String searchVal) {
		int newLength = this.table.length - 1;
		int i = INITIALIZE_VALUE;
		int hashValue = searchVal.hashCode() & newLength;
		while (this.table[hashValue] != null) {
			if (this.table[hashValue].equals(searchVal)) {
				return hashValue;
			}
			i++;
			hashValue = (hashValue + (i + i * i) / BYTWO) & newLength;
		}
		return NOT_EQUAL;
	}

	/*
	 * Rebuild the table. it inserts all the elements of the old table to the
	 * new one.
	 * 
	 * @param length
	 */
	private void Rehash(int length) {
		String[] OldTable = new String[this.table.length];
		for (int elem = 0; elem < this.table.length; elem++) {
			OldTable[elem] = this.table[elem];
		}
		this.table = new String[length]; // this is the new list now
		if (capacity() >= LOW_CAPACITY) {
			numElements = INITIALIZE_VALUE;
			for (int i = 0; i < OldTable.length; i++) {
				add(OldTable[i]);
			}
		}
	}

	
	/**
	 * 
	 * @return The current capacity (number of cells) of the table.
	 */
	public int capacity() {
		return this.table.length;
	}


}
