import java.util.*;

/**
 * 
 * This class has a main method that measures the run-times requested in the
 * “Performance Analysis” section.
 * 
 * @author orlykor12
 * 
 */
public class SimpleSetPerformanceAnalyzer {
	protected static final int MILLION = 1000000;

	/**
	 * 
	 * Check if the values input are in the data structures. Check the time
	 * taken for it to check that.
	 * 
	 * @param hashSet
	 * @param value
	 */
	public static void ContainValue(SimpleSet hashSet, String value) {
		long timeBefore = 0;
		long timeAfter = 0;
		long difference = 0;
		timeBefore = System.nanoTime();
		hashSet.contains(value);
		timeAfter = System.nanoTime();
		difference = (timeAfter - timeBefore);
	}

	/**
	 * add the values to the data structure Check the time taken for it to add
	 * that.
	 * 
	 * @param hashSet
	 * @param arrayOfValues
	 */
	public static void AddValue(SimpleSet hashSet, String[] arrayOfValues) {
		long timeBefore = 0;
		long timeAfter = 0;
		long difference = 0;
		timeBefore = System.nanoTime();
		for (int value = 0; value < arrayOfValues.length; value++) {
			hashSet.add(arrayOfValues[value]);
		}
		timeAfter = System.nanoTime();
		difference = (timeAfter - timeBefore) / MILLION;

	}

	/**
	 * send the data structure and the data text needed to be put in the data
	 * structure to the add method
	 * 
	 * @param arrayDataStructure
	 * @param WordsInData
	 */
	public static void Add(SimpleSet[] arrayDataStructure, String[] WordsInData) {
		for (int i = 0; i < arrayDataStructure.length; i++) {
			AddValue(arrayDataStructure[i], WordsInData);
		}
	}

	/**
	 * send the data structure and the data text needed to be put in the data
	 * structure to the contain method
	 * 
	 * @param arrayDataStructure
	 * @param WordsInData
	 */

	public static void Contain(SimpleSet[] arrayDataStructure,
			String[] valuesArray) {
		for (int i = 0; i < arrayDataStructure.length; i++) {
			for (int j = 0; j < valuesArray.length; j++) {
				ContainValue(arrayDataStructure[i], valuesArray[j]);
			}
		}
	}

	/**
	 * the main method that runs the implemented checks
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/** The value to check in data 1 and 2*/
		final String VALUE1 = "hi";
		
		/** The value to check in data 1*/
		final String VALUE2 = "-13170890158";
		
		/** The value to check in data 2*/
		final String VALUE3 = "23";
		
		/** Data1*/
		String[] WordsInData1 = Ex3Utils.file2array("src/data1.txt");
		
		/** Data2*/
		String[] WordsInData2 = Ex3Utils.file2array("src/data2.txt");

		
		ChainedHashSet chainedHaseSet = new ChainedHashSet();
		OpenHashSet openHashSet = new OpenHashSet();
		CollectionFacadeSet treeSet = new CollectionFacadeSet(
				new TreeSet<String>());
		CollectionFacadeSet linkedList = new CollectionFacadeSet(
				new LinkedList<String>());
		CollectionFacadeSet hashSet = new CollectionFacadeSet(
				new HashSet<String>());

		SimpleSet[] arrayDataStructure = new SimpleSet[] { chainedHaseSet,
				openHashSet, treeSet, linkedList, hashSet };

		String[] valuesArray1 = new String[] { VALUE1, VALUE2 };
		String[] valuesArray2 = new String[] { VALUE1, VALUE3 };

		String[][] allValues = new String[][] { valuesArray2, valuesArray1 };
		String[][] allData = new String[][] { WordsInData2, WordsInData1 };

		for (int i = 0; i < allValues.length; i++) {
			Contain(arrayDataStructure, allValues[i]);
		}

		for (int i = 0; i < allData.length; i++) {
			Add(arrayDataStructure, allData[i]);
		}
	}
}
