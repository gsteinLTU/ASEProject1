package edu.ltu.stringreporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFileChooser;

public class StringReporter {

	public static void main(String[] args) {
		// Welcome user
		System.out.println("Welcome to StringReporter!");
		System.out
				.println("Please select a .txt file to create a report from...");

		// Wait one second to allow user to read output
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Prompt for input file
		JFileChooser openDialog = new JFileChooser();

		if (openDialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			// User has selected a file
			try {
				handleFile(openDialog.getSelectedFile());
			} catch (IllegalArgumentException e) {
				System.out
						.println("Invalid file type selected. This program requires a .txt file. The program will now exit.");
			} catch (IOException e) {
				System.out
						.println("Error reading file. The program will now exit.");
			}

		} else {
			// User has not selected a file
			System.out.println("No file selected. The program will now exit.");
		}
	}

	/**
	 * Determines unique words and outputs them, their lengths, and their
	 * frequencies
	 * 
	 * @param file
	 *            The File to load from
	 * @throws IllegalArgumentException
	 *             If file is not supported
	 * @throws IOException
	 *             If error occurs reading from file
	 */
	public static void handleFile(File file) throws IllegalArgumentException,
			IOException {
		if (file.isDirectory() || !file.getName().endsWith(".txt")) {
			throw new IllegalArgumentException("File must be a .txt file");
		}

		// Get file content
		BufferedReader br = null;
		StringBuilder builder = new StringBuilder();
		
		try {
			br = new BufferedReader(new FileReader(file));

			String line = br.readLine();

			// Read file line by line
			while (line != null) {
				builder.append(line);
				builder.append(" ");
				line = br.readLine();
			}
		} finally {
			// Clean up
			if (br != null) {
				br.close();
			}
		}

		String fileContents = builder.toString();

		// Display output
		ArrayList<String> words = getUniqueWords(fileContents);

		System.out.println("Words in document:");

		for (String word : words) {
			System.out.print(word);
			System.out
					.print(" (" + getWordLength(word) + " characters long): ");

			int frequency = getWordFrequency(fileContents, word);

			// Change message if only one occurrence
			System.out.println(frequency
					+ (frequency > 1 ? " occurrences" : " occurrence"));
		}
	}

	/**
	 * Determine unique words in the document
	 * 
	 * @param document
	 *            String of document text
	 * @return List of unique words, in alphabetical order
	 */
	public static ArrayList<String> getUniqueWords(String document) {
		ArrayList<String> wordslist = new ArrayList<String>();

		document = document.toLowerCase();

		// Read document
		for (String word : document.split("[^\\w-]+")) {
			word = word.trim();

			// Skip blanks
			if (word.length() < 1) {
				continue;
			}

			if (!wordslist.contains(word)) {
				wordslist.add(word); // First time occurance
			}
		}

		Collections.sort(wordslist);// Sort to alphabetical order

		return wordslist;
	}

	/**
	 * Count occurrences of a word in the document
	 * 
	 * @param document
	 *            String of document text
	 * @param word
	 *            Word to count occurrences of
	 * @return Number of times word appears in the document
	 * @throws IOException
	 */
	public static int getWordFrequency(String document, String word)
			throws IOException {
		int count = 0; // declaration and initialization of counter
		String[] eachW = document.split("[^\\w-]+"); // Splitting the string by
														// spaces and
														// punctuation
		for (int i = 0; i < eachW.length; i++) {
			if (eachW[i].equalsIgnoreCase(word)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Determine the length of a word
	 * 
	 * @param word
	 *            Word to count letters in
	 * @return Number of letters in word
	 */
	public static int getWordLength(String word) {
		String w = word.replaceAll("[\\-\\+\\.\\^:,]", ""); // Removing specific
															// characters.
		int wLength = w.trim().length(); // trimming white spaces and
											// calculating the length of the
											// word.
		return wLength;
	}

}
