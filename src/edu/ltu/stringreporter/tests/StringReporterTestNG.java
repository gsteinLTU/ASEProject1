package edu.ltu.stringreporter.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import edu.ltu.stringreporter.StringReporter;

public class StringReporterTestNG {
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

	@Test
	public void testGetUniqueWords() {
		String file = "one two three.\n\"One, two, three!\"";

		ArrayList<String> WordslistTestExpected = new ArrayList<String>();
		WordslistTestExpected.add("one");
		WordslistTestExpected.add("three");
		WordslistTestExpected.add("two");

		// Tests that words are returned and in correct order
		ArrayList<String> WordslistTest = StringReporter.getUniqueWords(file);
		Assert.assertEquals(WordslistTestExpected, WordslistTest);
	}

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
		Assert.assertEquals(cnt, StringReporter.getWordFrequency(s, kWord));

		// Additional tests
		Assert.assertEquals(0,
				StringReporter.getWordFrequency(teststring, "test"));
		Assert.assertEquals(1,
				StringReporter.getWordFrequency(teststring, "kiran"));
		Assert.assertEquals(0,
				StringReporter.getWordFrequency(teststring, "johnny"));
		Assert.assertEquals(1,
				StringReporter.getWordFrequency(teststring, "jonhny"));
		Assert.assertEquals(1,
				StringReporter.getWordFrequency(teststring, "gordon"));
		Assert.assertEquals(1,
				StringReporter.getWordFrequency(teststring, "everyone"));
	}

	@Test
	public void testGetWordLength() {
		String w = "kiran";
		int wLength = w.trim().length();

		// Test that length is same
		Assert.assertEquals(wLength, StringReporter.getWordLength("kiran"));

		// Test that length is correct for hyphenated words
		Assert.assertEquals(13, StringReporter.getWordLength("computer-aided"));
	}
}
