/**
 * 
 */
package edu.ltu.stringreporter.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import edu.ltu.stringreporter.StringReporter;

/**
 * @author gstein
 *
 */
public class StringReporterTestNG {

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
			Assert.fail("Exception thrown for valid file");
		}

		// Test that non-txt file doesn't work
		try {
			StringReporter.handleFile(new File("test.png"));
		} catch (Exception e) {
			return;
		}

		Assert.fail("Exception not thrown for invalid file");
	}

	/**
	 * Test method for
	 * {@link edu.ltu.stringreporter.StringReporter#getUniqueWords(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetUniqueWords() {
		String file = "one two three.\n\"One, two, three!\"";

		ArrayList<String> WordslistTestExpected = new ArrayList<String>();
		WordslistTestExpected.add("one");
		WordslistTestExpected.add("three");
		WordslistTestExpected.add("two");

		// Tests that words are returned and in correct order
		ArrayList<String> WordslistTest = StringReporter.getUniqueWords(file);
		AssertJUnit.assertEquals(WordslistTestExpected, WordslistTest);
	}

	/**
	 * Test method for
	 * {@link edu.ltu.stringreporter.StringReporter#getWordFrequency(java.lang.String, java.lang.String)}
	 * .
	 * @throws IOException 
	 */
	@Test
	public void testGetWordFrequency() throws IOException {
		String teststring = "Hello Kiran! Hello Jonhny. Hello, Gordon. Is that 'hello' to everyone?";
		String s = "hello kiran hello jonhny hello gordon is that hello to everyone";

		String[] each = s.split(" "); // Splitting the string by spaces
		int cnt = 0; // counter
		String kWord = "hello"; // place the unique word that needs to know the
								// frequency of that word
		for (int i = 0; i < each.length; i++) {
			if (each[i].equalsIgnoreCase(kWord)) {
				cnt++;
			}
		}
		AssertJUnit.assertEquals(cnt, StringReporter.getWordFrequency(s, kWord));
		
		// Additional tests
		AssertJUnit.assertEquals(0, StringReporter.getWordFrequency(teststring, "test"));
		AssertJUnit.assertEquals(1, StringReporter.getWordFrequency(teststring, "kiran"));
		AssertJUnit.assertEquals(0, StringReporter.getWordFrequency(teststring, "johnny"));
		AssertJUnit.assertEquals(1, StringReporter.getWordFrequency(teststring, "jonhny"));
		AssertJUnit.assertEquals(1, StringReporter.getWordFrequency(teststring, "gordon"));
		AssertJUnit.assertEquals(1, StringReporter.getWordFrequency(teststring, "everyone"));
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
		AssertJUnit.assertEquals(wLength, StringReporter.getWordLength("kiran"));
		
		// Test that length is correct for hyphenated words
		AssertJUnit.assertEquals(13, StringReporter.getWordLength("computer-aided"));
	}

}
