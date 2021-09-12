package counters;

import utility.Utils;

import java.util.TreeMap;

/**
 * This class reads the text file and extract every distinct character
 * to a tree map to naturally sort the characters based on the value.
 * The result is saved in a text file "1_Characters.txt" located in results folder
 */
public class CharacterCounter {

	private final String text;

	/**
	 * Takes in the text file as String variable
	 *
	 * @param text The complete text file
	 */
	public CharacterCounter(String text) {
		this.text = text;
	}

	/**
	 * Creates an array of all characters.
	 * Uses TreeMap to naturally order the characters based on their value
	 */
	public void count() {
		char[] charArray = text.toCharArray();
		// The output is automatically sorted based on the given key (character)
		TreeMap<Character, Integer> charTree = new TreeMap<>();
		for (char character : charArray) {
			// Remove spaces from the collection
			if (character == ' ') {
				continue;
			}
			// check if the character is distinct
			charTree.putIfAbsent(character, 0);
			// Increment the count
			charTree.put(character, charTree.get(character) + 1);
		}

		// Saves the output to a text file
		Utils.writeFile(charTree, "1_Characters.txt");
	}
}
