import java.util.LinkedList;

/**
 * This class represents a linked list. implements some of the LinkedList<E>
 * methods.
 * 
 * @author orlykor12
 */
public class LinkedListHelper {

	LinkedList<String> linkedList;

	public LinkedListHelper() {
		this.linkedList = new LinkedList<String>();

	}

	/**
	 * Add the given string to the linked list.
	 * 
	 * @param string
	 */
	public void add(String string) {
		this.linkedList.add(string);

	}

	/**
	 * Remove the given string from the linked list.
	 * 
	 * @param index
	 */
	public void remove(String string) {
		this.linkedList.remove(string);
	}

	/**
	 * Return true if this list contains the specified element.
	 * 
	 * @param oldTable
	 * @return true if this list contains the specified element.
	 */
	public boolean contains(String oldTable) {
		if (this.linkedList.contains(oldTable)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list.
	 */
	public int size() {
		return linkedList.size();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence 
	 * (from first to last element). The returned array will be "safe" in that no references to it are
	 * maintained by this list. 	 

	 * @return an array containing all of the elements in this list
	 */
	public String[] toArray() {
		return (String[]) linkedList.toArray(new String[linkedList.size()]);
	}

}
