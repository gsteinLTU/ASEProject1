/**
 * 
 */
package edu.ltu.stringreporter;

import static org.junit.Assert.*;

//import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * @author gstein
 *
 */
public class StringReporterTest {

	/**
	 * Test method for {@link edu.ltu.stringreporter.StringReporter#handleFile(java.io.File)}.
	 */
	@Test
	public void testHandleFile() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ltu.stringreporter.StringReporter#getUniqueWords(java.lang.String)}.
	 */
	@Test
	public void testGetUniqueWords() {
		
		String TestSentence = "one, one?three";
		ArrayList<String> WordslistTestExpected =  new ArrayList<String>();
		WordslistTestExpected.add("ONE");
		WordslistTestExpected.add("THREE");
		//WordslistTestExpected.add("TWO");
		

		
			ArrayList<String> WordslistTest = StringReporter.getUniqueWords(TestSentence);
			assertEquals(WordslistTestExpected,WordslistTest);
		
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ltu.stringreporter.StringReporter#getWordFrequency(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetWordFrequency() {
		int WorldFrequency = 2;
		
		String TestSentence = "one, one?three";
		ArrayList<String> WordslistTestExpected =  new ArrayList<String>();
		WordslistTestExpected.add("ONE");
		WordslistTestExpected.add("ONE");
		WordslistTestExpected.add("TWO");
		
		//String TestString = "Class";
		// Run  the  StringReporter.getUniqueWords(document) first 
		
		int WorldFrequencyResult = StringReporter.getWordFrequency(TestSentence,"ONE");
		assertEquals(WorldFrequency,WorldFrequencyResult);

	}

	/**
	 * Test method for {@link edu.ltu.stringreporter.StringReporter#getWordLength(java.lang.String)}.
	 */
	@Test
	public void testGetWordLength() {
		int WorldLenght = 5;
		//String TestString = "Class";
		int WorldLenghtResult = StringReporter.getWordLength("Class");
		assertEquals(WorldLenght,WorldLenghtResult);
		//fail("Not yet implemented");
	}

}
