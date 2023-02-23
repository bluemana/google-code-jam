package gcj.y2017.qualification;

import org.junit.jupiter.api.Test;

import gcj.Gcj;
import gcj.GcjTest;

import java.io.BufferedReader;
import java.io.Writer;

public class BathroomStallsTest extends GcjTest {

	@Override
	public Gcj createGcjInstance() {
		return new Gcj() {

			public String getProblemLetter() {
				return BathroomStalls.PROBLEM_LETTER;
			}

			public void solve(BufferedReader reader, Writer writer) throws Exception {
				BathroomStalls.solve(reader, writer);
			}
		};
	}
	
	@Test
	public void testSmallPractice2() throws Exception {
		test(createGcjInstance(), "small-practice-2");
	}
}
