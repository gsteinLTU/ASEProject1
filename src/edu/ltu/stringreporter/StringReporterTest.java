/**
 * 
 */
package edu.ltu.stringreporter;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
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
		ArrayList<String> WordslistTestExpected =  new ArrayList<String>();
		WordslistTestExpected.add("one");
		WordslistTestExpected.add("two");
		WordslistTestExpected.add("three");

		try {
			ArrayList<String> WordslistTest = StringReporter.getUniqueWords("test.txt");
			assertEquals(WordslistTestExpected,WordslistTest);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ltu.stringreporter.StringReporter#getWordFrequency(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetWordFrequency() {
		int WorldFrequency = 0;
		//String TestString = "Class";
		// Run  the  StringReporter.getUniqueWords(document) first 
		
		int WorldFrequencyResult = StringReporter.getWordFrequency("the");
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
