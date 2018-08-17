package gcj.y2017.qualification;

import org.junit.jupiter.api.Test;

import gcj.Gcj;
import gcj.GcjTest;

public class BathroomStallsTest extends GcjTest {

	@Override
	public Gcj createGcjInstance() {
		return new BathroomStalls();
	}
	
	@Test
	public void testSmallPractice2() throws Exception {
		test(createGcjInstance(), "small-practice-2");
	}
}
