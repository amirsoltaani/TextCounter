package main;

import counters.CharacterCounter;
import counters.PunctuationCounter;
import counters.TopWordCounter;
import counters.WordCounter;
import utility.Utils;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Amir Soltani
 * @version 9/12/2021
 * <p>
 * This is the main class for the text counter application.
 * This application provide solution to 1st, 2nd, 3rd, 5th challenges of the question.
 * User can choose between the two provided txt files to test the application.
 * <p>
 * After successful run the application create a txt four txt files in the "results" folder located in the root directory
 */
public class AppDriver {
	public static void main(String[] args) {
		// Takes the user input
		String fileName = userInput();
		// Read the text file
		String text = Utils.readFile(fileName);

		// First challenge
		CharacterCounter characterCounter = new CharacterCounter(text);
		characterCounter.count();

		// Second challenge
		PunctuationCounter punctuationCounter = new PunctuationCounter(text);
		punctuationCounter.count();

		// Third challenge
		WordCounter wordCounter = new WordCounter(text);
		Map<String, Integer> wordMap = wordCounter.count();

		// Fifth challenge
		TopWordCounter topWordCounter = new TopWordCounter(wordMap);
		topWordCounter.count(20, true);
	}

	/**
	 * print the interface and takes in the user's input.
	 *
	 * @return fileName name of the text file that user selects
	 */
	public static String userInput() {

		System.out.println(".-------------------------------Text Counter-------------------------------.");
		System.out.println("|																		   |");
		System.out.println("|       Which of the given text files do you wish to put to the test?      |");
		System.out.println("|		1.	A Tale of Two Cities - Charles Dickens  				 	   |");
		System.out.println("|		2.	Alices Adventures in Wonderland - Lewis Carroll 			   |");
		System.out.println("| 																		   |");
		System.out.println(".--------------------------------------------------------------------------.");
		System.out.print("	* provide an integer value (1 or 2): ");

		Scanner in = new Scanner(System.in);
		String fileName = "";
		try {
			int i = in.nextInt();
			if (i == 1) {
				fileName = "A Tale of Two Cities - Charles Dickens.txt";
			} else if (i == 2) {
				fileName = "Alices Adventures in Wonderland - Lewis Carroll.txt";
			} else {
				throw new InputMismatchException();
			}
		} catch (InputMismatchException e) {
			System.out.println("please provide a valid input! (1, 2)");
		}
		return fileName;
	}
}
