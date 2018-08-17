package gcj;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringWriter;
import java.net.URL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class GcjTest {
	
	public abstract Gcj createGcjInstance();
	
	@Test
	public void testExample() throws Exception {
		test(createGcjInstance(), "example");
	}
	
	@Test
	public void testSmallPractice() throws Exception {
		test(createGcjInstance(), "small-practice");
	}
	
	@Test
	public void testLargePractice() throws Exception {
		test(createGcjInstance(), "large-practice");
	}

	protected static void test(Gcj gcj, String resourceName) throws Exception {
		String resourcePrefix = gcj.getProblemLetter() + "-" + resourceName;
		URL inputUrl = gcj.getClass().getResource(resourcePrefix + ".in");
		URL expectedUrl = gcj.getClass().getResource(resourcePrefix + ".out");
		assumeTrue(inputUrl != null && expectedUrl != null, "Resource file(s) not found");
		try (BufferedReader inputReader = new BufferedReader(new FileReader(new File(inputUrl.toURI())));
				BufferedReader expectedReader = new BufferedReader(new FileReader(new File(expectedUrl.toURI())))) {
			StringWriter writer = new StringWriter();
			gcj.solve(inputReader, writer);
			assertEquals(expectedReader, writer);
		}
	}
	
	private static void assertEquals(BufferedReader expectedReader, StringWriter actual) throws Exception {
		StringBuffer buffer = actual.getBuffer();
		String expectedLine;
		int startIndex = 0;
		int lineCount = 0;
		while ((expectedLine = expectedReader.readLine()) != null) {
			int endIndex = buffer.indexOf("\n", startIndex);
			if (endIndex == -1) {
				endIndex = buffer.length();
			}
			String actualLine = buffer.substring(startIndex, endIndex);
			Assertions.assertEquals(expectedLine, actualLine, String.format("Line %d (1-based)", lineCount + 1));
			startIndex += expectedLine.length() + 1; // We count \n as well
			lineCount++;
		}
		Assertions.assertEquals(startIndex, buffer.length(), "Characters count");
	}
}
