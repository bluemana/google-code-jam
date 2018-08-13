package gcj.y2017.qualification;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OversizedPancakeFlipperTest {
	
	@Test
	public void testExample() throws Exception {
		test("A-example");
	}
	
	@Test
	public void testSmallPractice() throws Exception {
		test("A-small-practice");
	}
	
	@Test
	public void testLargePractice() throws Exception {
		test("A-large-practice");
	}
	
	private static void test(String resourcePrefix) throws Exception {
		try (BufferedReader inputReader = getResourceReader(resourcePrefix + ".in");
				BufferedReader expectedReader = getResourceReader(resourcePrefix + ".out")) {
			StringWriter writer = new StringWriter();
			OversizedPancakeFlipper.solve(inputReader, writer);
			assertEquals(expectedReader, writer);
		}
	}
	
	private static BufferedReader getResourceReader(String resourceName) {
		InputStream inputStream = OversizedPancakeFlipper.class.getResourceAsStream(resourceName);
		return new BufferedReader(new InputStreamReader(inputStream));
	}
	
	private static void assertEquals(BufferedReader expectedReader, StringWriter actual) throws Exception {
		StringBuffer buffer = actual.getBuffer();
		String expectedLine;
		int start = 0;
		int lineCount = 0;
		while ((expectedLine = expectedReader.readLine()) != null) {
			String actualLine = buffer.substring(start, start + expectedLine.length());
			Assertions.assertEquals(expectedLine, actualLine, String.format("Line %d (1-based)", lineCount + 1));
			start += expectedLine.length() + 1; // We count \n as well
			lineCount++;
		}
		Assertions.assertEquals(start, buffer.length(), "Characters count");
	}
}