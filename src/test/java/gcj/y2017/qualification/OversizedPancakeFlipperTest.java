package gcj.y2017.qualification;

import org.junit.jupiter.api.Test;

import gcj.GcjTest;

public class OversizedPancakeFlipperTest extends GcjTest {
	
	@Test
	public void testExample() throws Exception {
		test(new OversizedPancakeFlipper(), "A-example");
	}
	
	@Test
	public void testSmallPractice() throws Exception {
		test(new OversizedPancakeFlipper(), "A-small-practice");
	}
	
	@Test
	public void testLargePractice() throws Exception {
		test(new OversizedPancakeFlipper(), "A-large-practice");
	}
}