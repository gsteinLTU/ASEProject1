/**
 * 
 */
package edu.ltu.stringreporter.tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import edu.ltu.stringreporter.StringReporter;

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
		// Test that txt file works
		try{
			StringReporter.handleFile(new File("test.txt"));
		} catch(Exception e){
			fail("Exception thrown for valid file");
		}
		
		// Test that non-txt file doesn't work
		try{
			StringReporter.handleFile(new File("test.png"));
		} catch(Exception e){
			return;
		}
		
		fail("Exception not thrown for invalid file");
	}

	/**
	 * Test method for {@link edu.ltu.stringreporter.StringReporter#getUniqueWords(java.lang.String)}.
	 */
	@Test
	public void testGetUniqueWords() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ltu.stringreporter.StringReporter#getWordFrequency(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetWordFrequency() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ltu.stringreporter.StringReporter#getWordLength(java.lang.String)}.
	 */
	@Test
	public void testGetWordLength() {
		assertSame(1, StringReporter.getWordLength("a"));
		
		fail("Not yet implemented");
	}

}
