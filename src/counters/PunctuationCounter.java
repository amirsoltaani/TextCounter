package counters;

import utility.Utils;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * This class provide method to extract and sort all the punctuations from most frequent to the least frequent
 * alongside their count.
 * The output is written to a text file "2_Punctuation.txt" located in "Results" directory.
 */
public class PunctuationCounter {

	// Array of all punctuation
	private final char[] punctuationArray = {'.', '!', '?', ',', ':', ';', '“', '”', '‘', '’', '-', '_', '/', '’'};

	private final String text;

	/**
	 * Construct a new instance of the class with the given text string
	 *
	 * @param text complete text file as string
	 */
	public PunctuationCounter(String text) {
		this.text = text;
	}

	/**
	 * creates a collection of all punctuations as key value pairs
	 * where key is the character and the value is the number of occurrence.
	 */
	public void count() {
		char[] charArray = text.toCharArray();
		// Creating a LinkedHashMap since it requires a custom way of sorting
		HashMap<Character, Integer> punctuationHash = new LinkedHashMap<>();
		// Iterate through the collection and extract the punctuation
		for (char character : charArray) {
			if (isPunctuation(character)) {
				punctuationHash.putIfAbsent(character, 0);
				punctuationHash.put(character, punctuationHash.get(character) + 1);
			}
		}
		// Sorting the collection from most frequent to the least frequent
		punctuationHash = Utils.sortByValue(punctuationHash);

		// Output the collection to a file
		Utils.writeFile(punctuationHash, "2_Punctuation.txt");
	}

	/**
	 * Provide a validation to check if the passed character is a punctuation or not
	 *
	 * @param character Passed character to be checked against the punctuation array
	 * @return true if the character matches the punctuation array, false if it's not
	 */
	private boolean isPunctuation(char character) {
		for (char punctuation : punctuationArray)
			if (character == punctuation) return true;
		return false;
	}

}
