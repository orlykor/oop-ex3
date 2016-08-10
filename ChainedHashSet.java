/**
 * In this model of ChainedHashSet, each cell in the hash table is a list
 * (“bucket”), and an element with the hash k is added to the k’th bucket.
 * 
 * @author orlykor12
 * 
 */
public class ChainedHashSet extends SimpleHashSet {

	/** The instance of a linkedlist */
	LinkedListHelper linkedList = new LinkedListHelper();

	/** The table */
	private LinkedListHelper[] table;

	
	/**
	 * A default constructor. Constructs a new, empty table with default initial
	 * capacity, upper load factor and lower load factor.
	 */
	public ChainedHashSet() {
		super();
		this.table = new LinkedListHelper[SIZE_CAPACITY];

	}

	/**
	 * Constructs a new, empty table with the specified load factors, and the
	 * default initial capacity.
	 * 
	 * @param upperLoadFactor
	 * @param lowerLoadFactor
	 */
	public ChainedHashSet(float upperLoadFactor, float lowerLoadFactor) {
		super(upperLoadFactor, lowerLoadFactor);
		this.table = new LinkedListHelper[SIZE_CAPACITY];
	}

	/**
	 * Data constructor - builds the hash set by adding the elements one by one.
	 * Duplicate values should be ignored. The new table has the default values
	 * of initial capacity, upper load factor, and lower load factor.
	 * 
	 * @param data
	 */
	public ChainedHashSet(java.lang.String[] data) {
		super();
		this.table = new LinkedListHelper[SIZE_CAPACITY];
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
		if (getIndexOf(newValue) == NOT_EQUAL) {
			int newLength = this.table.length - 1;
			int hashValue = newValue.hashCode() & newLength;
			if (table[hashValue] == null) {
				table[hashValue] = new LinkedListHelper();

			}
			this.table[hashValue].add(newValue);
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
	public boolean delete(String toDelete) {
		if (toDelete == null || getIndexOf(toDelete) == NOT_EQUAL) {
			return false;
		} else {
			this.table[getIndexOf(toDelete)].remove(toDelete);
			this.numElements--;
			if ((float) size() / capacity() < this.lowerLoad) {
				Rehash(this.table.length / BYTWO);
			}
		}
		return true;
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
		int hashValue = searchVal.hashCode();
		int newLength = this.table.length - 1;
		int index = hashValue & newLength;
		if (this.table[index] != null) {
			if (this.table[index].contains(searchVal)) {
				return index;
			}
		}
		return NOT_EQUAL;
	}


	/*
	 * Rebuild the table. it inserts all the elements of the old table to the
	 * new one.
	 * 
	 * @param length
	 */
	protected void Rehash(int length) {
		LinkedListHelper[] OldTable = new LinkedListHelper[this.table.length];
		for (int elem = 0; elem < this.table.length; elem++) {
			OldTable[elem] = this.table[elem];
		}
		this.table = new LinkedListHelper[length]; // this is the new list now
		if (capacity() >= LOW_CAPACITY) {
			numElements = INITIALIZE_VALUE;
			for (int i = 0; i < OldTable.length; i++) {
				if (OldTable[i] != null) {
					for (int j = 0; j < OldTable[i].size(); j++) {
						String[] string = OldTable[i].toArray();
						add(string[j]);
					}
				}
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
