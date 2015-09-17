package edu.ltu.stringreporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;
//import java.io.*;
import java.util.*;


import javax.swing.JFileChooser;


public class StringReporter {
	// Hashmap use to storage the value of the the word (string) and the frequency (integer)  
	

	public static void main(String[] args) {
		System.out.println("Welcome to StringReporter!");
		System.out.println("Please select a .txt file to create a report from...");
		
		// Wait one second to allow user to read output
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Prompt for input file
		JFileChooser openDialog = new JFileChooser();
		
		if(openDialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			// User has selected a file
			try{
				handleFile(openDialog.getSelectedFile());
			} catch(IllegalArgumentException e){
				System.out.println("Invalid file type selected. This program requires a .txt file. The program will now exit.");
			} catch(IOException e){
				System.out.println("Error reading file. The program will now exit.");
			}
			
		} else {
			// User has not selected a file
			System.out.println("No file selected. The program will now exit.");	
		}
	}
	
	
	
	/**
	 * Determines unique words and outputs them, their lengths, and their frequencies
	 * @param file The File to load from
	 * @throws IllegalArgumentException If file is not supported
	 * @throws IOException If error occurs reading from file
	 */
	public static void handleFile(File file) throws IllegalArgumentException, IOException {
		if(file.isDirectory() || !file.getName().endsWith(".txt")){
			throw new IllegalArgumentException("File must be a .txt file");
		}
		
		// Get file content
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuilder builder = new StringBuilder();
		String line = br.readLine();
		
		// Read file line by line
		while(line != null){	
			builder.append(line);
			builder.append(" ");		
			line = br.readLine();
		}
		br.close();
		String fileContents = builder.toString();
		
		// Display output
		ArrayList<String> words = getUniqueWords(fileContents);
		
		System.out.println("Words in document:");
		
		for(String word : words){
			System.out.print(word);
			System.out.print(" (" + getWordLength(word) + " characters long): ");
			System.out.println(getWordFrequency(words, word) + " occurances");
		}
		
	}
	
	/**
	 * Determine unique words in the document
	 * @param document String of document text
	 * @return List of unique words, in alphabetical order
	 */
	static ArrayList<String> getUniqueWords(String fileContents)  
	{
	    
		ArrayList<String> wordsArrayList = new ArrayList<String>();
		for(String word : fileContents.split("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+")) {
		    wordsArrayList.add(word.toUpperCase());
		}
	    Collections.sort(wordsArrayList);// in alphabetical order
		return wordsArrayList;

	  }

	
	
	
	
	/**
	 * Count occurrences of a word in the document
	 * @param document String of document text
	 * @param word Word to count occurrences of
	 * @return Number of times word appears in the document
	 */
	static int getWordFrequency(ArrayList<String> words, String word){
	   Integer counter=0;
		
		for (String WordSelection : words) {
            if(WordSelection.matches(word)){
            	counter++;
            }
        }
		
		return counter;
	}
		/**
	 * Determine the length of a word
	 * @param word Word to count letters in
	 * @return Number of letters in word
	 */
	public static int getWordLength(String word){
		int WorldLenght = word.length();
		return WorldLenght;
	}	
}
