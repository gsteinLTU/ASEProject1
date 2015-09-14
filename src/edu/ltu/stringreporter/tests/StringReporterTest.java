/**
 * 
 */
package edu.ltu.stringreporter.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import edu.ltu.stringreporter.StringReporter;

/**
 * @author gstein
 *
 */
public class StringReporterTest {

	/**
	 * Test method for
	 * {@link edu.ltu.stringreporter.StringReporter#handleFile(java.io.File)}.
	 */
	@Test
	public void testHandleFile() {
		// Test that txt file works
		try {
			StringReporter.handleFile(new File("test.txt"));
		} catch (Exception e) {
			fail("Exception thrown for valid file");
		}

		// Test that non-txt file doesn't work
		try {
			StringReporter.handleFile(new File("test.png"));
		} catch (Exception e) {
			return;
		}

		fail("Exception not thrown for invalid file");
	}

	/**
	 * Test method for
	 * {@link edu.ltu.stringreporter.StringReporter#getUniqueWords(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetUniqueWords() {
		String file = "one two three one";

		ArrayList<String> WordslistTestExpected = new ArrayList<String>();
		WordslistTestExpected.add("one");
		WordslistTestExpected.add("three");
		WordslistTestExpected.add("two");

		// Tests that words are returned and in correct order
		ArrayList<String> WordslistTest = StringReporter.getUniqueWords(file);
		assertEquals(WordslistTestExpected, WordslistTest);
	}

	/**
	 * Test method for
	 * {@link edu.ltu.stringreporter.StringReporter#getWordFrequency(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testGetWordFrequency() {
		String s = "hello kiran hello jonhny hello gordon";
		String[] each = s.split(" "); // Splitting the string by spaces
		int cnt = 0; // counter
		String kWord = "hello"; // place the unique word that needs to know the
								// frequency of that word
		for (int i = 0; i < each.length; i++) {
			if (each[i].equals(kWord)) {
				cnt++;
			}
		}
		assertEquals(cnt, StringReporter.getWordFrequency(s, kWord));
		
		// Additional tests
		assertEquals(0, StringReporter.getWordFrequency(s, "test"));
		assertEquals(1, StringReporter.getWordFrequency(s, "kiran"));
		assertEquals(0, StringReporter.getWordFrequency(s, "johnny"));
		assertEquals(1, StringReporter.getWordFrequency(s, "jonhny"));
		assertEquals(1, StringReporter.getWordFrequency(s, "gordon"));
	}

	/**
	 * Test method for
	 * {@link edu.ltu.stringreporter.StringReporter#getWordLength(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetWordLength() {
		String w = "kiran";
		int wLength = w.trim().length();
		
		// Test that length is same
		assertEquals(wLength, StringReporter.getWordLength("kiran"));
		
		// Test that length is correct for hyphenated words
		assertEquals(13, StringReporter.getWordLength("computer-aided"));
	}

}
