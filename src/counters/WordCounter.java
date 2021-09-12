package counters;

import utility.Utils;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Return a list of distinct words and their respective counts ordered alphabetically.
 */
public class WordCounter {

	private String text;

	/**
	 * Construct an instance with the given text file
	 *
	 * @param text Complete text file as a string
	 */
	public WordCounter(String text) {
		this.text = text;
		modifyText();
	}

	/**
	 * Filter all non-word characters and creates a space delimited string that then can be looked for words
	 * and their respective count
	 */
	private void modifyText() {
		// All the characters to be replaced with space in the text file
		String[] charReplace = {"!", "\"", "#", "$", "%", "(", ")", "*", "+", ",", "--", ".", "/", "0",
				"1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "[", "\\",
				"]", "_", "`", "{", "}", "¶", "—", "‘", "“", "”", "♪"};

		// Simply iterate through the array and replace all the matching characters in the text with space
		Arrays.stream(charReplace).forEach(c -> text = text.replace(c, " "));

		// Convert to lower case to be able to count repeating words
		text = text.toLowerCase();
		// Removing more than one space between characters
		text = text.replaceAll("\\s\\s+", " ");
		// Removing '-' char without a word around it (not removing a word like arm-chair)
		text = text.replaceAll("\\s+-+\\s+", " ");
		// Removing '-' with no word after (like UTF-)
		text = text.replaceAll("-+\\s+", " ");
		// Removing '’' special char with space around it (not removing a word you’re)
		// Contracted words are counted as one word
		text = text.replaceAll("\\s+’+\\s+", " ");
		// Removing '’' with following space
		text = text.replaceAll("’+\\s+", " ");
		// Removing a set of characters that don't contain a vowel
		text = text.replaceAll("\\s+[^aeiouy]+\\b", " ");
	}

	/**
	 * Creates a space delimited array from the text string
	 * Populate TreeMap<word, count> from the array to naturally order and remove the duplicates
	 * Writes the TreeMap to the output file in "Results" directory
	 *
	 * @return Alphabetically sorted word list
	 */
	public Map<String, Integer> count() {
		String[] wordArray = text.split(" ");

		// Automatically sort the collection based on the key
		TreeMap<String, Integer> wordTree = new TreeMap<>();
		for (String word : wordArray) {
			wordTree.putIfAbsent(word, 0);
			wordTree.put(word, wordTree.get(word) + 1);
		}

		// Saving the output to the file
		Utils.writeFile(wordTree, "3_Words.txt");
		// The returned collection is used for the 5th challenge
		return wordTree;
	}

}
