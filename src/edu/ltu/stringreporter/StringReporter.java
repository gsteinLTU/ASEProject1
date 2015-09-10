package edu.ltu.stringreporter;

import java.io.File;
import java.util.ArrayList;
//import java.util.List;
import java.io.*;
import java.util.*;



public class StringReporter {

	
	
	
	/**
	 * Determines unique words and outputs them, their lengths, and their frequencies
	 * @param file The File to load from
	 */
	static void handleFile(File file){
		
	}
	
	/**
	 * Determine unique words in the document
	 * @param document String of document text
	 * @return List of unique words, in alphabetical order
	 */
	static ArrayList<String> getUniqueWords(String document) throws FileNotFoundException 
	{
	    HashMap<String, Integer> HashWordsOcurrance = new HashMap<String, Integer>(); 

	    // read text file
	    Scanner infile = new Scanner(new File(document));
	    while (infile.hasNext()) {
	      // not diferenciate between markation characters yet  	
	      String word = infile.next();
	      
	      
	      if(HashWordsOcurrance.containsKey(word)) {
	        
	        Integer count = (Integer)HashWordsOcurrance.get(word);
	        HashWordsOcurrance.put(word, new Integer(count.intValue() + 1));// Increment occurrance 
	      } else {
	        
	    	  HashWordsOcurrance.put(word, new Integer(1)); // First time occurance
	      }
	    }
	    infile .close();

	   
	    
	    ArrayList<String> Wordslist = new ArrayList<String>(HashWordsOcurrance.keySet());
	    Collections.sort(Wordslist);// in alphabetical order
	    
	    /*for (int i = 0; i < arraylist.size(); i++) {
	      String key = (String)arraylist.get(i);
	      Integer count = (Integer)map.get(key);
	      System.out.println(key + " --> " + count);
	    }*/
		return Wordslist;

	  }

	
	
	
	
	/**
	 * Count occurrences of a word in the document
	 * @param document String of document text
	 * @param word Word to count occurrences of
	 * @return Number of times word appears in the document
	 */
	static int getWordFrequency(String document, String word) throws FileNotFoundException{ 
		return 0;
	
	}
	
	/**
	 * Determine the length of a word
	 * @param word Word to count letters in
	 * @return Number of letters in word
	 */
	static int getWordLength(String word){
		int WorldLenght = word.length();
		return WorldLenght;
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
