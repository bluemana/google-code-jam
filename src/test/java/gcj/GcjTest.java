package gcj;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.junit.jupiter.api.Assertions;

public class GcjTest {

	protected static void test(Gcj gcj, String resourcePrefix) throws Exception {
		try (BufferedReader inputReader = getResourceReader(gcj, resourcePrefix + ".in");
				BufferedReader expectedReader = getResourceReader(gcj, resourcePrefix + ".out")) {
			StringWriter writer = new StringWriter();
			gcj.solve(inputReader, writer);
			assertEquals(expectedReader, writer);
		}
	}
	
	private static BufferedReader getResourceReader(Gcj gcj, String resourceName) {
		InputStream inputStream = gcj.getClass().getResourceAsStream(resourceName);
		return new BufferedReader(new InputStreamReader(inputStream));
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
