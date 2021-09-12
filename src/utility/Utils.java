package utility;

import java.io.*;
import java.util.*;

/**
 * Utility class that provide methods to read, write and sort collections
 */
public class Utils {
	/**
	 * Takes in the name and reads the text file.
	 * This method returns a string that contains the whole text file
	 *
	 * @param fileName relative path of the text file
	 * @return the text file as a String
	 */
	public static String readFile(String fileName) {
		StringBuilder sb = new StringBuilder();
		String s;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((s = br.readLine()) != null) {
				sb.append(s).append(" ");
			}
			br.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.exit(0);
		}
		// Removes the BOM (byte order mark) from head of the file and returns the result
		return sb.toString().replace("\uFEFF", "");
	}

	/**
	 * Provide a generic method that takes in the collection and its corresponding file name
	 * Using Entry interface it iterate through entry sets and write the key value pairs to the file.
	 * The result is saved in the "Results" directory
	 *
	 * @param map      Collection to be dumped to the file
	 * @param fileName Saved name of the output file
	 * @param <T>      Generic placeholder for the collection's key type
	 */
	public static <T> void writeFile(Map<T, Integer> map, String fileName) {
		try {
			File folder = new File("Results");
			folder.mkdir();
			BufferedWriter bw = new BufferedWriter(new FileWriter(folder.getName() + File.separator + fileName));
			// Iterate through the collection and writes the key value pairs to the file
			for (Map.Entry<T, Integer> entry : map.entrySet()) {
				bw.write(entry.getKey() + " : " + entry.getValue() + "\n");
			}
			bw.close();
			System.out.println(folder.getAbsolutePath() + File.separator + fileName + " has been created. ✔");
		} catch (IOException exception) {
			System.err.println(exception.getMessage());
		}
	}

	/**
	 * Returns a sorted collection based on the defined comparator method.
	 * The passed comparator to the collections sort method, order the collection from the most frequent
	 * to least frequent.
	 *
	 * @param hashMap Collection to be sorted
	 * @param <T>     Generic placeholder for the collection key type
	 * @return Descending sorted list of collection
	 */
	public static <T> HashMap<T, Integer> sortByValue(HashMap<T, Integer> hashMap) {
		// Creating a list from the hashMap
		List<Map.Entry<T, Integer>> list = new ArrayList<>(hashMap.entrySet());

		// Lambda expression to define the compare method of the Comparator interface using entry interface
		list.sort((Map.Entry<T, Integer> value1, Map.Entry<T, Integer> value2) -> (value2.getValue()).compareTo(value1.getValue()));

		// Using linkedHashMap to make sure that the order is saved
		HashMap<T, Integer> linkedHashMap = new LinkedHashMap<>();
		for (Map.Entry<T, Integer> set : list) {
			linkedHashMap.put(set.getKey(), set.getValue());
		}
		return linkedHashMap;
	}
}
