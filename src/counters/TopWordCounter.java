package counters;

import utility.Utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Return top "X" used words (with an option to include or exclude conjunctions) and their counts
 * where "X" is a passed in parameter.
 */
public class TopWordCounter {

	private HashMap<String, Integer> wordHash;

	/**
	 * Construct an instance of the class where sorted collection of all the words from the files is passed
	 * to create a LinkedHashMap
	 *
	 * @param wordMap Sorted collection of words from the file (returned from the 4th challenge)
	 */
	public TopWordCounter(Map<String, Integer> wordMap) {
		this.wordHash = new LinkedHashMap<>(wordMap);
	}

	/**
	 * Takes the number of words and a boolean to exclude or include conjunctions
	 *
	 * @param topWords           Number of words to be printed to the file
	 * @param excludeConjunction Boolean where true exclude conjunctions and false include conjunctions
	 */
	public void count(int topWords, boolean excludeConjunction) {
		if (excludeConjunction) {
			removeConjunction();
		}

		// Descending sorted collection from most frequent to the least frequent
		wordHash = Utils.sortByValue(wordHash);
		// Output the result in the text file
		showResult(topWords);
	}

	/**
	 * Takes in the number of words and print the top X used words to the text file
	 *
	 * @param topWords Number of words to be included in the text file
	 */
	private void showResult(int topWords) {
		// Using LinkedHashMap to preserve a custom order
		HashMap<String, Integer> topHash = new LinkedHashMap<>();
		int counter = 0;
		// Using Entry interface to iterate through the collection
		for (Map.Entry<String, Integer> entry : wordHash.entrySet()) {
			topHash.put(entry.getKey(), entry.getValue());
			counter++;
			if (counter == topWords) {
				break;
			}
		}
		// Write the output to the file in the "Results" directory
		Utils.writeFile(topHash, "5_TopWords.txt");
	}

	/**
	 * Remove all the conjunctions from the text file
	 * based on the NLTK's list of English stop words
	 *
	 * @see <a href="https://gist.github.com/sebleier/554280">NLTK's list of english stopwords</a>
	 */
	private void removeConjunction() {

		String[] conjunctions = {"a", "about", "above", "after", "again", "against", "all", "am", "an", "and",
				"any", "are", "as", "at", "be", "because", "been", "before", "being", "below", "between",
				"both", "but", "by", "can", "did", "do", "does", "doing", "don", "down", "during",
				"each", "few", "for", "from", "further", "had", "has", "have", "having", "he", "her", "here", "hers",
				"herself", "him", "himself", "his", "how", "i", "if", "in", "into", "is", "it", "its", "itself", "just",
				"me", "more", "most", "my", "myself", "no", "nor", "not", "now", "of", "off", "on",
				"once", "only", "or", "other", "our", "ours", "ourselves", "out", "over", "own", "s",
				"same", "she", "should", "so", "some", "such", "t", "than", "that", "the", "their", "theirs",
				"them", "themselves", "then", "there", "these", "they", "this", "those", "through", "to", "too", "under",
				"until", "up", "very", "was", "we", "were", "what", "when", "where", "which", "while", "who", "whom",
				"why", "will", "with", "you", "your", "yours", "yourself", "yourselves"};

		// Simply remove every conjunction from the string
		for (String c : conjunctions) {
			wordHash.remove(c);
		}
	}
}
