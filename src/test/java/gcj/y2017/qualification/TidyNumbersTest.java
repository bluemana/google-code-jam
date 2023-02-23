package gcj.y2017.qualification;

import gcj.Gcj;
import gcj.GcjTest;

import java.io.BufferedReader;
import java.io.Writer;

public class TidyNumbersTest extends GcjTest {

	@Override
	public Gcj createGcjInstance() {
		return new Gcj() {

			public String getProblemLetter() {
				return TidyNumbers.PROBLEM_LETTER;
			}

			public void solve(BufferedReader reader, Writer writer) throws Exception {
				TidyNumbers.solve(reader, writer);
			}
		};
	}
}
