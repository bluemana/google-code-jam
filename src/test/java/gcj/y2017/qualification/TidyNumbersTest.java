package gcj.y2017.qualification;

import org.junit.jupiter.api.Test;

import gcj.GcjTest;

public class TidyNumbersTest extends GcjTest {
	
	@Test
	public void testExample() throws Exception {
		test(new TidyNumbers(), "B-example");
	}
	
	@Test
	public void testSmallPractice() throws Exception {
		test(new TidyNumbers(), "B-small-practice");
	}
	
	@Test
	public void testLargePractice() throws Exception {
		test(new TidyNumbers(), "B-large-practice");
	}
}
